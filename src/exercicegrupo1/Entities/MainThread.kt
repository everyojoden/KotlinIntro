package exercicegrupo1.Entities

import exercicegrupo1.interfaces.MainInterface

class MainThread(): MainInterface {
    override fun getUserSelection(): Int {
        val option = readlnOrNull()?.toIntOrNull()
        return if (option is Int) {
            option
        } else {
            -1
        }
    }

    override fun evaluateOptionAndContacts(option: Int, agenda: Agenda): Boolean {
        return when (option) {
            1 -> {
                //Create
                val c = Contact()
                val newcontact = c.createContact()
                agenda.insertContact(newcontact, agenda.contacts)
                true
            }

            2 -> {
                //Read
                agenda.showContactsWhenListIsNotEmpty(agenda.contacts)
                true
            }

            3 -> {
                //Update
                println("Ingresa el ID del contacto a actualizar")
                val contactId = getUserSelection()
                agenda.updateContact(agenda.contacts, contactId)
                true
            }

            4 -> {
                //Delete
                println("Ingresa el ID del contacto a borrar")
                val contactId = getUserSelection()
                agenda.deleteContact(agenda.contacts, contactId)
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
}