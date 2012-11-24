package ru.grails.security

class MyRestUserNamePasswordAuthenticationFilter extends RestUserNamePasswordAuthenticationFilter {

    protected String getUsername(request) {
        return request.getParameter('username')
    }

    protected String getPassword(request) {
        return request.getParameter('password')
    }

}
