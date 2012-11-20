package ru.grails

class Employee {
    
    String userName
    String passwordHash
    Profession profession

    static hasMany = [ permissions: String ]

    static constraints = {
        profession(nullable: true)
    }
    
}
