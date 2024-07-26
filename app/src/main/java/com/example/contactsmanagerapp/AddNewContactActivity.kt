package com.example.contactsmanagerapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.contactsmanagerapp.databinding.ActivityAddNewContactBinding

class AddNewContactActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAddNewContactBinding
    private lateinit var handler: AddNewContactClickHandler
    private lateinit var contact: Contacts


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_add_new_contact)

        contact = Contacts()

        val viewModel = ViewModelProvider(this)[MyViewModel::class.java]

        handler = AddNewContactClickHandler(this, contact, viewModel)

        binding.contact = contact
        binding.clickHandler = handler
    }
}