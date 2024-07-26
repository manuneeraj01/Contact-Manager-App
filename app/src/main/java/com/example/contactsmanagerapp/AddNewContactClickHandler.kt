package com.example.contactsmanagerapp

import android.content.Context
import android.content.Intent
import android.view.View
import android.widget.Toast

class AddNewContactClickHandler(
    private val context: Context,
    val contacts: Contacts,
    private val viewModel: MyViewModel
) {

    fun onSubmitBtnClicked(view: View) {
        if (contacts.name.isEmpty() || contacts.email.isEmpty()) {
            Toast.makeText(context, "Fields cannot be empty", Toast.LENGTH_SHORT).show()
        } else {
            viewModel.addNewContact(Contacts(name = contacts.name, email = contacts.email))
            context.startActivity(Intent(context, MainActivity::class.java))
        }
    }
}