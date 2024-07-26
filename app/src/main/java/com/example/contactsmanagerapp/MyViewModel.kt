package com.example.contactsmanagerapp

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData

class MyViewModel(private val application: Application) :
    AndroidViewModel(application = application) {

    private val myRepository: Repository = Repository(application = application)

    private lateinit var allContacts : LiveData<List<Contacts>>

    fun getAllContacts() : LiveData<List<Contacts>>{
        allContacts = myRepository.getAllContact()
        return allContacts
    }

    fun addNewContact(contacts: Contacts) = myRepository.addContact(contacts)

    fun deleteContact(contacts: Contacts) = myRepository.deleteContact(contacts)

}