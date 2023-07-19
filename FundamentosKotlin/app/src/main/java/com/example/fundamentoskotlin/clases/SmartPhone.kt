package com.example.fundamentoskotlin.clases

class SmartPhone(number: Long, val marca: String) : Telefono(number) {

    //override dice que vamos a sobreescribir el motodo de la clase padre el cual se heredo
    override fun numero() {
        if (marca == "Samsung") {
            println("La marca del celular si es $marca")

        } else {
            println("No se conoce la marca")
            super.numero() //se puede volver a llamar al metodo del padre por cualquier cosa
        }
    }


}