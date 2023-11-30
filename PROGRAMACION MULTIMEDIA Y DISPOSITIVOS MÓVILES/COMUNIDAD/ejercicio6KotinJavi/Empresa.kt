package ejercicio6

open class Empresa {
    var trabajadoresList: ArrayList<Trabajador> = ArrayList()
    val dnisRegistrados = ArrayList<String>()
    var jefeRegistrado = false

    // Método para registrar un trabajador
    fun addTrabajador() {

        println("1. Añadir jefe.")
        println("2. Añadir asalariado.")
        println("3. Añadir autónomo.")
        print("Elija una opción: ")
        val option = readLine()?.toInt()

        when(option) {
            1 -> {
                registrarJefe()
            }

            2 -> {
                registrarAsalariado()
            }

            3 -> {
                registrarAutonomo()
            }

            else -> {
                println("Por favor, introduzca una opción válida.")
            }
        }
    }

    fun registrarJefe(): Unit {
        if (jefeRegistrado == false) {
            print("Introduzca el nombre del Jefe: ")
            val nombre: String? = readLine()

            print("Introduzca el apellido del Jefe: ")
            val apellido: String? = readLine()

            print("Introduzca el DNI del Jefe: ")
            val dni: String? = readLine()

            print("Introduzca las acciones del Jefe: ")
            val acciones: Int? = readLine()?.toInt()

            print("Introduzca los beneficios del Jefe: ")
            val beneficios: Int? = readLine()?.toInt()

            if (nombre != null && apellido != null && dni != null && acciones != null && beneficios != null) {
                val jefe1 = Jefe(nombre, apellido, dni, acciones, beneficios)
                trabajadoresList.add(jefe1)
                println("Usuario Jefe registrado con éxito.")
            } else {
                println("No se pudo registrar el usuario por falta de datos.")
                println("¿Desea intentar de nuevo el registro? (S/N): ")

                val respuesta = readLine()

                if (respuesta?.equals("N", ignoreCase = true) == true) {
                    println("Gracias. Hasta pronto.")
                } else {
                    println("A continuación, volvemos a la pestaña de registro de un nuevo Usuario.")
                    registrarJefe()
                }
            }
            jefeRegistrado = true
        } else {
            println("La empresa ya tiene un jefe registrado. Elija otra opción.")
            return
        }
    }

    fun registrarAsalariado(): Unit {
        print("Introduzca el nombre del Asalariado: ")
        val nombre: String? = readLine()

        print("Introduzca el apellido del Asalariado: ")
        val apellido: String? = readLine()

        print("Introduzca el DNI del Asalariado: ")
        val dni: String = readln()

        if (dni !in dnisRegistrados) {
            dnisRegistrados.add(dni)
        } else {
            println("Ya existe un trabajador registrado con ese número de DNI. Inténtelo de nuevo.")
            return
        }

        print("Introduzca el sueldo mensual del Asalariado: ")
        val sueldo: Double? = readLine()?.toDouble()

        print("Introduzca el número de pagas del Asalariado: ")
        val numPagas: Int? = readLine()?.toInt()

        print("Introduzca si el asalariado tiene contrato: ")
        val contratado: Boolean? = readLine().toBoolean() // Preguntar Borja

        if (nombre != null && apellido != null && dni != null && sueldo != null && numPagas != null && (contratado == true || contratado == false)) {
            val asalariado1 = Asalariados(nombre, apellido, dni, sueldo, numPagas, contratado)
            trabajadoresList.add(asalariado1)
            println("Usuario Asalariado registrado con éxito.")
        } else {
            println("No se pudo registrar el usuario por falta de datos.")
            println("¿Desea intentar de nuevo el registro? (S/N): ")

            val respuesta = readLine()

            if (respuesta?.equals ("N", ignoreCase = true) == true) {
                println("Gracias. Hasta pronto.")
            } else {
                println("A continuación, volvemos a la pestaña de registro de un nuevo Usuario")
                registrarAsalariado()
            }
        }
    }

    fun registrarAutonomo(): Unit {
        print("Introduzca el nombre del Autónomo: ")
        val nombre: String? = readLine()

        print("Introduzca el apellido del Autónomo: ")
        val apellido: String? = readLine()

        print("Introduzca el DNI del Asalariado: ")
        val dni: String = readln()

        if (dni !in dnisRegistrados) {
            dnisRegistrados.add(dni)
        } else {
            println("Ya existe un trabajador registrado con ese número de DNI. Inténtelo de nuevo.")
            return
        }

        print("Introduzca el sueldo del Autónomo: ")
        val sueldo: Double? = readLine()?.toDouble()

        print("Introduzca si el asalariado tiene contrato: ")
        val contratado: Boolean? = readLine().toBoolean() // Preguntar Borja

        if (nombre != null && apellido != null && dni != null && sueldo != null && (contratado == true || contratado == false)) {
            val autonomo1 = Autonomo(nombre, apellido, dni, sueldo, contratado)
            trabajadoresList.add(autonomo1)
            println("Usuario Autónomo registrado con éxito.")
        } else {
            println("No se pudo registrar el usuario por falta de datos.")
            println("¿Desea intentar de nuevo el registro? (S/N): ")

            val respuesta = readLine()

            if (respuesta?.equals ("N", ignoreCase = true) == true) {
                println("Gracias. Hasta pronto.")
            } else {
                println("A continuación, volvemos a la pestaña de registro de un nuevo Usuario.")
                registrarAutonomo()
            }
        }
    }

    fun mostrarDatosTrabajador(dniBuscado: String) {
        val trabajadorBuscado = trabajadoresList.find {it is Trabajador && it.dni == dniBuscado}

        if (trabajadorBuscado != null) {
            when (trabajadorBuscado) {
                is Jefe -> {
                    println("Nombre: ${trabajadorBuscado.nombre}.")
                    println("Apellido: ${trabajadorBuscado.apellido}.")
                    println("DNI: ${trabajadorBuscado.dni}.")
                    println("Acciones: ${trabajadorBuscado.acciones}.")
                    println("Beneficio: ${trabajadorBuscado.beneficio} €.")
                }
                is Asalariados -> {
                    println("Nombre: ${trabajadorBuscado.nombre}.")
                    println("Apellido: ${trabajadorBuscado.apellido}.")
                    println("DNI: ${trabajadorBuscado.dni}.")
                    println("Salario anual: ${trabajadorBuscado.sueldo * trabajadorBuscado.numPagas} €.")
                    println("Salario mensual: ${trabajadorBuscado.sueldo} €.")
                    println("Número de pagas: ${trabajadorBuscado.numPagas}.")
                }
                is Autonomo -> {
                    println("Nombre: ${trabajadorBuscado.nombre}.")
                    println("Apellido: ${trabajadorBuscado.apellido}.")
                    println("DNI: ${trabajadorBuscado.dni}.")
                    println("Acciones: ${trabajadorBuscado.sueldo}.")
                }
            }
        }
    }

    fun despedirTrabajador() {

        println("Introduzca el DNI del jefe: ")
        val dniJefe: String? = readLine()

        println("Introduzca el DNI del trabajador que desea despedir: ")
        val dniTrabajador: String? = readLine()

        val jefe = trabajadoresList.find {it is Jefe && it.dni == dniJefe} as? Jefe
        val trabajador = trabajadoresList.find {it.dni == dniTrabajador}

        if (jefe != null && trabajador != null) {
            if (jefe == trabajador) {
                println("El jefe no puede autodespedirse.")
            } else {
                trabajadoresList.remove(trabajador)
                dnisRegistrados.remove(dniTrabajador)
                println("El trabajador con DNI $dniTrabajador ha sido despedido.")
            }
        } else {
            println("Sólo el jefe puede realizar despidos.")
            return
        }
    }
}
