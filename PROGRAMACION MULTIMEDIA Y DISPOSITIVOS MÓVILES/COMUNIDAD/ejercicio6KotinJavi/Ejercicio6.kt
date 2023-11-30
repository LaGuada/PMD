package ejercicio6/* 6. Realizar una aplicación para la gestión de trabajadores. La aplicación podrá registrar trabajadores
* (asalariados, autónomos y/o jefes). Cada uno de los anteriores tiene las siguientes características:
* 1. Jefes: nombre, apellido, dni, acciones, beneficio. Los jefes tendrán la capacidad de despedir un trabajador.
* 2. Asalariados: nombre, apellido, dni, sueldo, número de pagas, contratado (booleano).
* 3. Autónomo: nombre, apellido, dni, sueldo, contratado (booleano).
* Adicionalmente existirá una clase Empresa que tendrá una lista de trabajadores, donde se podrán registrar todos
* los trabajadores de la empresa. La aplicación tendrá la capacidad de:
* 1. Registrar un trabajador. Para ello preguntará si se quiere registrar un asalariado, autónomo o jefe y pedirá
* los datos del trabajador.
* 2. Listar trabajadores. Para ello preguntará si se quiere listar los asalariados, los autónomos o todos.
* 3. Mostrar datos de trabajador. Para ello pedirá el DNI y mostrará el siguiente formato:
*       1. Si es jefe: Nombre: XXX Apellido: XXX DNI: XXX Acciones: XXX Beneficio: XXX.
*       2. Si es asalariado: Nombre: XXX Apellido: XXX DNI: XXX Salario Anual: XXX Salario Mensual: XXX Número de Pagas: XX.
*       3. Si es autónomo Nombre: XXX Apellido: XXX DNI: XXX Salario Anual: XXX.
* Realizar un menú para gestionar todos los casos anteriores, teniendo en cuenta las siguientes restricciones:
*       • En una empresa no pueden existir dos trabajadores con el mismo DNI.
*       • En una empresa no puede haber registrado más que un jefe.
*       • Para poder despedir un trabajador, solo lo puede hacer un jefe.
*       • Utilizar la herencia y el polimorfismo para juntar el máximo de propiedades y métodos.
*/


fun main() {

    val empresa = Empresa()

    while (true) {
        println("---MENÚ---")
        println("1. Registrar Trabajador.")
        println("2. Mostrar trabajador por DNI.")
        println("3. Despedir trabajador.")
        println("4. Salir.")
        println("Seleccione una opción: ")

        when (readLine()) {
            "1" -> empresa.addTrabajador()
            "2" -> {
                println("Introduzca el DNI del trabajador que desea buscar: ")
                val dniBuscado = readLine()
                if (dniBuscado != null) {
                    empresa.mostrarDatosTrabajador(dniBuscado)
                }
            }
            "3" -> empresa.despedirTrabajador()
            "4" -> {
                println("Hasta pronto.")
                return
            }
            else -> println("Opción no válida.")
        }
    }
}
