package exercicegrupo1.interfaces


import exercicegrupo1.Entities.Contact

interface AgendaInterface {

    fun showMenu()

    fun showRegards()

    fun getMockedContacts(): List<Contact>

    fun showContactsWhenListIsNotEmpty(contacts: ArrayList<Contact>)

    fun insertContact(newcontact: Contact, contacts: ArrayList<Contact>)

    fun updateContactFromContactsById(contacts: ArrayList<Contact>, contactId: Int): Boolean

    fun deleteContactFromContactsById(contacts: ArrayList<Contact>, id: Int): Boolean

    fun updateContact(contacts: ArrayList<Contact>, contactId: Int)

    fun deleteContact(contacts: ArrayList<Contact>, contactId: Int)

}
