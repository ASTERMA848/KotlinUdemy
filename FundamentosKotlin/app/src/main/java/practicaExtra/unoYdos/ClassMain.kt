package practicaExtra.unoYdos

import com.example.fundamentoskotlin.newTopic
import practicaExtra.cuatro.BankAccount
import practicaExtra.cuatro.SavingsAccount
import practicaExtra.tres.CalculateCircle
import practicaExtra.tres.CalculateRectangle
import practicaExtra.tres.CalculateTriangle

fun main() {

    newTopic("EJERCICIOS 1 Y 2")
    //Ejercicio 1: Crear una clase "Person" con propiedades de nombre, edad y ocupación. Agrega métodos para obtener y establecer estas propiedades.
    //Ejercicio 2: Extiende la clase "Person" con una subclase llamada "Student"
    // que tenga una propiedad adicional de "grado" (por ejemplo, "primero", "segundo", etc.). Agrega métodos para obtener y establecer el grado del estudiante.
    val per1: Person = Person("Juan Pablo", 21, "Estudiante")
    per1.viewPerson()
    val student1: Student = Student("Pedro", 15, "Estudiante", "Primero")
    student1.viewPerson()

    newTopic("EJERCICIO 3")
    //Ejercicio 3: Crea una clase "Shape" con un método abstracto llamado "calculateArea".
    // Luego, crea subclases como "Rectangle", "Circle" y "Triangle"
    // que implementen este método y calculen el área según su forma.

    val rectangulo = CalculateRectangle(4.0, 6.8)
    println("El area del rectangulo es ${rectangulo.calcularArea()}")

    val circulo = CalculateCircle(19)
    println("El area del circulo es ${circulo.calcularArea()}")

    val triangulo = CalculateTriangle(8.3, 7)
    println("El area del triangulo es ${triangulo.calcularArea()}")


    newTopic("EJERCICIO 4")
    //Ejercicio 4: Crea una clase "BankAccount" con propiedades de saldo y número de cuenta.
    // Agrega métodos para depositar y retirar dinero. Luego, crea una subclase llamada
    // "SavingsAccount" que herede de "BankAccount" y agregue una propiedad de tasa de interés.
    // Sobrescribe el método de depósito para calcular los intereses y agregarlos al saldo.

    println("--> CUENTA BANCARA <--")
    val cuenta1= SavingsAccount(numberAccount = 451565)
    cuenta1.deposit()
    println("El dinero actual es ${cuenta1.mostrar()}")
    cuenta1.withdraw()
    println("El dinero actual es ${cuenta1.mostrar()}")
    cuenta1.masInteres()
    println("El dinero actual con interes es ${cuenta1.mostrar()}")






}




