package com.example.contactsmanagerapp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.contactsmanagerapp.databinding.ContactListItemBinding

class MyAdapter(private val list: ArrayList<Contacts>) :
    RecyclerView.Adapter<MyAdapter.ContactsViewHolder>() {

    class ContactsViewHolder(private val binding: ContactListItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: Contacts) = with(binding) {
            contact = item
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactsViewHolder {
        return ContactsViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.contact_list_item,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: ContactsViewHolder, position: Int) {
        holder.bind(list[position])
    }
}