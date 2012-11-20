import org.apache.shiro.SecurityUtils
import ru.grails.Employee

class ShiroUserFilters {

    def filters = {
        all(controller:'*', action:'*') {
            before = {
                //load shiro subject
                def username = SecurityUtils.subject.principal

                //load domain user
                request.currentUser = (username) ? Employee.findByUserName(username) : null

                //continue processing
                return true
            }
        }
    }

}