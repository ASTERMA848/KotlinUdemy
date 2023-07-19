package tareas.dos

open class Cars(val id: Int, val name: String, val color: String) {

    //open para que pueda ser heredada
    open fun mostrar() {
        println("El auto $name es de color $color")
    }
}