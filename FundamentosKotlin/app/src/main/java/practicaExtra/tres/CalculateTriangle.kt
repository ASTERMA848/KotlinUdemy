package practicaExtra.tres

class CalculateTriangle(val width: Double, val height: Int):Shape(){
    override fun calcularArea(): Double {
     return width * height
    }
}