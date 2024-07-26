package com.example.contactsmanagerapp

import android.app.Application
import android.os.Handler
import android.os.Looper
import androidx.lifecycle.LiveData
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors

class Repository(application: Application) {

    private val contactDatabase: ContactDatabase = ContactDatabase.getInstance(application)
    private val contactDAO: ContactDAO = contactDatabase.getContactDao()
    // Methods in DAO being executed from repository

    //used for bg operation
    private var executor: ExecutorService = Executors.newSingleThreadExecutor()

    //used for updating te UI
    private var handler: Handler = Handler(Looper.getMainLooper())

    //executed asynchronously on separate thread
    fun addContact(contact: Contacts) = executor.execute { contactDAO.insert(contact) }

    fun deleteContact(contact: Contacts) = executor.execute { contactDAO.delete(contact) }

    fun getAllContact(): LiveData<List<Contacts>> {
        return contactDAO.getAllContacts()
    }

}