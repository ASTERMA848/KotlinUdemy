package practicaExtra.cuatro

open class BankAccount(var balance:Int=0, val numberAccount: Int){

    open fun deposit(){
        print("Ingresar la cantidad de dinero a depositar: ")
        val num= readLine()?.toInt()
        balance += num!!
    }

    fun withdraw(){
        print("Ingresar la cantidad de dinero a retirar: ")
        val num= readLine()?.toInt()
        balance -= num!!
    }

    fun mostrar():Int{
        return balance
    }
}