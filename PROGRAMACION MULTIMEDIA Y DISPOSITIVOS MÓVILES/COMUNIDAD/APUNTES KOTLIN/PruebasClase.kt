package com.example.caracteristicaskotlin


fun main(){
    par(2)
}

fun par (x: Int): Unit {
    if (x % 2 == 0){
        println("Numero evaluado ${x} es par")
    }
}