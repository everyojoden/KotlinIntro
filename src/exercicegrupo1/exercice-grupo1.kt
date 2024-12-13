package exercicegrupo1

import exercicegrupo1.Entities.Agenda
import exercicegrupo1.Entities.Contact
import kotlin.contracts.Returns

fun main() {
    /*
    * Crea una aplicación que permita al usuario crear, modificar, eliminar y listar contactos.
    * SIN PERSISTENCIA.
    *
     */

    /*
    * 1. Crear clases Contacto y Agenda (crear primero la entidad más debil)
    * 2. Crear Menu informativo
    *       a. Saludos
    *       b. Menu (Visualizar sus opciones)
    * 3. Enseñar al usuario saludos
    * 4. Si hay contactos, enseñar
    * 5. Enseñar menu.
    * 6. Pedir opcion al usuario respecto al menu
    * 7. Evaluamos la respuesta del usuario
    * 8. En funcion de la respuesta lo llevamos a un lado o a otro.
    * 9. Definimos y programamos la función de borrar contacto
    * 10. ""                  ""            de crear contacto (in progress)
    * 11. ""                  ""            de actualizar contacto (pending)
    * 12.
     */

    var agenda = Agenda(arrayListOf())
    var isOn = true
    var optionMenu: Int = -1

    agenda.contacts.addAll(getMockedContacts())

    showRegards()

    readAndShowContacts(agenda.contacts)

    do {
        showMenu()
        optionMenu = getUserSelection()
        isOn = evaluateOptionAndContacts(optionMenu, agenda.contacts)
    } while (isOn)
}

fun evaluateOptionAndContacts(option: Int, contacts: ArrayList<Contact>): Boolean {
    return when (option) {
        1 -> {
            //Create
            val newcontact = createContact()
            if (newcontact.phoneNumber.isEmpty() || newcontact.email.isEmpty()) {
                println("Datos incompletos, no es posible guardar el nuevo contacto")
            } else {
                println(newcontact.toString())
                contacts.add(newcontact)
                println("Se ha guardado tu nuevo contacto ${newcontact.name}!! Hurraaaaa!!")
            }
            true
        }

        2 -> {
            //Read
            readAndShowContacts(contacts)
            true
        }

        3 -> {
            //Update
            var isUpdated = false
            println("Ingresa el ID del contacto a actualizar")
            val contactId = getUserSelection()
            if (contactId > 0) {
                val contact = contacts.filter { it.id == contactId }
                isUpdated = updateContactFromContactsById(contacts, contactId)
                if (isUpdated) {
                    println("Contacto ${contact[0].name} actualizado exitosamente!.")
                } else {
                    println("Lo siento, el contacto con id $contactId no se ha encontrado")
                }
            }
            true
        }

        4 -> {
            //Delete
            var isDeleted = false
            println("Ingresa el ID del contacto a borrar")
            val contactId = getUserSelection()
            if (contactId > 0) {
                val contact = contacts.filter { it.id == contactId }
                isDeleted = deleteContactFromContactsById(contacts, contactId)
                if (isDeleted) {
                    println("Contacto ${contact[0].name} eliminado exitosamente!.")
                } else {
                    println("Lo siento, el contacto en mención no existe")
                }
            }
            true
        }

        5 -> { //Go back, kill the app... GoodBye!
            println("Gracias por hacer uso de tu agenda personal, vuelve pronto!")
            false
        }

        else -> {
            println("Opcion invalida...vuelve a intentarlo!")
            true
        }
    }
}

fun getUserSelection(): Int {
    val option = readlnOrNull()?.toIntOrNull()
    return if (option is Int) {
        option
    } else {
        -1
    }
}

fun showRegards() {
    println("Bienvenid@ a tu agenda personal!")
    println("*** ------------------------ ***")
}

fun showMenu() {
    println("*** ------------------------ ***")
    println("Elige una opción:")
    println("1. Crear contacto.")
    println("2. Leer contactos.")
    println("3. Modificar contacto.")
    println("4. Eliminar contacto.")
    println("5. Salir.")
}

fun createContact(): Contact {
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
        isFavourite = isFavorite
    )
}

fun getAtTotalAmount(email: String): Int {
    var counter = 0
    email.forEach {
        if (it == '@') {
            counter++
        }
    }
    return counter
}

fun updateEmail(lastEmail: String): String {
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

fun askForEmail(): String {
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

fun askForPhoneNumber(): Int {
    var phoneNumber = 0
    while (phoneNumber == 0) {
        println("Ingresar número telefónico:")
        phoneNumber = getValidPhoneNumber(readlnOrNull())
    }
    return phoneNumber
}

fun getValidPhoneNumber(phone: String?): Int {
    //1. Solo NUMEROS
    //2. minimo 3 digitos
    var newNumber = phone ?: ""
    var parsedNumber = 0

    if (newNumber.isEmpty()) {
        return 0
    } else {
        newNumber = newNumber.filter { !it.equals(" ") }
        if (newNumber.length > 2) {
            parsedNumber = newNumber.toIntOrNull() ?: 0
            return parsedNumber
        } else {
            return 0
        }
    }
}

private fun askForIsFavourite(): Boolean {
    var isFavourite: Boolean? = null
    while (isFavourite == null) {
        println("El contacto será un favorito?")
        println("Ingresa 'true' si es favorito, 'false' si no lo es.")
        isFavourite = Contact.isFavoriteValueValid(readlnOrNull())

        if (isFavourite == null) {
            println("Error: Has ingreso un valor invalido...Vuelve a intentarlo!")
        }
    }
    return isFavourite
}

fun readAndShowContacts(contacts: ArrayList<Contact>) {
    println("*** ------------------------ ***")
    println("Contactos:")
    if (contacts.isEmpty()) {
        println("No hay contactos")
    } else {
        contacts.forEachIndexed { index, contact ->
            val position = index + 1
            println(contact.toString())
        }
    }
}

fun updateContactFromContactsById(contacts: ArrayList<Contact>, contactId: Int): Boolean {
    val filteredContacts = contacts.filter { it.id == contactId }
    return if (filteredContacts.isEmpty()) {
        false
    } else {
        val outdatedContact = filteredContacts[0]
        val updatedContact = updateContactValues(outdatedContact)
        return if (updatedContact.phoneNumber.isEmpty() || updatedContact.email.isEmpty()) {
            false
        } else {
            contacts.remove(outdatedContact)
            contacts.add(updatedContact)
            true
        }
    }
}

fun updateContactValues(contact: Contact): Contact {
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
    contact.isFavourite = isFavorite
    contact.email = email

    return contact
}

fun deleteContactFromContactsById(contacts: ArrayList<Contact>, id: Int): Boolean {
    val filteredContacts = contacts.filter { it.id == id }
    return if (filteredContacts.isEmpty()) {
        false
    } else {
        contacts.remove(filteredContacts[0])
    }
}

fun getMockedContacts(): List<Contact> {
    return listOf(
        Contact(
            name = "Juan",
            lastName = "Pérez",
            phoneNumber = "123456890",
            email = "juan.perez@example.com",
            nickName = "Juancito",
            isFavourite = true
        ),
        Contact(
            name = "María",
            lastName = "Gómez",
            phoneNumber = "9876543210",
            email = "maria.gomez@example.com",
            nickName = "Mari",
            isFavourite = false
        ),
        Contact(
            name = "Carlos",
            lastName = "Rodríguez",
            phoneNumber = "4567890123",
            email = "carlos.rodriguez@example.com",
            nickName = "Carlitos",
            isFavourite = true
        ),
        Contact(
            name = "Ana",
            lastName = "López",
            phoneNumber = "3216549870",
            email = "ana.lopez@example.com",
            nickName = "Anita",
            isFavourite = false
        )
    )
}