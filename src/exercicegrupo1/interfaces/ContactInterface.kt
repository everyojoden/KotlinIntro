package exercicegrupo1.interfaces

import exercicegrupo1.Entities.Contact

interface ContactInterface {

    fun askForPhoneNumber(): Int

    fun getValidPhone(newNumber: String, parsedNumber: Int): Int

    fun askForIsFavourite(): Boolean

    fun askForEmail(): String

    fun updateEmail(lastEmail: String): String

    fun getAtTotalAmount(email: String): Int

    fun isFavoriteValueValid(isFavorite: String?): Boolean?

    fun createContact(): Contact

    fun updateContactValues(contact: Contact): Contact
}