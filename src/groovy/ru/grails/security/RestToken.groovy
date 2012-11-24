package ru.grails.security

import org.apache.shiro.authc.AuthenticationToken

class RestToken implements AuthenticationToken {

    String token

    Object getPrincipal() {
        return token
    }

    Object getCredentials() {
        return null
    }
}
