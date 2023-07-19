package practicaExtra.unoYdos

open class Person(val name: String, val age: Int, val ocupation: String) {

    open fun viewPerson() {
        println("La persona se llama $name tiene $age años y es $ocupation")
    }
}