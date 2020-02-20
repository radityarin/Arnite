package com.go.arnite.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.go.arnite.R
import com.go.arnite.data.models.User
import com.google.firebase.FirebaseApp
import com.google.firebase.database.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        FirebaseApp.initializeApp(this)

        FirebaseDatabase.getInstance()
            .getReference("users")
            .addValueEventListener(object : ValueEventListener {
                override fun onDataChange(dataSnapshot: DataSnapshot) {

                    var list: ArrayList<User> = ArrayList()

                    for (snapshot in dataSnapshot.children) {
                        val item = snapshot.getValue(User::class.java)!!
                        list.add(item)
                        Log.d("MYAPP", "email: " + item.email)
                    }

                }

                override fun onCancelled(databaseError: DatabaseError) {
                    // Getting Post failed, log a message
                    Log.w("MYAPP", "loadPost:onCancelled", databaseError.toException())
                    // ...
                }
            })
    }
}
