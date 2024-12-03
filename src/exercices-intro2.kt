fun main() {

    //Concatenar palabras
    val resultString  = concatenateStrings("esto es una cadena", "otra cadena")
    println("${resultString }")

    //replace
    val replacedString  = replaceWord("Almendra")
    println("$replacedString ")

    val removedLetters  = removeLetter("hola caracolo", 'o')
    println("${removedLetters }")

    val doubleSyllables  = duplicateSyllable("Hola caracola")
    println("${doubleSyllables }")

    val compareCharacters  = verifyCharacters("lale lela")
    println("${compareCharacters }")

    val compareUppercase  = checkUppercase("hola", "HOLA")
    println("${compareUppercase }")
}

fun concatenateStrings(phrase1: String, phrase2: String): String {
    return "$phrase1 $phrase2"
}

fun replaceWord(phrase1: String): String {
    return phrase1.lowercase().replace("a", "i")

}

fun removeLetter(phrase1: String, word: Char): String {

    var modifiedPh = phrase1.lowercase()
    var numLetras = phrase1.lowercase().length
    if (phrase1.startsWith(word)) {
        modifiedPh = phrase1.substring(1, numLetras)
    }
    if (phrase1.endsWith(word)) {
        modifiedPh = phrase1.substring(0, numLetras - 1)
    }
    return modifiedPh
}

fun duplicateSyllable(phrase1: String): String {

    var cutPhrase = phrase1.substring(0, 2)
    var duplicatePhrase = cutPhrase + cutPhrase
    return duplicatePhrase
}

fun verifyCharacters(phrase1: String): Boolean {

    var phraseSize = phrase1.lowercase().length
    var isEqual = true
    var initialWords = phrase1.substring(0, 2)
    var finalWords = phrase1.substring(phraseSize - 2, phraseSize)
    if (initialWords != finalWords) {
        isEqual = false
    }
    return isEqual
}

fun checkUppercase(word1: String, word2: String): Boolean {
    var isMayus = false

    if (word1.lowercase() == word2.lowercase()) {
        isMayus = true
    }
    return isMayus
}
