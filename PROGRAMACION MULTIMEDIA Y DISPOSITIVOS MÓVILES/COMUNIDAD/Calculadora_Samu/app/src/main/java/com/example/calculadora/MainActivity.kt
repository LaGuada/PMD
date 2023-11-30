package com.example.calculadora

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.view.View
import com.example.calculadora.databinding.ActivityMainBinding

/**
 * MainActivity
 * - Hereda de AppCompatActivity e implementa la interfaz View.OnClickListener.
 * -- AppCompatActivity es una clase base proporcionada por el framework de Android que se utiliza para crear actividades.
 * -- View.OnClickListener indica que esta clase manejará eventos de clic en vistas. Obliga a implementar el método OnClick
 */

/**
 * Funcion onCreate
 * - Es una función que inicia una actividad de android. Se llama cuando la aplicación se inicia por primera vez, o se reinicia después de detenerse o estar inactiva. Lo que hace es iniciar la aplicación, y cargar toda la configuración y diseño que tenga esta.
 * - Siempre tiene un override porque está sobreescribiendo un método de la clase padre "AppCompatActivity()"
 * - Recibe como parámetro un objeto de tipo Bundle, llamado savedInstanceState. Este objeto se usa para cuando la aplicación se reinicia. Contiene guardados todos los datos que la actividad había estado procesando antes de detenerse. Se utiliza para volver a iniciar la actividad en el mismo estado que el que tenía justo antes de detenerse, en vez de iniciarse desde 0.
 * - Esta función le pasa a la clase padre de nuestra actividad (MainActivity), el parámetro savedInstanceState, porque es la clase padre la que se encarga de procesar esa información que le llega, y cargar la actividad en el estado que estaba antes.
 */

/**
 * Biblioteca ViewBinding (variable binding)
 * ViewBinding es una característica del conjunto de herramientas de desarrollo de Android. Su propósito es permitir acceder a las vistas de los diseños XML desde el código de Kotlin o Java
 * - Para habilitarlo primero hay que configurarlo en el archivo "build.gradle" (explicado mejor ahí)
 * - Lo que hace es que va al XML, coge todo el diseño y crea una clase a la que llama con el mismo nombre que el XML (en este caso, como se llama activity_main, llamará a la clase ActivityMainBinding (añade Binding al final del nombre)
 * -- La clase ActivityMainBinding va a coger cada vista que haya en el XML (botones, EditTexts...), y los va a guardar dentro de variables, y cada una de esas variables va a ser una propiedad de esta clase. De esta forma, vamos a poder acceder a las vistas como si fueran propiedades de la clase. Accedemos a ellas igual que accedemos a las propiedades de cualquier clase (nombreClase.propiedad)
 * --- Ej. Aquí hemos llamado a la clase "binding", así que si quiero acceder a un botón sería "binding.myButton" (eso si, hay que poner my delante del nombre en inglés. Si queremos acceder a un EditText: "binding.myEditText"
 * -- Como cada vista está guardado dentro de una propiedad, podemos acceder tambien a las propiedades de cada vista (es como si hubieramos guardado un objeto como propiedad de una clase. Accedemos así : nombreClase.nombrePropiedad.nombrePropiedadDeLaPropiedad
 * --- Ej. Si queremos acceder al texto de un botón "binding.myButton.text". Podemos cambiar su valor: "binding.myButton.text= "Nuevo Texto""
 */


/**
 * Método setContentView (dentro de onCreate)
 * - Este método se encarga de cargar, inflar y mostrar el diseño del documento XML al usuario
 * - Aquí lo estamos llamando, no lo estamos creando, ojo! (a diferencia del método onCreate, que sí lo estamos creando)
 * - "Inflar" un diseño XML significa convertir el contenido y la estructura definidos en un archivo XML de diseño en una jerarquía de objetos de vista en memoria. Esta jerarquía de objetos de vista representa la interfaz de usuario definida en el archivo XML y se utiliza para mostrar la interfaz en la pantalla del dispositivo.
 * -- Cuando inflas un diseño XML, estás creando instancias de las vistas y widgets definidos en el archivo XML. Cada elemento del diseño (botones, cuadros de texto, imágenes, etc.) se convierte en un objeto de vista en memoria, y estos objetos se organizan de acuerdo con la estructura definida en el archivo XML.
 * -- Inflar un diseño XML generalmente se realiza utilizando métodos proporcionados por el sistema Android o por las bibliotecas de vinculación de vistas como ViewBinding o Data Binding.
 *
 * Forma básica de setContentView --> es "setContentView(R.layout.activity_main)"
 * - R es una clase autogenerada de android que se usa para hacer referencia a los recursos de la aplicación. Lo que hace android es coger la carpeta res y convertirla en la clase R, y convertir las subcarpetas en clases dentro de esa clase. De esta forma, es como si usáramos la ruta al fichero activity_main, pero en vez de poner un string, android lo ha convertido todo en clases
 *
 * setContentView en este archivo:
 *
 *       binding = ActivityMainBinding.inflate(layoutInflater);
 *       val view: View = binding.root
 *       setContentView(view)
 *
 *  Línea "binding = ActivityMainBinding.inflate(layoutInflater);"
 * - Primero coge la variable binding, que es una variable de tipo ActivityMainBinding que hemos creado
 * - Coge la clase ActivityMainBindig (que es el diseño XML convertido a una clase de kotlin, y cada propiedad es un elemento(vista) del XML)
 * - Accede al método .inflate de la clase ActivityMainBinding. Este método lo que hace es inflar la clase (convertir el XML en una jerarquía de objetos de vista en memoria)
 * -- Una "jerarquía de objetos de vista en memoria" es la estructura de objetos que se crea en la memoria RAM del dispositivo. Cuando inflas un diseño XML en Android, el sistema crea una jerarquía de objetos de vista en memoria que coincide con la estructura definida en el archivo XML. Esta jerarquía puede contener varios tipos de objetos de vista, como botones, cuadros de texto, imágenes, contenedores de diseño, etc.
 * - El método .inflate necesita un parámetro, que es layoutInflater. layoutInflater es un objeto (de la clase LayotutInflater), se encarga de decir cómo se tiene que inflar un diseño XML (o sea, dice, si tal cosa aparece en el XML, pues en kotlin creas esta otra cosa).
 * Entonces, en binding estamos guardando un objeto de la clase ActivityMainBinding que nos devuelve el usar el método .inflate()
 *
 * Líneas "val view: View = binding.root" y "setContentView(view)"
 * - El objeto (la instancia) de ActivityMainBinding tiene una propiedad llamada "root". Esta propiedad es la vista principal del diseño, y contiene todas las demás vistas definidas en el XML. La forma de representar las vistas en kotlin, es mediante la clase View, por lo tanto, devuelve un objeto de tipo View
 * - Finalmente, se usa setContentView para mostrar asignar una vista a esta actividad y mostrarla, y se le pasa por parámetro la vista que hemos creado a partir del binding(ActivityMainBinding), por lo tanto es esa la que va a usar.
 *
 *  */


class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater);
        val view: View = binding.root
        setContentView(view)

        acciones()
    }

    //Funcion acciones()
    // - establece un escuchador de clic en el botón con el ID "button1, button2..." que se ha vinculado utilizando ViewBinding. Cuando se hace clic en este botón, se llamará a la función onClick de la actividad actual (en este caso, MainActivity)

    private fun acciones() {

        binding.button0.setOnClickListener(this@MainActivity)
        binding.button1.setOnClickListener(this@MainActivity)
        binding.button2.setOnClickListener(this@MainActivity)
        binding.button3.setOnClickListener(this@MainActivity)
        binding.button4.setOnClickListener(this@MainActivity)
        binding.button5.setOnClickListener(this@MainActivity)
        binding.button6.setOnClickListener(this@MainActivity)
        binding.button7.setOnClickListener(this@MainActivity)
        binding.button8.setOnClickListener(this@MainActivity)
        binding.button9.setOnClickListener(this@MainActivity)

        binding.buttonDecimal.setOnClickListener(this@MainActivity)
        binding.buttonSumar.setOnClickListener(this@MainActivity)
        binding.buttonRestar.setOnClickListener(this@MainActivity)
        binding.buttonMultiplicar.setOnClickListener(this@MainActivity)
        binding.buttonDividir.setOnClickListener(this@MainActivity)
        binding.buttonPorcentaje.setOnClickListener(this@MainActivity)

        binding.buttonBorrar.setOnClickListener(this@MainActivity)
        binding.buttonAC.setOnClickListener(this@MainActivity)

        binding.buttonIgual.setOnClickListener(this@MainActivity)


    }


    //En la función onClick(p0: View?), se maneja la lógica de lo que sucede cuando se hace clic en un botón.
    // - El parámetro "v" es la vista (en este caso, el botón) que se ha hecho clic.
    override fun onClick(v: View?) {

        when (v?.id) {
            R.id.button0 -> binding.resultado.append("0")
            R.id.button1 -> binding.resultado.append("1");
            R.id.button2 -> binding.resultado.append("2");
            R.id.button3 -> binding.resultado.append("3");
            R.id.button4 -> binding.resultado.append("4");
            R.id.button5 -> binding.resultado.append("5");
            R.id.button6 -> binding.resultado.append("6");
            R.id.button7 -> binding.resultado.append("7");
            R.id.button8 -> binding.resultado.append("8");
            R.id.button9 -> binding.resultado.append("9");

            R.id.buttonSumar -> binding.resultado.append("+");
            R.id.buttonRestar -> binding.resultado.append("-");
            R.id.buttonMultiplicar -> binding.resultado.append("x");
            R.id.buttonDividir -> binding.resultado.append("/");

            R.id.buttonDecimal -> binding.resultado.append(".");

            R.id.buttonAC -> binding.resultado.setText("")

            R.id.buttonBorrar -> {
                var texto = binding.resultado.text.toString()
                if (texto.isNotEmpty()) {
                    binding.resultado.setText(texto.substring(0, texto.length - 1))
                }
            }

            //El contenido de la clase de texto es de tipo Editable, hay que convertirla a String con toString()

            R.id.buttonIgual -> {
                var operacion: String = binding.resultado.text.toString();
                if (operacion.contains("+")) { operar(operacion, "+") }
                else if (operacion.contains("-")) { operar(operacion, "-") }
                else if (operacion.contains("x")) { operar(operacion, "*") }
                else if (operacion.contains("/")) { operar(operacion, "/") }
            }
        }
    }

    fun operar(operacion: String, operador: String) {
        if (binding.resultado.text != null) {
            var operador1 = 0.0;
            var operador2 = 0.0;
            var operacionDividida = operacion.split(operador);

            //Operaciones de un miembro
            if (operacionDividida.size == 1) {
                operador1 = operacionDividida[0].toDouble();
                when (operador) {
                    "-" -> {
                        operador1 = operacionDividida[0].toDouble();
                        var operadorInvertido = operador1 * -1;
                        binding.resultado.setText(operadorInvertido.toString())}
                }
            }

            //Operaciones de dos miembros
            else if(operacionDividida.size == 2) {
                operador1 = operacionDividida[0].toDouble()
                operador2 = operacionDividida[1].toDouble()

                when (operador) {
                    "+" -> binding.resultado.setText((operador1 + operador2).toString());
                    "-" -> binding.resultado.setText((operador1 - operador2).toString());
                    "*" -> binding.resultado.setText((operador1 * operador2).toString());
                    "/" -> binding.resultado.setText((operador1 / operador2).toString());
                }
            }
            else {
                binding.resultado.setText("");
            }
        }
    }
}

//IMPORTANTE!!!!!!!!!
//Cuando se pulse en una operación, se va a chequear el número que va antes, y se recoge, y cuando se pulse en otro número, se chequeará el segundo número
// ej. pulso el más
// ejecuto la función cogerOperador1yOperando(String operando). Esa función va a coger el operador1, el símbolo de la operación se le pasa por parámetro y así no hay que cortar el string. Luego se escribe por pantalla después de que lo hemos guardado en una variable. y los guarda en variables y las devuelve
// introduzco otro número y pulso igual
// al pulsar igual se ejecuta la función cogerOperador2yOperar(Operador1, operación). Esa función coge el operador2 del texto, y se le pasan por parámetro el operador1 y el símbolo de la operación. Ejecuta la operación y la imprime en la caja de texto, y coge la operación y la imprime en la caja de texto de arriba

//Decimales
//simplemente meto un punto, y ya, luego convierto los números con .toDouble en las operaciones

//Operaciones de un solo miembro
// Cogen el número y el operador y realizan la operación