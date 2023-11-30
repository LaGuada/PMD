import kotlin.random.Random

/*4. Crea un programa que genere un número aleatorio (entre 0 y 20) de entrada y lo guarde en
una variable. El sistema irá pidiendo números al usuario hasta que coincida con el aleatorio
generado (en caso de no coincidir mostrará el mensaje "Lo siento, inténtalo de nuevo").
1
TRIMESTRE
Cuando coincida el sistema deberá mostrar el mensaje "Enhorabuena, has acertado el
número en 5 intentos" (Adivina)*/

fun main(){

        val numeroAleatorio = Random.nextInt(21) // Genera un número aleatorio entre 0 y 20
        var intentos = 0

        while (true) {
            print("Introduce un número entre 0 y 20: ")
            val numeroUsuario = readLine()?.toIntOrNull()

            if (numeroUsuario != null && numeroUsuario in 0..20) {
                intentos++

                if (numeroUsuario == numeroAleatorio) {
                    println("Enhorabuena, has acertado el número en $intentos intentos")
                    break
                } else {
                    println("Lo siento, inténtalo de nuevo")
                }
            } else {
                println("Entrada inválida. Por favor ingresa un número entre 0 y 20.")
            }
        }
    }



