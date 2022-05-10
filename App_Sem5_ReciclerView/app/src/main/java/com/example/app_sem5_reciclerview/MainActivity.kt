package com.example.app_sem5_reciclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.util.ArrayList

class MainActivity : AppCompatActivity() {
    var contacts = ArrayList<Contact>()
    var contactAdapter = ContactAdapter(contacts)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        loadContacts()
        initView()
    }

    private fun initView() {
        val rvContact = findViewById<RecyclerView>(R.id.rvContact)

        rvContact.adapter = contactAdapter
        rvContact.layoutManager = LinearLayoutManager(this)
    }

    private fun loadContacts() {
        contacts.add(Contact("Jorge", "123456789"))
        contacts.add(Contact("Joselo", "159874653"))
        contacts.add(Contact("Joel", "125753489"))
        contacts.add(Contact("Jorge", "123456789"))
        contacts.add(Contact("Joselo", "159874653"))
        contacts.add(Contact("Joel", "125753489"))
        contacts.add(Contact("Jorge", "123456789"))
        contacts.add(Contact("Joselo", "159874653"))
        contacts.add(Contact("Joel", "125753489"))
        contacts.add(Contact("Jorge", "123456789"))
        contacts.add(Contact("Joselo", "159874653"))
        contacts.add(Contact("Joel", "125753489"))
        contacts.add(Contact("Jorge", "123456789"))
        contacts.add(Contact("Joselo", "159874653"))
        contacts.add(Contact("Joel", "125753489"))
        contacts.add(Contact("Jorge", "123456789"))
        contacts.add(Contact("Joselo", "159874653"))
        contacts.add(Contact("Joel", "125753489"))
        contacts.add(Contact("Jorge", "123456789"))
        contacts.add(Contact("Joselo", "159874653"))
        contacts.add(Contact("Joel", "125753489"))
        contacts.add(Contact("Jorge", "123456789"))
        contacts.add(Contact("Joselo", "159874653"))
        contacts.add(Contact("Joel", "125753489"))
        contacts.add(Contact("Jorge", "123456789"))
        contacts.add(Contact("Joselo", "159874653"))
        contacts.add(Contact("Joel", "125753489"))
    }
}