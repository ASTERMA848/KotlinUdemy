package com.example.fundamentoskotlin

import com.example.fundamentoskotlin.clases.Grupos
import com.example.fundamentoskotlin.clases.Usuario

fun main() {
    newTopic("Read-only Collections --> ")
    val carsList = listOf(
        "Chevrolet",
        "Ford",
        "Toyota"
    ) //El listOf solo permite agregar valores dentro del los () no con el add
    println("Un valor random es: ${carsList.get((carsList.indices).random())}")
    //println(carsList.get((0..carsList.size-1).random()))  --> ESTA ES OTRA MANERA DE IMPRIMIR ALGO RANDOM
    println("Indice de Ford es: ${carsList.indexOf("Ford")}") // metodo para buscar el indice de un valor


    newTopic("Mutable List --> ")
    val user1: Usuario = Usuario(5, "John", "Pascal", Grupos.TRABAJO.ordinal)
    val user2: Usuario = Usuario(7, "Marti", "Perez", Grupos.AMIGOS.ordinal)
    val user3: Usuario = Usuario(9, "Agus", "Chechi", Grupos.FAMILIA.ordinal)
    val usersList = mutableListOf<Usuario>( // entre los < > se define el tipo de la lista
        user1,
        user2,
        user3
    ) //coleccion de objetos // El mutableListOf permite agregar mas valores a la lista
    println("La lista de objetos es: $usersList")
    val user4: Usuario = Usuario(3, "Pedro", "Gil", Grupos.TRABAJO.ordinal)
    usersList.add(user4)
    println("La lista con un objetos agregado es: $usersList")
    usersList.removeAt(1) //remover a traves de indice
    println("La lista con un objetos removido (desde su indice) es: $usersList")
    usersList.remove(user3)
    println("La lista con un objetos removido (desde el nombre del objeto) es: $usersList")

    newTopic("Diccionarios (Mapas) --> ")
    val userMap = mutableMapOf<Int, Usuario>()         //entre < > le decimos de que tipo de datos queremos que sea la clave y el valor
    println("Mapa vacio: $userMap")
    userMap.put(user1.id.toInt(), user1) //metodo para agregar valores al mapa // la clave tiene que ser convertida a entero
    userMap.put(user1.id.toInt(), user1) //esta linea s ejecuta pero no se agrega al mapa porque no se pueden repetir las claves, solo se pueden repetir los valores
    userMap.put(user2.id.toInt(), user1) //esta linea si se agrega porque la clave es distinta (la clave viene desde el ID dl objeto creado mas arriba)
    println("Mapa con valores: $userMap")
    userMap.remove(5) //metodo para eliminar valores del mapa a traves de la clave
    println("Mapa con elemento eliminado: $userMap")

}