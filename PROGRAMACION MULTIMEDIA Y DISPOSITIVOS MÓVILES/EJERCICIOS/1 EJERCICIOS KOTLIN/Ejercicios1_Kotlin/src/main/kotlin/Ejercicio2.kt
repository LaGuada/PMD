/*(Condiciones) Léase un número entero. Se comprobará si dicho número es o no múltiplo de
20, y también se comprobará si está o no entre -100 y 100. En la salida se mostrará uno de
los siguientes mensajes:
“Es múltiplo de 20 y está entre -100 y 100”. “Es múltiplo de 20 y no está entre -100 y 100”. “No
es múltiplo de 20 y está entre -100 y 100”- “No es múltiplo de 20 y no está entre -100 y 100”.*/

fun  main(){
    condiciones()
}
fun condiciones() {
    println("Dime el numero que quieres comprobar")
    val num:Int = readLine()?.toInt() ?: 0
    if (num % 20 == 0) {
        print("El numero es multiplo de 20 ")
    } else {
        print("El numero no es multiplo de 20")
    }

    if (num > (-100) && num < 100) {
        print(" y el numero esta entre -100 y 100")
    } else {
        print(" y no esta entre -100 y 100")
    }
}