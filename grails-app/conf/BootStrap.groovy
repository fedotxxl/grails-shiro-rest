import grails.util.Environment
import org.apache.shiro.crypto.hash.Sha256Hash
import ru.grails.Job
import ru.grails.Employee

class BootStrap {

    def init = { servletContext ->
        if (Environment.current.name in ['development', 'staging']) {
            // creating boss
            def boss = Job.findOrCreateWhere(title: 'boss')
            boss.permissions = ['office']
            boss.save()
            Employee.findOrCreateWhere(username: 'Lesha', job: boss, passwordHash: new Sha256Hash('12345').toHex()).save()
            
            // creating secretary
            def secretary = Job.findOrCreateWhere(title: 'secretary')
            secretary.permissions = ['office:secretaryRoom']
            secretary.save()
            Employee.findOrCreateWhere(username: 'Masha', job: secretary, passwordHash: new Sha256Hash('12345').toHex()).save()
            
            // boss's lover
            def dasha = Employee.findOrCreateWhere(username: 'Dasha', passwordHash: new Sha256Hash('12345').toHex())
            dasha.permissions = ['office:bossRoom']
            dasha.save()
        }
    }

    def destroy = {
    }
}
