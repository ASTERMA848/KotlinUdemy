package com.example.fundamentoskotlin

const val global =
    "Variable Global" //la palabra const aparte de dclarar constante y funcionar solo en el ambito global dice que el valor va a ser

//asignado en tiempo de compilacion y no ejecucion (osea que nunca va a cambiar)
fun main() {
    //imprimir("Hola Mundo")
    //variablesYconstantes()
    //variablesNulas()
    //funPrivada()
    //println("La suma de 5 + 7 es ${devolucion(5,7)}")
    //println("La resta entre 87 y 61 es ${optimizada(87,61)}")
    mostrar()
}

fun mostrar() {
    println("La variable global es: $global");
}

fun imprimir(palabra: String) {
    print("Que ondaaa ")
    println(palabra)
    println("Que ondaaa $palabra")
}

fun variablesYconstantes() {
//variables
    val a = 2 //no se pueden modificar
    println(a + 9)
    var b: String = "ABC"
    println(b)
}

fun variablesNulas() {
    var objeto: String?
    //var objeto:Any?  <--> Gracias al Any puede adquirir cualquier valor

    objeto = null
    println("El bojeto es $objeto")

    objeto = "Auto"
    println("El objeto es $objeto")

    objeto = null
    if (objeto == null) {
        println("El objeto es nulo, no se imprime")
    }
}

private fun funPrivada(): Unit { //El unit es como Void en Java, la funcion no devuelve nada (si no se indica se pone por default)
    println("Hola Kotlin")
}

fun devolucion(
    a: Int,
    b: Int
): Int { //Se le ingresaran 2 parametros entero y devuelve un entero tamnbien

    val c = a + b
    return c
}

fun optimizada(a: Int, b: Int) =
    a - b //este tipo de funciones se usan cuando son funciones simples y se desea que el return sea implicito


fun newTopic(palabra: String) {
    println(" ")
    println("================= $palabra =================")

}
