package ru.grails.security

class MyRestUsernamePasswordAuthenticationFilter extends RestUsernamePasswordAuthenticationFilter {

    protected String getUsername(request) {
        return request.getParameter('username')
    }

    protected String getPassword(request) {
        return request.getParameter('password')
    }

}
