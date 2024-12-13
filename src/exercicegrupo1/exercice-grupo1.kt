package exercicegrupo1

import exercicegrupo1.Entities.Agenda
import exercicegrupo1.Entities.Contact
import exercicegrupo1.Entities.MainThread
import kotlin.contracts.Returns

fun main() {
    val main = MainThread()
    val agenda = Agenda(arrayListOf())
    var isOn = true
    var optionMenu: Int = -1

    agenda.contacts.addAll(agenda.getMockedContacts())
    agenda.showRegards()
    agenda.showContactsWhenListIsNotEmpty(agenda.contacts)

    do {
        agenda.showMenu()
        optionMenu = main.getUserSelection()
        isOn = main.evaluateOptionAndContacts(optionMenu, agenda)
    } while (isOn)
}