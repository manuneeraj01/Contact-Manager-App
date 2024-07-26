package com.example.contactsmanagerapp

import android.content.Context
import android.content.Intent
import android.view.View

class MainActivityClickHandler(private val context: Context) {

    fun onFabClicked(view: View) {
        context.startActivity(Intent(view.context, AddNewContactActivity::class.java))
    }
}