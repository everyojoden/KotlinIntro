package entities

interface ClassInterface {
    fun addStudent(student: Student)
    fun searchStudents(students: ArrayList<Student>):ArrayList<Student>
    fun filterApprovedProgressing(students: ArrayList<Student>):ArrayList<Student>
    fun isFailAndNeedHelp(students: ArrayList<Student>):ArrayList<Student>
    fun getAllFailingStudents(allClassRooms: ArrayList<ClassRoom>):ArrayList<Student>
}