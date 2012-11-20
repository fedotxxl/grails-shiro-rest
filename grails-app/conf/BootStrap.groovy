import grails.util.Environment
import org.apache.shiro.crypto.hash.Sha256Hash
import ru.grails.Profession
import ru.grails.Employee

class BootStrap {

    def init = { servletContext ->
        if (Environment.current.name in ['development', 'staging']) {
            // creating boss
            def boss = Profession.findOrCreateWhere(title: 'boss')
            boss.permissions = ['office']
            boss.save()
            Employee.findOrCreateWhere(userName: 'Lesha', profession: boss, passwordHash: new Sha256Hash('12345').toHex()).save()
            
            // creating secretary
            def secretary = Profession.findOrCreateWhere(title: 'secretary')
            secretary.permissions = ['office:secretaryRoom']
            secretary.save()
            Employee.findOrCreateWhere(userName: 'Masha', profession: secretary, passwordHash: new Sha256Hash('12345').toHex()).save()
            
            // boss's lover
            def dasha = Employee.findOrCreateWhere(userName: 'Dasha', passwordHash: new Sha256Hash('12345').toHex())
            dasha.permissions = ['office:bossRoom']
            dasha.save()
        }
    }

    def destroy = {
    }
}
