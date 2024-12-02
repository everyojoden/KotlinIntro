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

    //Suma
    var resultadoSuma = suma(154, 352)
    println("Resultado de la suma es $resultadoSuma")

    //Multiplicacion
    var resultadoMultiplicacion = multiplicacion(154, 352)
    println("Resultado de la multiplicacion es $resultadoMultiplicacion")

    //Division
    var resultadoDivision = division(154.0, 352.0)
    println("Resultado de la division es $resultadoDivision")

    //DivisionConParteEntera
    var resultadoDivisionParteEntera = divisionConParteEntera(777.0, 352.0)
    println("La parte entera de la division es $resultadoDivisionParteEntera")

    //PorcentajeVictorias
    var resultadoPorcentajes = porcentajeVictorias(14, 9)
    println("El porcentaje de victorias es del : $resultadoPorcentajes")

    //Número mayor
    var resultadoMayor = numMayor(154, 352)
    println("El mayor es : $resultadoMayor")


   //Calcular volumen
    var resultadoVolumen = calcularVolumen(154.5, 352.5,  233.4)
    println("El volumen es : $resultadoVolumen")

    //Numeros Primos

    var resultadoNumerosPrimos = numerosPrimos(7)
    println("Los numeros primos son: $resultadoNumerosPrimos")



}

fun suma(num1: Int, num2: Int): Int {
    return num1 + num2
}

fun multiplicacion(num1: Int, num2: Int): Int {
    return num1 * num2
}

fun division(dividendo: Double, divisor: Double): Double? {
    if (divisor == 0.0)
        return null
    else {
        return dividendo / divisor

    }
}

fun divisionConParteEntera(dividendo: Double, divisor: Double): Int? {
    if (divisor == 0.0) {
        return null
    } else {
        var resultadoEntero = dividendo / divisor
        return resultadoEntero.toInt()
    }
}

fun porcentajeVictorias(numPartidos: Int, numPartidosGanados: Int): Double{
    return (numPartidosGanados.toDouble()/numPartidos.toDouble())*100

}

fun numMayor(num1: Int, num2: Int): Int{
    if(num1 > num2){
        return num1
    }
    else return num2
}

fun calcularVolumen(valorAncho: Double, valorLargo: Double, valorAlto: Double): Double{
    return valorAncho*valorLargo*valorAlto
}

fun numerosPrimos(numElementos: Int): List<Int> {
    val listaPrimos = mutableListOf<Int>()
    var num = 2 //El 1 no se considera primo

    while (listaPrimos.size < numElementos) {
        var esPrimo = true

        for (i in 2..num/2) {
            if (num % i == 0) {
                esPrimo = false
                break
            }
        }
        if (esPrimo) {
            listaPrimos.add(num)
        }
        num++
    }

    return listaPrimos
}





