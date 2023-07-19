package com.example.fundamentoskotlin.clases

//la palabra reservada open especifica que la clase puede ser heredada
//la palabra protected permite que la variable solo sea accedida des la clase padre e hijas por cualqueri cosa
open class Telefono(private val number: Long) { //la clase puede ir con propiedades entre () -- en donde se estaria definiendo el constructor



    fun llama(){
        println("Llamando...... $number")
    }
    //la palabra reservada open especifica que el metodo puede ser heredado
    open fun numero(){
        println(" El numero essssss $number")
    }

}