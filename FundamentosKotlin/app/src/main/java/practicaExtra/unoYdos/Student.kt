package practicaExtra.unoYdos

class Student(name: String, age: Int, ocupation: String, val grade: String):Person(name, age, ocupation) {

    override fun viewPerson() { //sobreeescribo el metodo heredado
        println("El estudiante se llama $name tiene $age años y es $ocupation en grado $grade")
    }
}


