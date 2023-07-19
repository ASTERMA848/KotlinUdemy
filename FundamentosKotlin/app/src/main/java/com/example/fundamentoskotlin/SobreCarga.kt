package com.example.fundamentoskotlin

//la sobre carga en lo metodos nos da la posibilidadd de poner un valor por default en cada argumento por las dudas
//al llamar a la funcion se pueden pasar o no los valores
//tambien se pueden elegir que valores pasar (definiendolos previamente) se lo llama argumentos nombrados
fun main() {
    sobrecarga("Coca", 1050, "15/6/23")
    sobrecarga("Pepsi", 230)
    sobrecarga(precio = 900, fechaVto = "6/9/24")
}

fun sobrecarga(
    nombre: String = "Sin nombre",
    precio: Int = 500,
    fechaVto: String = "Sin vencimiento"
) {
    println("El producto $nombre tiene un precio de $precio y su fecha de vencimiento es: $fechaVto")

}