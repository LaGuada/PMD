
/*(MayorQue) Hágase un programa que lea dos enteros y compruebe si el primero es o no
mayor que el segundo. En la salida se mostrará “El primero es mayor que el segundo” o “El
primero no es mayor que el segundo”.
 */

fun mayorQue() {
    println ("Introduce el número1")
    var num1: Int = readLine()?.toInt() ?:0

    println ("Introduce el número1")
    var num2: Int = readLine()?.toInt() ?:0

    if (num1>num2){
        println ("El primero es mayor que el segundo")
    } else if (num1<num2){
        println ("El primero no es mayor que el segundo")
    } else {
        println("El valor $num1 es igual que $num2 ")
    }


}

fun main(){
    mayorQue()

}
