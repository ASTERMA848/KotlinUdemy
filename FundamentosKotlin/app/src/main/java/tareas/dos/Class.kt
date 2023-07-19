package tareas.dos

fun main() {
    val car1: Cars = Cars(15, "Chevrolet", "Rojo")

    println(car1) //Se imprime la referenncia de memoria al no usar data class
    car1.mostrar() //Llamada a la funcion

}