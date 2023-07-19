package com.example.userssp

class User(val id: Long, var name: String, val lastName: String, var url: String) {


    fun getFullName(): String {
        return name + " " + lastName
    }
}