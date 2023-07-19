package com.example.fundamentoskotlin

import kotlin.random.Random

fun main() {
    variables()
    varDeEntrada(4.6)
    print("El largo de la cadena enviada es de -- ${varDeSalida("Hola Mundo")} --")
    sentenciaIfElse()
    sentenciaWhen(8)
    WhenRaro(false) //no es recomendable
    nullSaefety()
    arreglos()
    listasInmutables()
    listasMutables()
    mapas()
    bucleFor()
    // bucleWhile()
}

fun variables() {
    // ------ Las val son constantes y las var variables ---------
    // --- NUMEROS ---
    var edad: Int = 15
    edad = 324
    val edad2: Long = 1545415419354351
    val edad3: Float = 534.54F
    val edad4: Double = 534.45

    // --- STRINGS ---
    val car: Char = 'a'
    val car2: String = "hola mundo"

    // --- BOOLEANOS ---
    val bandera: Boolean = true


}

fun varDeEntrada(num: Double) {
    print("I have $num")
}

fun varDeSalida(palabra: String): Int { // se pueden poner valores por defecto en caso de no enviar nada a la funcion = (palabra: String= "Hola Mundo")
    return palabra.length
}

fun sentenciaIfElse() {

    println("---------- EJERCICIO 1 ----------")
    //Realizar una función que tome un número entero y devuelva un mensaje diciendo si es par o impar

    val num1 = 5
    if (num1 % 2 == 0) {
        println("$num1 es par")
    } else {
        println("$num1 es impar")
    }

    println("---------- EJERCICIO 2 ----------")

    //Realizar una función que tome un número entero y devuelva un mensaje diciendo si es positivo, negativo o cero.
    var numero: Int = -50
    if (numero > 0) {
        println("$numero es POSITIVO")
    } else if (numero == 0) {
        println("$numero es CERO")
    } else {
        println("$numero es NEGATIVO")
    }



    println("---------- EJERCICIO 3 ----------")

    //Realizar una función que tome una cadena de texto y devuelva un mensaje diciendo si tiene más de 10 caracteres o no.


    val palabra = "Hola mundo cruel aaaaa"

    if (palabra.length > 10) {
        println("La frase | $palabra | tiene mas de 10 caracteres")
    } else {
        println("La frase | $palabra | tiene menos de 10 caracteres")
    }



    println("---------- EJERCICIO 4 ----------")


    //Escribe un programa que pida al usuario dos números enteros y verifique
    // si ambos números son pares o si ambos números son impares. Si ambos números son pares,
    // el programa debe imprimir "Ambos números son pares", si ambos números son impares, debe imprimir "Ambos números son impares",
    // y si los números no cumplen ninguna de las dos condiciones anteriores, el programa debe imprimir "Los números no son iguales".


    val numero1 = Random.nextInt(1, 50)
    val numero2 = Random.nextInt(1, 50)

    if (numero1 % 2 == 0 && numero2 % 2 == 0) {
        println("Los dos numeros generados son pares $numero1 | $numero2")
    } else if (numero1 % 2 == 1 && numero2 % 2 == 1) {
        println("Los dos numeros generados son impares $numero1 | $numero2")
    } else {
        println("Los dos numeros generados NO coinciden $numero1 | $numero2")
    }


}

private fun sentenciaWhen(n: Int) {
    println("---------- EJERCICIO 1 ----------")

    //Ejercicio 1: Convertir el día de la semana a texto
    //Escribe un programa que pida al usuario un número del 1 al 7 y luego imprima el
    // nombre del día de la semana correspondiente.
    // Si el usuario ingresa un número fuera de este rango, el programa debe imprimir "Número inválido".


    println("El numero es $n ")
    when (n) {
        1 -> println("LUNES")
        2 -> println("MARTES")
        3 -> println("MIERCOLES")
        4 -> println("JUEVES    ")
        5 -> println("VIERNES")
        6 -> {
            println("SABADO")
            println("y hay scouts") //agregar varias cosas entre {}
        }

        7 -> println("DOMINGO")
        8, 9, 10 -> print("Tepasaste de los dias") //mas de un valor
        in 11..16 -> println("PARAAAA TE PASASTE") //ranfo de valores
        else -> (println("ERROR"))

    }
}

fun WhenRaro(valor: Any) {

    when (valor) {
        is Int -> print("Entero")
        is Boolean -> println("Booleano")
        is String -> println("String")


    }

}

fun nullSaefety() {
    var nombre: String? = "null" //hay que especificar si o si el tipo de dato y poner un signo de ?

    if (nombre != null) {
        println(nombre!![1]) // los signos !! obligan a imprimir aunque sea nulo (daria error), igualemnte lo verifico con el if
    }

    //llamadas seguras=
    println(nombre?.length ?: "ES NULOOOO")
    //con el ?, en el caso de que sea nulo va a impimir null y no se va a romper el programa
    //Pero si es nulo se va a imprimir lo que esta depues de ?:

    nombre = null
    nombre?.let {//este bloque de codigo se ejecuta en el caso de que la varibale sea != null
        println("SE IMPRIME")
    }

    //---------- TODAS ESTAS SON DISTINTAS FORMAS DE HACER LOS MISMO ----------//
}

fun arreglos() {


    println("---------- EJERCICIO 1 ----------")
    // Crea un array de enteros con los valores {1, 2, 3, 4, 5}. Imprime el primer elemento del array y la longitud del array
    var arreglo = arrayOf(1, 2, 3, 4, 5)
    println("PRIMER NUMERO: ${arreglo.first()} Y LA LONGITUD ES: ${arreglo.size}")



    println("---------- EJERCICIO 2 ----------")
    //Crea un array de cadenas con los valores {"Hola", "Mundo", "en", "Kotlin"}. Imprime el último elemento del array y la longitud del array

    // -----------var arreglo2: Array<String> = arrayOf("Hola", "Mundo", "en", "Kotlin")   ----- DE ESTA MANERA SE DECLARA CON UN TIPO DE DATO DEFINIDO -----
    var arreglo2 = arrayOf("Hola", "Mundo", "en", "Kotlin")

    println("ULTIMA PALABRA DEL ARREGLO: ${arreglo2.last()}  Y LA LONGITUD ES: ${arreglo2.size}")
    println("${arreglo2[0]} POR LAS DUDAS ESTE ES EL PRIMER ELEMENTO")
    println("---------- EJERCICIO 3 ----------")
    //Crea un array de enteros con los valores {10, 20, 30, 40, 50}. Utiliza un bucle for para imprimir cada elemento del array.

    val arreglo3: Array<Int> = arrayOf(10, 20, 30, 40, 50)
    for (valores in arreglo3) {
        println("Valor: $valores")
    }
    for (valores in arreglo3.indices) {
        println("Indice: $valores")
    }

    println("---------- EJERCICIO 4 ----------")
    //Crea un array de enteros con los valores {1, 2, 3, 4, 5}. Utiliza un bucle for para sumar todos los elementos del array e imprimir el resultado
    val arreglo4: Array<Int> = arrayOf(1, 2, 3, 4, 5)
    var suma = 0

    for (valores in arreglo4) {
        suma += valores
    }

    println("LA SUMA TOTAL ES: $suma")

    println("---------- EJERCICIO 5 ----------")
    //Crea un array de enteros con los valores {10, 20, 30, 40, 50}. Utiliza un bucle for para encontrar el valor máximo del array e imprimirlo.

    val arreglo5: Array<Int> = arrayOf(10, 20, 30, 40, 50)

    var mayor = arreglo5.first()

    for (valores in arreglo5) {
        if (mayor < valores) {
            mayor = valores
        }
    }

    println("EL NUMERO MAS GRANDE DEL ARREGLO ES: $mayor")



    println("---------- EJERCICIO 6 ----------")
    //Crea un array de enteros con los valores {1, 2, 3, 4, 5}. Utiliza un bucle for para encontrar el valor mínimo del array e imprimirlo.

    val arreglo6 = arrayOf(1, 2, 3, 4, 5)

    var menor = arreglo6.first()

    for (valores in arreglo6) {
        if (menor > valores) {
            menor = valores

        }
    }
    println("EL NUMERO MAS CHICO ES: $menor")




    println("---------- EJERCICIO 7 ----------")
    // Crea dos arrays de enteros con los valores {1, 2, 3, 4, 5} y
    // {6, 7, 8, 9, 10}. Utiliza un bucle for para calcular la suma de los
    // elementos correspondientes en cada array e imprimir los resultados.

    val primerArray = arrayOf(1, 2, 3, 4, 5)
    val segundoArray = arrayOf(6, 7, 8, 9, 10)

    for (i in primerArray.indices) { //LA PALABRA RESERVADA "indices" retorna el rango del arreglo
        println("POSICION $i: ${primerArray[i] + segundoArray[i]}")
    }



    println("---------- EJERCICIO 8 ----------")
    //Crea un array de enteros con los valores {1, 2, 3, 4, 5}.
    // Utiliza un bucle for para crear un nuevo array con los valores multiplicados por dos. Imprime el nuevo array.

    val arr = arrayOf(1, 2, 3, 4, 5)
    val arr2 =
        Array(arr.size) { 0 }   //a este arreglo le doy el mismo tamaño que el arreglo de arriba y lo inicializo en 0

    for (i in arr.indices) {
        arr2[i] = arr[i] * 2
    }
    println(arr2.contentToString())

    println("---------- EJERCICIO 9 ----------")
    //Crea un array de enteros con los valores {1, 2, 3, 4, 5}.
    // Utiliza el método reverse() para invertir el orden de los elementos en el array. Imprime el array invertido.

    val arregloUltimo = arrayOf(1, 2, 3, 4, 5)

    arregloUltimo.reverse()

    println("EL ARREGLO INVERTIDO QUEDA: ${arregloUltimo.contentToString()}") //DE ESTA FORMA SE IMPRIME UN ARREGLO SIN ITERARLO

}

fun listasInmutables() {
    val miLista: List<String> = listOf("Juan", "Pedro", "Lucas")

    println(miLista.size) //imprime tamaño de lista
    println(miLista)  //Es los mismo poner println(miLista.toString())
    println(miLista[1]) //imprime valor en la posicion de la lista
    println(miLista.last()) //imprime ultimo valor de la lista
    println(miLista.first()) //imprime primer valor de la lista


    val miLista2 =
        miLista.filter { it.contains("a") } //puedo iterar y solo agregar valores que contengan lo que le paso entre ""
    println(miLista2)

    val miLista3: List<Int> = listOf(54, 65, 87, 33, 21, 54, 96, 12)
    miLista3.forEach { numero -> print("$numero  - ") } //recorro la lista con un foreach y le digo que me muestre cada valor en este caso "numero"
    //hay otra forma de iterar la lista con un for  miLista3.forEach { println(it) } ---- pero es menos legible

}

fun listasMutables() {
    println()
    var diasDeSemana: MutableList<String> = mutableListOf(
        "Lunes",
        "Martes",
        "Miercoles",
        "Jueves",
        "Viernes",
        "Sabado",
        "Domingo"
    ) //con valores ya definidos (hace un falto de linea cuando ordeno el codigo tranqui)
    var diasDeSemana2: MutableList<String> = mutableListOf() // vacio
    diasDeSemana2.add("Domingo") // asi se pueden agregar valores a una lista mutable siempre agregandose al ultimo de la lista y a medida que se va ingresando se va a quedando atras
    diasDeSemana2.add(
        0,
        "Lunes"
    ) //Se le puede indicar un indice para decir en que parte de la lista queremos que se guarde

    if (diasDeSemana2.isEmpty()) { // o de forma contraria ---> if (diasDeSemana2.isNotEmpty())
        println("Lista vacia")
    } else {
        println(diasDeSemana2)
    }

}

fun mapas() {

    println("---------- EJERCICIO 1 ----------")
    //Crea un mapa que asocie nombres de países con sus capitales. Luego, imprime la capital de un país específico.

    val mapa1: Map<String, String> =
        mapOf("Argentina" to "Buenos Aires", "Brasil" to "Brasilia", "Cuba" to "La Habana")

    println("LA CAPITAL ELEGIDA ES: ${mapa1["Cuba"]}")


    println("---------- EJERCICIO 2 ----------")

    //Dado un mapa que asocia nombres de ciudades con su población, calcula la población total sumando los valores del mapa.

    val mapa2: Map<String, Int> =
        mapOf("EEUU" to 1241654, "Argentina" to 13518, "Chile" to 3546)
    var suma =
        mapa2.values.sum() //EN ESTA LINEA USO TODOS METODOS QUE AGARRAN LOS VALORES DEL MAPA Y LOS SUMO
    println("LA SUMA ES: $suma")

    println("---------- EJERCICIO 3 ----------")
    //Crea una función que reciba un mapa de productos y sus precios, y devuelva el nombre del producto más caro.


    val mapa3: Map<String, Int> = mapOf("PAN" to 200, "COCA" to 503, "Arroz" to 350)
    var precioMayor = mapa3.values.first()
    var productoMayor = mapa3.keys.first()
    println(precioMayor)

    for ((nombre, precio) in mapa3) { //en este for se pueden iterar la claves y los valores del mapa por separado

        if (precio > precioMayor) {
            precioMayor = precio
            productoMayor = nombre
        }
    }

    println("EL PRODUCTO: -|$productoMayor|- ES EL PRODUCTO MAS CARO CON UN PRECIO DE $$precioMayor")

}

fun bucleFor() {
    println("---------- EJERCICIO 1 ----------")
    //Imprimir los números del 1 al 10 en orden ascendente:

    for (i in 1..10) {
        println(i)
    }

    println("---------- EJERCICIO 2 ----------")
    //Imprimir los números pares del 1 al 20:

    for (i in 1..20) {
        if (i % 2 == 0) {
            println(i)
        }

    }

    println("---------- EJERCICIO 3 ----------")
    //Calcular la suma de los primeros 50 números enteros

    var suma = 0
    for (i in 1..50) {
        suma += i
    }
    println("SUMA: $suma")

    println("---------- EJERCICIO 4 ----------")
    //Imprimir los números del 100 al 1 en orden descendente:

    for (i in 100 downTo 1) {
        println(i)
    }


}

fun bucleWhile(s: String, s1: String, s2: String, s3: String) {
    println("---------- EJERCICIO 1 ----------")
    //Imprimir los números del 1 al 10 en orden ascendente:
    var i = 1
    while (i <= 10) {
        println(i)

        i++
    }

    println("---------- EJERCICIO 2 ----------")
    //Imprimir los elementos de un arreglo

    val arreglo =
        arrayOf("Lunes", "Martes", "Miercoles", "Jueves", "Viernes", "Sabado", "Domingo")
    var i2 = 0
    while (i2 < arreglo.size) {

        println(arreglo[i2])

        i2++


    }


}










