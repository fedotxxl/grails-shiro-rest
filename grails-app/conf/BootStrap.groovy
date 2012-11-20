import grails.util.Environment
import ru.grails.Profession
import ru.grails.Employee

class BootStrap {

    def init = { servletContext ->
        if (Environment.current.name in ['development', 'staging']) {
            // creating boss
            def boss = Profession.findOrCreateWhere(title: 'boss').save()
            Employee.findOrCreateWhere(userName: 'Lesha', profession: boss).save()
            
            // creating secretary
            def secretary = Profession.findOrCreateWhere(title: 'secretary').save()
            Employee.findOrCreateWhere(userName: 'Masha', profession: secretary).save()
            
            // boss's lover
            Employee.findOrCreateWhere(userName: 'Dasha').save()
        }
    }

    def destroy = {
    }
}
