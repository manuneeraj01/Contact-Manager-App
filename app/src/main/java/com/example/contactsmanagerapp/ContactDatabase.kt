package com.example.contactsmanagerapp

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Contacts::class], version = 1)
abstract class ContactDatabase : RoomDatabase() {

    abstract fun getContactDao(): ContactDAO

    // Singleton Pattern
    companion object {
        private var INSTANCE: ContactDatabase? = null

        fun getInstance(context: Context): ContactDatabase = INSTANCE ?: synchronized(this) {
            val instance = Room.databaseBuilder(
                context, ContactDatabase::class.java, "contact_db"
            ).fallbackToDestructiveMigration().build()
            INSTANCE = instance
            instance
        }
    }
}