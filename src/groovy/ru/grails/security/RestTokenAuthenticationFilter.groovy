package ru.grails.security
import org.apache.shiro.authc.AuthenticationToken
import org.apache.shiro.web.filter.authc.AuthenticatingFilter
import org.apache.shiro.web.util.WebUtils

import javax.servlet.ServletRequest
import javax.servlet.ServletResponse
import javax.servlet.http.HttpServletResponse

abstract class RestTokenAuthenticationFilter extends AuthenticatingFilter {

    protected AuthenticationToken createToken(ServletRequest request, ServletResponse response) {
        return new RestToken(token: getToken(request))
    }

    protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) {
        //this request should be handled by onAccessDenied
        return false;
    }

    protected boolean onAccessDenied(ServletRequest request, ServletResponse response) {
        if (executeLogin(request, response)) {
            // correct token... continue processing
            return true
        } else {
            //failed to authenticate. Return 401
            HttpServletResponse httpResponse = WebUtils.toHttp(response);
            httpResponse.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            httpResponse.writer << "Authentication failure"

            return false
        }
    }

    protected abstract String getToken(request)
}

