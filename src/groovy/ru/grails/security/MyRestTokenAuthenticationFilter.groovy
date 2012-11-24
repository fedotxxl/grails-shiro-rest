package ru.grails.security

class MyRestTokenAuthenticationFilter extends RestTokenAuthenticationFilter {

    protected String getToken(request) {
        return request.getParameter('token')
    }
}
