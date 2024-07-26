package com.example.contactsmanagerapp

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import com.example.contactsmanagerapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var handlers: MainActivityClickHandler
    private val contactList = ArrayList<Contacts>()
    private lateinit var contactDb: ContactDatabase
    private lateinit var rvAdapter: MyAdapter
    private lateinit var viewModel: MyViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        handlers = MainActivityClickHandler(this)
        binding.clickHandler = handlers

        rvAdapter = MyAdapter(contactList)
        binding.rvContacts.adapter = rvAdapter

        contactDb = ContactDatabase.getInstance(this)

        viewModel = ViewModelProvider(this)[MyViewModel::class.java]

        //loading the data from viewmodel
        viewModel.getAllContacts().observe(this, Observer { contacts ->
            contactList.clear()
            for (c in contacts) {
                contactList.add(c)
            }
            rvAdapter.notifyDataSetChanged()
        })

        //swipe to delete

        ItemTouchHelper(object : ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT) {
            override fun onMove(
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder,
                target: RecyclerView.ViewHolder
            ): Boolean {
                return false
            }

            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                viewModel.deleteContact(contactList[viewHolder.adapterPosition])
            }

        }).attachToRecyclerView(binding.rvContacts)


    }
}