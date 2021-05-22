package com.iameben.mycontacts

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.iameben.mycontacts.databinding.ActivityFavouriteContactBinding

class FavouriteContactActivity : AppCompatActivity() {
    private lateinit var binding: ActivityFavouriteContactBinding
    private val adapter = ContactAdapter()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_favourite_contact)
        binding = ActivityFavouriteContactBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setUpData(binding)
    }

    private fun setUpData(binding: ActivityFavouriteContactBinding) {
        binding.contactsRV.adapter = adapter
        val builder = AlertDialog.Builder(this)
        this.layoutInflater
        val view = layoutInflater.inflate(R.layout.add_contact_dialog, null)
        builder.setView(view)

        val name = view.findViewById<TextView>(R.id.nameEt)
        val no = view.findViewById<TextView>(R.id.numberEt)
        val saveBtn = view.findViewById<TextView>(R.id.saveBt)

        no.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                saveBtn.isEnabled = p0?.length == 11
            }

            override fun afterTextChanged(p0: Editable?) {

            }
        })

        val alertDialog = builder.create()
        saveBtn.setOnClickListener {
            val contact = Contact(name.text.toString(), no.text.toString())
            val contacts = mutableListOf(contact)
            adapter.setUpContacts(contacts)
            alertDialog.dismiss()

        }

        binding.fab.setOnClickListener {
            alertDialog.show();
        }


    }
}