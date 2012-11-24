package ru.grails

class Job {
    
    String title

    static hasMany = [ permissions: String ]

    static constraints = {
        title(nullable: false, blank: false, unique: true)
    }
    
}
