fun main(){
    val addArray = addNumberInArray(arrayOf(1, 3, 4, 6, 7, 8), 5, 2)
    println(addArray.joinToString())

    val checkArray = numberCheckInArray(arrayOf(1, 3, 4, 6, 7, 8), 3)
    println(checkArray)

    val countInArray= countRepeatInArray(arrayOf(1, 3, 3, 6, 7, 8), 3)
    println(countInArray)

    val sortInArray= sortArray(arrayOf(1, 3, 2, 6, 5, 8))
    println(sortInArray.joinToString())

    val addStringInArray= addStringArray(arrayOf("aa","bb","cc","dd"),"jj")
    println(addStringInArray.joinToString())

    val numberArrayFind= findNumber(arrayOf(1, 3, 4, 2, 7, 8))
    println(numberArrayFind)

}

fun addNumberInArray(arr: Array<Int>, num: Int, pos: Int):Array<Int>{

    val arrayList = arr.toMutableList()
    arrayList.add(pos,num)
    return arrayList.toTypedArray()
}

fun numberCheckInArray(arr: Array<Int>, num:Int):Boolean{

    var isChecked= false
    if(arr.contains(num)){
        isChecked=true
    }
    return isChecked
}

fun countRepeatInArray(arr: Array<Int>, num: Int):Int{

    var count=0
    for(i in arr){
        if(i == num){
            count++
        }
    }
    return count
}

fun sortArray(arr: Array<Int>):Array<Int>{
    var array= arr.toMutableList()

    for (i in 0..<array.size) {
        for (j in 0..<array.size - 1) {
            if (array[j] < array[j + 1]) {
                val arrayAux = array[j]
                array[j] = array[j + 1]
                array[j + 1] = arrayAux
            }
        }
    }
    return array.toTypedArray()
}

fun addStringArray(arr: Array<String>, element:String):Array<String>{
    val array = arr.toMutableList()
    array.add(element)
    return array.toTypedArray()
}

fun findNumber(arr: Array<Int>):Int{
    var num=1
    arr.sort()
    for(i in 1..1000000){
        num=i
        for(j in arr){
            if(arr.contains(num))
                num++
        }
        break
    }
    return num
}