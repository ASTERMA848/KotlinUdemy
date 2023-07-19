package com.example.fundamentoskotlin.clases
import com.example.fundamentoskotlin.newTopic

fun main() {
    newTopic("Parent Instance ")
    val celular: Telefono = Telefono(261586359) // crear instancia de objeto
    celular.llama() //llamar  a la funcion del ob
    celular.numero()
    // println(celular.number) //se pueden acceder directamente a las propiedades del objeto siempre y cuando sean publicos

    newTopic("Instance inherited")
    val smart: SmartPhone = SmartPhone(2615863590, "Samsung")
    smart.numero() //aca estoy llamando al metodo sobreescrito en la clase hija


    newTopic("Data Classes")

    val miUsuario: Usuario = Usuario(
        1,
        "Juan Pablo",
        "Chechi",
        Grupos.FAMILIA.ordinal
    ) //Llamo al enum de grupos le asigno un valor y con el .ordinal trigo la posicion de ese valor
    println(miUsuario.component2()) // el component() no seria posible sin el data class
    println("El numero de grupo es ${miUsuario.component4()}")
    println(miUsuario) // sin el data class agregado en la clase Usuario imprimieria la referencia de memoria

    val miUsuario2 = miUsuario.copy(
        5,
        group = Grupos.AMIGOS.ordinal
    ) // con el .copy puedo copiar objetos y alterarlos nombrando o no las cosas que quiero cambiar
    println(miUsuario2)


    newTopic("Funciones de alcance")
    //las funciones de alcance sirven para poder aplicar multiples funciones en un mismo objeto en una sola sentencia
    newTopic("Primero con with")
    with(smart) { //una vez llamado al objeto en () se puede acceder a todos sus atributos desde ahi
        println("La marca es $marca")
        llama()
    }
    newTopic("Segundo con apply ")
    miUsuario2.apply {
        group = Grupos.TRABAJO.ordinal
        name = "Pedro"
    }
    println(miUsuario2)
}