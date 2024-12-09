package entities

interface StudentInterface {
    fun write()
    fun failExam()
    fun read()
    fun passExam()
    fun cry()
    fun calculateNeedHelp(arrayList: ArrayList<Student>)
}