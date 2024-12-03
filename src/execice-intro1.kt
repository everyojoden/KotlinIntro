fun main(){

    //Suma
    val resultadoSuma = suma(154, 352)
    println("Resultado de la suma es ${resultadoSuma}")

    //Multiplicacion
    val resultadoMultiplicacion = multiplicacion(154, 352)
    println("Resultado de la multiplicacion es ${resultadoMultiplicacion}")

    //Division
    val resultadoDivision = division(154.0, 352.0)
    println("Resultado de la division es ${resultadoDivision}")

    //DivisionConParteEntera
    val resultadoDivisionParteEntera = divisionConParteEntera(777.0, 352.0)
    println("La parte entera de la division es ${resultadoDivisionParteEntera}")

    //PorcentajeVictorias
    val resultadoPorcentajes = porcentajeVictorias(14, 9)
    println("El porcentaje de victorias es del : ${resultadoPorcentajes}")

    //Número mayor
    val resultadoMayor = numMayor(154, 352)
    println("El mayor es : ${resultadoMayor}")


    //Calcular volumen
    val resultadoVolumen = calcularVolumen(154.5, 352.5,  233.4)
    println("El volumen es : ${resultadoVolumen}")

    //Numeros Primos

    val resultadoNumerosPrimos = numerosPrimos(7)
    println("Los numeros primos son: ${resultadoNumerosPrimos}")



}

fun suma(num1: Int, num2: Int): Int {
    return num1 + num2
}

fun multiplicacion(num1: Int, num2: Int): Int {
    return num1 * num2
}

fun division(dividendo: Double, divisor: Double): Double? {
    return if (divisor == 0.0)
        null
    else {
        dividendo / divisor

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
    return if(num1 > num2){
        num1
    }
    else num2
}

fun calcularVolumen(valorAncho: Double, valorLargo: Double, valorAlto: Double): Double{
    return valorAncho*valorLargo*valorAlto
}

fun numerosPrimos(numElementos: Int): List<Int> {
    val listaPrimos = mutableListOf<Int>()
    var num = 2 //El 1 no se considera primo

    while (listaPrimos.size < numElementos) {
        var esPrimo = true

        for (i in 2 until num) {
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