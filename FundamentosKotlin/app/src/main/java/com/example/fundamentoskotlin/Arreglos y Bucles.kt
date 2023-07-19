package com.example.fundamentoskotlin

fun main() {
    var arregloo = arrayOf("Juan", "Pedro", "Pablo", "Maria")
    //arreglos("Juan", "Pedro", "Pablo")
    //bucleFor("Juan", "Pedro", "Pablo", "Maria")
    //bucleWhile(arregloo)

    mostrar()
}


fun arreglos(vararg nombres: String) {
    println(nombres[0])
    println(nombres[1])
    println(nombres[2])
}

fun bucleFor(vararg nombres: String) {
    for (nombre in nombres) {
        println(nombre)
    }
}

fun bucleWhile(nombres: Array<String>) {

    var i = 0
    while (i < nombres.size) {
        println(nombres[i])
        i++
    }

}


