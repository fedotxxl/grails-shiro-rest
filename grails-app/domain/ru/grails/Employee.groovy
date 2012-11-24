package ru.grails

class Employee {
    
    String username
    String passwordHash
    Job job

    static hasMany = [ permissions: String ]

    static constraints = {
        job(nullable: true)
    }
    
}
