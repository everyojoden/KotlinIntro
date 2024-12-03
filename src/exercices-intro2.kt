fun main(){

    //Concatenar palabras
    val resultadoCadena= concatenarCadenas("esto es una cadena", "otra cadena")
    println("${resultadoCadena}")

    //replace
    val cadenaSustituida= sustituirPalabra("Almendra")
    println("$cadenaSustituida")

    val borrarLetras= borrarLetra("Hola caracola")
    println("${borrarLetras}")

    val silabasDobles= duplicarSilaba("Hola caracola")
    println("${silabasDobles}")

    val compararCaracteres= verificacionCaracteres("lale lela")
    println("${compararCaracteres}")

    val compararMayusculas = comprobarMayusculas("hola","HOLA")
    println("${compararMayusculas}")
}

fun concatenarCadenas(cadena1:String, cadena2:String):String
{
    return "$cadena1 $cadena2"
}

fun sustituirPalabra(cadena:String):String {
      return cadena.lowercase().replace("a","i")

}

fun borrarLetra(frase:String):String {

    var numLetras=frase.lowercase().length
    return frase.substring(1,numLetras-1)

}

fun duplicarSilaba(frase:String):String {

    var fraseRecortada= frase.substring(0,2)
    var fraseDuplicada= fraseRecortada + fraseRecortada
    return fraseDuplicada
}

fun verificacionCaracteres(frase:String):Boolean{

    var tamanoFrase=frase.lowercase().length
    var isEqual= true
    var letrasIniciales=frase.substring(0,2)
    var letrasFinales=frase.substring(tamanoFrase-2,tamanoFrase)
    if(letrasIniciales != letrasFinales){
        isEqual=false
    }
    return isEqual
}

fun comprobarMayusculas(palabra1:String, palabra2:String):Boolean{
    var isMayus=false

    if(palabra1.lowercase()==palabra2.lowercase()){
        isMayus=true
    }
    return isMayus
}
