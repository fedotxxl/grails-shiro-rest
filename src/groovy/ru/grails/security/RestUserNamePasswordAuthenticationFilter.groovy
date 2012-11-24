package ru.grails.security

import org.apache.shiro.authc.AuthenticationToken
import org.apache.shiro.authc.UsernamePasswordToken
import org.apache.shiro.web.filter.authc.AuthenticatingFilter
import org.apache.shiro.web.util.WebUtils

import javax.servlet.ServletRequest
import javax.servlet.ServletResponse
import javax.servlet.http.HttpServletResponse

abstract class RestUsernamePasswordAuthenticationFilter extends AuthenticatingFilter {

    private RestService restService

    protected AuthenticationToken createToken(ServletRequest request, ServletResponse response) {
        def username = getUsername(request)
        def password = getPassword(request)

        return new UsernamePasswordToken(username as String, password as String)
    }

    protected boolean onAccessDenied(ServletRequest request, ServletResponse response) {
        if (executeLogin(request, response)) {
            //ok... login/password is correct.
            def username = getUsername(request)
            def token = generateAndSaveTokenForUser(username, request)

            //return token as answer
            response.outputStream << token
            return false
        } else {
            //failed to authenticate. Return 401
            HttpServletResponse httpResponse = WebUtils.toHttp(response);
            httpResponse.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            httpResponse.writer << "Authentication failure"

            return false;
        }
    }

    private generateAndSaveTokenForUser(username, request) {
        def token = null

        //generate unique token
        while (!token) {
            //generate token
            token = getRestService().generateToken(username, request)

            //check token uniqueness
            def tokenUser = getRestService().getUsernameForToken(token)
            if (tokenUser && tokenUser != username) {
                //token is not unique. Generate token again
                token = null
            }
        }

        //save token
        getRestService().saveToken(token, username)

        return token
    }

    protected abstract String getUsername(request)

    protected abstract String getPassword(request)

    private getRestService() {
        if (!this.@restService) {
            this.@restService = SpringUtils.getBean("restService")
        }

        return this.@restService
    }

}
