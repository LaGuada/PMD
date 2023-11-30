package model

// Creo una clase Trabajador que quiero que herede los atributos de Usuario y además un salario

class Trabajador(nombre: String, apellido: String, dni: String, telefono: Int, var salario: Int) :
    Usuario(nombre, apellido, dni, telefono), Votante {

        // Método que hereda de Usuario, al que le añado el nuevo atributo salario
    override fun mostrarDatos() {
        super.mostrarDatos()
            println("Salario: $salario")
    }

    // implemento el método de la interfaz y le indico que me retorne un número aleatorio
    override fun votar(): Int {
     return  (1..100).first()
    }

}