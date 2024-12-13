package exercicegrupo1.Entities

import exercicegrupo1.interfaces.ContactInterface


class Contact( //Declaramos los atributos necesarios para crear un objeto entities.Contact
    var name: String,
    var lastName: String,
    var phoneNumber: String,
    var email: String,
    var nickName: String,
    var isFavorite: Boolean
) : ContactInterface {
    val id: Int = incrementAndGetLastId()

    constructor() : this(
        name = "",
        lastName = "",
        phoneNumber = "",
        email = "",
        nickName = "",
        isFavorite = false
    )

    constructor(name: String, lastName: String) : this(
        name = name, lastName = lastName, phoneNumber = "", email = "", nickName = "", isFavorite = false
    )

    override fun askForPhoneNumber(): Int {
        var phoneNumber = 0
        while (phoneNumber == 0) {
            println("Ingresar número telefónico:")
            phoneNumber = getValidPhone(readlnOrNull() ?: "", 0)
        }
        return phoneNumber
    }

    override fun getValidPhone(newNumber: String, parsedNumber: Int): Int {
        var newNumber1 = newNumber
        var parsedNumber1 = parsedNumber
        if (newNumber1.isEmpty()) {
            return 0
        } else {
            newNumber1 = newNumber1.filter { !it.equals(" ") }
            if (newNumber1.length > 2) {
                parsedNumber1 = newNumber1.toIntOrNull() ?: 0
                return parsedNumber1
            } else {
                return 0
            }
        }
    }

    override fun askForIsFavourite(): Boolean {
        var isFavourite: Boolean? = null
        while (isFavourite == null) {
            println("El contacto será un favorito?")
            println("Ingresa 'true' si es favorito, 'false' si no lo es.")
            isFavourite = isFavoriteValueValid(readlnOrNull())

            if (isFavourite == null) {
                println("Error: Has ingreso un valor invalido...Vuelve a intentarlo!")
            }
        }
        return isFavourite
    }


    override fun askForEmail(): String {
        var email = ""
        while (email.isEmpty()) {
            println("Ingresar Email:")
            email = readlnOrNull() ?: ""

            if (getAtTotalAmount(email) == 1) {
                val pieces = email.split("@")
                val hasDotOnSecondPart = pieces[1].contains(".")
                if (!hasDotOnSecondPart) {
                    email = ""
                }
            } else {
                email = ""
            }

            if (email.isEmpty()) {
                println("El Email no cumple con los requerimientos mínimos :(")
            }
        }
        return email
    }

    override fun updateEmail(lastEmail: String): String {
        println("Ingresar Email:")
        var email = readlnOrNull() ?: ""

        if (getAtTotalAmount(email) == 1) {
            val pieces = email.split("@")
            val hasDotOnSecondPart = pieces[1].contains(".")
            if (!hasDotOnSecondPart) {
                email = lastEmail
            }
        } else {
            email = lastEmail
        }
        return email
    }

    override fun getAtTotalAmount(email: String): Int {
        var counter = 0
        email.forEach {
            if (it == '@') {
                counter++
            }
        }
        return counter
    }

    override fun isFavoriteValueValid(isFavorite: String?): Boolean? {
        val value = isFavorite?.trim()?.lowercase() ?: ""
        return when (value) {
            "true", "ok", "1", "y", "si", "sí", "valido", "si es", "dale" -> true
            "false", "ko", "0", "n", "no", "nó", "invalido", "no es", "que no" -> false
            else -> null
        }
    }

    override fun createContact(): Contact {
        println("Nuevo Contacto")
        println("Ingresar Nombre:")
        val name = readlnOrNull() ?: ""
        println("Ingresar Apellidos:")
        val lastname = readlnOrNull() ?: ""
        println("Ingresar Nickname:")
        val nickname = readlnOrNull() ?: ""
        val phone = askForPhoneNumber()
        val isFavorite = askForIsFavourite()
        val email = askForEmail()

        return Contact(
            name = name,
            lastName = lastname,
            nickName = nickname,
            phoneNumber = phone.toString(),
            email = email,
            isFavorite = isFavorite
        )
    }

    override fun updateContactValues(contact: Contact): Contact {
        println("*** --------UPDATE-------- ***")
        println("Vas a modificar al siguiente contacto:")
        println(contact.toString())
        println("Ingresar Nombre:")
        val name = readlnOrNull() ?: contact.name
        println("Ingresar Apellidos:")
        val lastname = readlnOrNull() ?: contact.lastName
        println("Ingresar Nickname:")
        val nickname = readlnOrNull() ?: contact.nickName
        val phone = askForPhoneNumber()
        val isFavorite = askForIsFavourite()
        val email = updateEmail(contact.email)

        contact.name = name
        contact.lastName = lastname
        contact.nickName = nickname
        contact.phoneNumber = phone.toString()
        contact.isFavorite = isFavorite
        contact.email = email

        return contact
    }

    override fun toString(): String {
        return if (nickName.isEmpty()) {
            "Id:$id, name: $name, lastName: $lastName, phoneNumber: $phoneNumber, email: $email, isFavorite: $isFavorite"
        } else {
            "Id:$id, nickName: $nickName, phoneNumber: $phoneNumber, email: $email, isFavorite: $isFavorite"
        }
    }

    companion object {
        private var lastId: Int = 1

        private fun incrementAndGetLastId(): Int {
            return lastId++
        }

        fun getEmptyContact() {

        }



    }
}

