import org.apache.shiro.authc.AccountException
import org.apache.shiro.authc.SimpleAccount
import org.apache.shiro.authc.UnknownAccountException
import ru.grails.Employee

class RestRealm {

    def restService

    static authTokenClass = ru.grails.security.RestToken

    def authenticate(authToken) {
        log.info "Attempting to authenticate ${authToken.token} in REST realm..."
        def token = authToken.token

        // Null username is invalid
        if (token == null) {
            throw new AccountException("Null token are not allowed by this realm.")
        }

        // If we don't have user for specified token then user is not authenticated
        def username = restService.getUsernameForToken(token)
        def user = (!username) ?: Employee.findByUserName(username)
        if (!user) {
            throw new UnknownAccountException("No account found for token [${token}]")
        }

        log.info "Found user '${user.userName}' in DB"

        //ok. Account is found, user is authenticated
        return new SimpleAccount(user.userName, user.passwordHash, "RestRealm")
    }

}