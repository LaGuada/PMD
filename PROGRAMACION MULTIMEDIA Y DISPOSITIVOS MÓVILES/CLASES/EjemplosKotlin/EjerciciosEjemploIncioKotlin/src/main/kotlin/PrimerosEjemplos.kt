import model.Trabajador
import model.Usuario
import model.Votante

fun main(){
    // par(2)
    // par(18)
    // println(division(5,2))
    // println( division2())

/*    var correo:String? = null
    println(correo?.length ?: "No existe el correo")

    // voy a calcular mis pagas salariales
    var sueldo: Int? = null
    var pagas= sueldo?.toDouble() ?:10000  /14
    println(pagas)*/

    // ArrayList y val

    val trabajos: ArrayList<String> = ArrayList()
    trabajos.add("PMDM")
    trabajos.add("DI")
    trabajos.add("PSP")
    trabajos.add("SGE")

    // nos creamos un usuario para ver el ejemplo del constructor de la clase Usuario
    var usuario1 : Usuario = Usuario ("Guada", "Vargas", "75126240y")
    usuario1.mostrarDatos()
    var usuario2 : Usuario = Usuario("Paco", "Cerban", "25677Y","paco@gmail.com")
    usuario2.mostrarDatos()

    var trabajador : Trabajador = Trabajador ("Borja", "Martín", "12658Y", 6857455, 5000)
    trabajador.mostrarDatos()

    var trabajador2: Votante = Trabajador ("Borja", "Martín", "12658Y", 6857455, 5000)
    println (trabajador2.votar())
    // trabajador2.mostrarDatos() da error porque un trabajador que sea de la clase Votante sólo puede votar




    // getters y setters van implícitos
    usuario1.nombre = "Sergio"  // --> esto es un setter
    usuario1.nombre // --> esto es un getter

}


fun par (x: Int): Unit {
    if (x % 2 == 0){
        println("Numero evaluado ${x} es par")
    }
}

fun division (x: Int, y: Int): Double {
    return x.toDouble()/y
    
}

// NOS CREAMOS UNA FUNCIÓN SIN PARAMETROS

fun division2 (): Double {
    println("Introduce el primer parámetro")
    var x: Int = readln().toInt() // poneemos el toInt porque el readLine nos devuelve un String
    println("Introduce el segundo parámetro")
    var y: Int = readLine()?.toInt() ?:0 // ponemos el ?:0 por si el valor es nulo, en vez de dar erro, tome el valor 0
    return x.toDouble()/y
}


