package entities

interface ClassInterface {
    fun addStudent(student: Student)
    fun searchStudents(allStudents: ArrayList<Student>):ArrayList<Student>
    fun filterApprovedProgressing(allStudents: ArrayList<Student>):ArrayList<Student>
    fun isFailAndNeedHelp(allStudents: ArrayList<Student>):ArrayList<Student>
    fun getAllFailingStudents(allClassRooms: ArrayList<ClassRoom>):ArrayList<Student>
}