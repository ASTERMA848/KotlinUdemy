package practicaExtra.tres

import kotlin.math.PI

class CalculateCircle(val radius:Int): Shape(){


    override fun calcularArea(): Double {
      return (radius*radius)* PI
    }


}