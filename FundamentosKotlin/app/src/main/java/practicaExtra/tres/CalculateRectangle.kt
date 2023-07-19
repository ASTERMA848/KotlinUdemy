package practicaExtra.tres

class CalculateRectangle(val width: Double, val height: Double):Shape() {

    override fun calcularArea(): Double {
        return width * height
    }


}