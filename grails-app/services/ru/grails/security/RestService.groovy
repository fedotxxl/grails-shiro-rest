package ru.grails.security

import org.apache.commons.lang.RandomStringUtils
import org.springframework.cache.Cache

class RestService {

    def grailsCacheManager

    void saveToken(String token, String username) {
        def previousToken = getCacheByUsername().get(username)?.get()
        if (previousToken) {
            // evict previous token
            getCacheByToken().evict(previousToken)
        }

        // save current token
        getCacheByUsername().put(username, token)
        getCacheByToken().put(token, username)
    }

    String generateToken(username, request) {
        String charset = (('A'..'Z') + ('0'..'9')).join()
        Integer length = 16

        return RandomStringUtils.random(length, charset.toCharArray())
    }

    String getUsernameForToken(String token) {
        getCacheByToken().get(token)?.get()
    }

    private Cache getCacheByToken() {
        grailsCacheManager.getCache("usernameByToken")
    }

    private Cache getCacheByUsername() {
        grailsCacheManager.getCache("tokenByUsername")
    }
}
