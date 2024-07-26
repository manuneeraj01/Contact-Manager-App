package com.example.contactsmanagerapp

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "contacts_table")
data class Contacts(
    @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "contact_id") val id: Int = 0,
    @ColumnInfo(name = "contact_name") var name: String = "",
    @ColumnInfo(name = "contact_email") var email: String = ""
)