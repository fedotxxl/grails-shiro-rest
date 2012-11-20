package ru.grails

class Employee {
    
    String userName
    Profession profession

    static constraints = {
        profession(nullable: true)
    }
    
}
