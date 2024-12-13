package exercicegrupo1.interfaces

import exercicegrupo1.Entities.Agenda

interface MainInterface {

    fun getUserSelection(): Int

    fun evaluateOptionAndContacts(option: Int, agenda: Agenda): Boolean
}