package entities


class ClassRoom(val id:Int, val name:String, var students:ArrayList<Student>
):ClassInterface {
    override fun addStudent(student: Student) {
        students.add(student)
    }

    override fun searchStudents(allStudents: ArrayList<Student>): ArrayList<Student> {

            //var  arrayWordA = students.filter { it.name.contains("a", ignoreCase = true)} as ArrayList<Student>
            //return arrayWordA

        val arrayWordA = ArrayList<Student>()
        for (student in students) {
            if (student.name.contains("a", ignoreCase = true)) {
                arrayWordA.add(student)
            }
        }
        return arrayWordA
    }

    override fun filterApprovedProgressing(allStudents: ArrayList<Student>): ArrayList<Student> {
        val filteredArray = ArrayList<Student>()
        for(student in students){
            if(student.isApproved && student.isProgressing){
                filteredArray.add(student)
            }
        }
        return filteredArray
    }

    override fun isFailAndNeedHelp(allStudents: ArrayList<Student>):ArrayList<Student> {
        val filteredArray = ArrayList<Student>()
        for(student in students){
            student.calculateNeedHelp(students)
            if(!student.isApproved && student.needHelp){
                filteredArray.add(student)
            }
        }
        return filteredArray
    }

    override fun getAllFailingStudents(allClassRooms: ArrayList<ClassRoom>): ArrayList<Student> {

        val filteredArray = ArrayList<Student>()

        for (classRoom in allClassRooms) {
            for (student in classRoom.students) {
                if (!student.isApproved) {
                    filteredArray.add(student)
                }
            }
        }
        return filteredArray
    }


    override fun toString(): String {
        return "ClassRoom(id=$id, name='$name', students=$students)"
    }

}

class Student(val id:Int, val name: String, var age: Int, var isApproved:Boolean, var isProgressing:Boolean, var needHelp: Boolean):StudentInterface{

    override fun write() {

    }

    override fun failExam() {

    }

    override fun read() {

    }

    override fun passExam() {

    }

    override fun cry() {

    }

    override fun calculateNeedHelp(arrayList: ArrayList<Student>) {
        if(!isApproved || !isProgressing){
            needHelp=true
        }else{
            needHelp=false
        }
    }


    override fun toString(): String {
        return "Student(id=$id, name='$name', age=$age, isApproved='$isApproved', isProgressing='${isProgressing}', needHelp='${needHelp})"
    }

}

//definir interfaz



fun main(){

    val studentsA: ArrayList<Student> = arrayListOf()
    val studentsB: ArrayList<Student> = arrayListOf()

    studentsA.add(Student(1,"Manolo",40, true, true, false))
    studentsA.add(Student(2,"Pepe",33, false, false, false))
    studentsA.add(Student(3,"Paco",22, false , false, false))

    studentsB.add(Student(4,"Manolo",40, true , true, false))
    studentsB.add(Student(5,"Pepe",33, true ,true, false))
    studentsB.add(Student(6,"Paco",22, false , false, false))

    val classRoomA = ClassRoom(1, "Jueves", studentsA)
    val classRoomB = ClassRoom(2,"viernes", studentsB)

    println(classRoomA.students)
    println(classRoomB.name)
    println(classRoomA.searchStudents(studentsA))
    println(classRoomB.filterApprovedProgressing(studentsB))
    println(classRoomA.isFailAndNeedHelp(studentsA))

}