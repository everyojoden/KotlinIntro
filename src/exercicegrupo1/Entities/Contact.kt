package exercicegrupo1.Entities

class Contact(
    var name: String,
    var lastName: String,
    var phoneNumber: String,
    var email: String,
    var nickName: String,
    var isFavourite: Boolean
) {

    var id: Int = increment()
    fun checkNameFormat(name: String): String {
        return ""
    }

    override fun toString(): String {
        return "Contact(name='$name', lastName='$lastName', phoneNumber='$phoneNumber', email='$email', nickName='$nickName', isFavourite=$isFavourite, id=$id)"
    }


    companion object {

        private var lastId: Int = 1

        fun increment(): Int {
            return lastId++
        }

        fun isValidPhoneNumber(): Boolean {
            return false
        }

        fun isValidName(): Boolean {
            return false
        }

        fun isFavoriteValueValid(isFavorite: String?): Boolean? {
            val value = isFavorite?.trim()?.lowercase() ?: ""
            return when (value) {
                "true", "ok", "1", "y", "si", "sí", "valido", "si es", "dale" -> true
                "false", "ko", "0", "n", "no","nó", "invalido", "no es", "que no" -> false
                else -> null
            }
        }

    }


}



