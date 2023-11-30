package model

open class Usuario (var nombre: String, var apellido: String, var dni: String){

    // ATRIBUTOS: nombre (obligatorio) apellido (obligatorio) dni (obligatorio) correo (opcional):

            /* Ya  no haría falta declarar así las variables ya que lo haremos en la definición de la clase
                         var nombre: String? = null
                         var apellido: String? = null
                         var dni: String? = null
                         var correo: String? = null*/


    // CONSTRUCTORES
        // primario --> base donde van los atributos obligatorios. Se declaran al lado de la definición de la clase:
                // class Usuario (var nombre: String, var apellido: String, var dni: String){

        // secundarios --> base + adicional
        var correo: String? = null // el atributo correo es opcional
        // creo el constructor secundario
        constructor(nombre: String, apellido: String, dni: String, correo: String): this (nombre, apellido,dni){
            this.correo = correo
        }

        // Me creo otra variable opcional y lo igualo a nulo
        var telefono: Int? = null
        // Me creo otro constructor
        constructor(nombre: String, apellido: String, dni: String, telefono: Int): this (nombre, apellido, dni){
            this.telefono = telefono
        }


    // getters y setters: van implícitos (ejemplo en el main)
    // usuario1.nombre = "Sergio" --> esto es un setter
    // usuario1.nombre --> esto es un getter

/*    // Se pueden modificar con el set (value), y lo mismo con el get
    var correo2: String? = null
        set(value) {
            it = value  // el it hace referencia al correo
        }*/

    // Modificar el get
    var correo3: String? = null
        get() {
            return "asdaas"
        }

    // métodos, le añado open para que se pueda sobrescribir en la que hereda
    open fun mostrarDatos(): Unit {
        println("Los datos son: Nombre: $nombre, Apellido: $apellido, DNI: $dni")
        
    }
}

