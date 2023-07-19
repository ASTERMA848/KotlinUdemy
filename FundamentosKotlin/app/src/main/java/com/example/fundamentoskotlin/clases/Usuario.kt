package com.example.fundamentoskotlin.clases
//la palabra reservada data permite que sus instancias puedan tener mas fuciones "heredadas" de la clase DATA CLASSES --> en otras palabras es un modelo de datos
data class Usuario(val id: Long, var name: String, val lastName: String, var group: Int) {

}