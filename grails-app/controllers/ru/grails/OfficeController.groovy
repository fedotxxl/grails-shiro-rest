package ru.grails

class OfficeController {

    def hall = {
        answer('hall')
    }

    def secretaryRoom = {
        answer('secretary room')
    }

    def bossRoom = {
        answer('boss room')
    }

    private answer(String room) {
        render """
Hello! I'm ${(request.currentUser?.userName) ?: 'unknown'} <br>
I'm at ${room}
"""
    }
}
