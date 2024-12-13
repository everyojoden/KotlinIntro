package exercicegrupo1.Entities

import exercicegrupo1.interfaces.AgendaInterface
import exercicegrupo1.Entities.Contact

class Agenda(var contacts: ArrayList<Contact>): AgendaInterface{

        override fun showRegards() {
                println("Bienvenid@ a tu agenda personal!")
                println("*** ------------------------ ***")
        }

        override fun showMenu() {
                println("*** ------------------------ ***")
                println("Elige una opción:")
                println("1. Crear contacto.")
                println("2. Leer contactos.")
                println("3. Modificar contacto.")
                println("4. Eliminar contacto.")
                println("5. Salir.")
        }

        override fun showContactsWhenListIsNotEmpty(contacts: ArrayList<Contact>) {
                println("*** ------------------------ ***")
                println("Contactos:")
                if (contacts.isEmpty()) {
                        println("No hay contactos que mostrar.")
                } else {
                        contacts.forEach { println(contacts.toString()) }
                }
        }

        override fun insertContact(newcontact: Contact, contacts: ArrayList<Contact>) {
                if (newcontact.phoneNumber.isEmpty() || newcontact.email.isEmpty()) {
                        println("Datos incompletos, no es posible guardar el nuevo contacto")
                } else {
                        println(newcontact.toString())
                        contacts.add(newcontact)
                        println("Se ha guardado tu nuevo contacto ${newcontact.name}!! Hurraaaaa!!")
                }
        }

        override fun updateContactFromContactsById(contacts: ArrayList<Contact>, contactId: Int): Boolean {
                val filteredContacts = contacts.filter { it.id == contactId }
                return if (filteredContacts.isEmpty()) {
                        false
                } else {
                        val contacto = Contact()
                        val outdatedContact = filteredContacts[0]
                        val updatedContact = contacto.updateContactValues(outdatedContact)
                        return if (updatedContact.phoneNumber.isEmpty() || updatedContact.email.isEmpty()) {
                                false
                        } else {
                                contacts.remove(outdatedContact)
                                contacts.add(updatedContact)
                                true
                        }
                }
        }

        override fun deleteContactFromContactsById(contacts: ArrayList<Contact>, id: Int): Boolean {
                val filteredContacts = contacts.filter { it.id == id }
                return if (filteredContacts.isEmpty()) {
                        false
                } else {
                        contacts.remove(filteredContacts[0])
                }
        }

        override fun updateContact(contacts: ArrayList<Contact>, contactId: Int) {
                var isUpdated = false
                if (contactId > 0) {
                        val contact = contacts.filter { it.id == contactId }
                        isUpdated = updateContactFromContactsById(contacts, contactId)
                        if (isUpdated) {
                                println("Contacto ${contact[0].name} actualizado exitosamente!.")
                        } else {
                                println("Lo siento, el contacto con id $contactId no se ha encontrado")
                        }
                }
        }

        override fun deleteContact(contacts: ArrayList<Contact>, contactId: Int) {
                var isDeleted = false
                if (contactId > 0) {
                        val contact = contacts.filter { it.id == contactId }
                        isDeleted = deleteContactFromContactsById(contacts, contactId)
                        if (isDeleted) {
                                println("Contacto ${contact[0].name} eliminado exitosamente!.")
                        } else {
                                println("Lo siento, el contacto en mención no existe")
                        }
                }
        }

        override fun getMockedContacts(): List<Contact> {
                return listOf(
                        Contact(
                                name = "Juan",
                                lastName = "Pérez",
                                phoneNumber = "123456890",
                                email = "juan.perez@example.com",
                                nickName = "Juancito",
                                isFavorite = true
                        ),
                        Contact(
                                name = "María",
                                lastName = "Gómez",
                                phoneNumber = "9876543210",
                                email = "maria.gomez@example.com",
                                nickName = "Mari",
                                isFavorite = false
                        ),
                        Contact(
                                name = "Carlos",
                                lastName = "Rodríguez",
                                phoneNumber = "4567890123",
                                email = "carlos.rodriguez@example.com",
                                nickName = "Carlitos",
                                isFavorite = true
                        ),
                        Contact(
                                name = "Ana",
                                lastName = "López",
                                phoneNumber = "3216549870",
                                email = "ana.lopez@example.com",
                                nickName = "Anita",
                                isFavorite = false
                        )
                )
        }
}