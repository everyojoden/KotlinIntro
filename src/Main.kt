import javax.xml.transform.sax.SAXSource

fun main() {
    //Entero
    val integer: Int = 29
    val largo: Long = 2000000000L
    //Flotante
    val flotante: Float = 3.14f
    val doble: Double = 3.141592655999909
    //Booleanos
    var isFavorite: Boolean = true
    isFavorite = false

    //Caracteres (Char)
    val characterr: Char = 'k'

    //Cadenas
    val regards: String = "Hola mundo"

    print("Entero: " + integer)
    print("Boolean:" + isFavorite)

    //bucles
    for (i in 1..5) {
        println("Value for i: " + i)
    }

    //3.When (Cases) <-
    var valueA = 3
    var valueB = 5

    val day = 3
    //while (valueA < valueB)
      //  print("Hola soy pepe")

    when (day) {
        1 -> println("Hoy es lunes")
        2 -> println("Hoy es martes")
        3 -> println("Hoy es miercoles")
        4 -> println("Hoy es jueven")
        5 -> println("Hoy es viernes")
        6 -> println("Hoy es sabado")
        else -> {
            print("No has ingresado un valor")
        }
    }
    println()
}





