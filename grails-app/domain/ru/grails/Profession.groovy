package ru.grails

class Profession {
    
    String title

    static hasMany = [ permissions: String ]

    static constraints = {
        title(nullable: false, blank: false, unique: true)
    }
    
}
