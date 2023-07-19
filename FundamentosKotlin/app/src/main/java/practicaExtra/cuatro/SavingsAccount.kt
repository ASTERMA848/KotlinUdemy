package practicaExtra.cuatro

class SavingsAccount(balance: Int = 0, numberAccount: Int, var interes: Int=0) :
    BankAccount(balance, numberAccount) {


    fun masInteres() { //No sobreescribi el metodo como dice en la consigna porque nose como llamar
        //a un metodo de la clase padre y despues al mismo metodo pero sobreescrito con la misma intancia
        print("Ingresar interes: ")
        val intereses = readLine()?.toInt()
        val inter = balance* intereses!!
        balance += balance + inter
    }
}