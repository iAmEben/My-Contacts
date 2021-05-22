package com.iameben.mycontacts

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class CategoryActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_category)
    }
// The following functions send intents from the cardView of the activity
    fun allContacts(view: View) {
        val intent = Intent(this, AllContactActivity::class.java)
        startActivity(intent)

    }

    fun favourites(view: View) {
        val intent = Intent(this, FavouriteContactActivity::class.java)
        startActivity(intent)
    }

    fun family(view: View) {
        val intent = Intent(this, FamilyContactActivity::class.java)
        startActivity(intent)
    }

    fun friends(view: View) {
        val intent = Intent(this, FriendsContactActivity::class.java)
        startActivity(intent)
    }
}