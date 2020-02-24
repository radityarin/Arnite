package com.go.arnite.ui.mentor.signup

import com.go.arnite.models.Mentor
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class SignupMentorInteractor: SignupMentorContract.Interactor {

    var auth: FirebaseAuth
    var usersReference: DatabaseReference

    init {
        auth = FirebaseAuth.getInstance()
        usersReference = FirebaseDatabase.getInstance().getReference("mentors")
    }


    override fun signup(
        mentor: Mentor,
        email: String,
        password: String,
        callback: SignupMentorContract.SignupCallback
    ) {

        auth.createUserWithEmailAndPassword(email, password).addOnCompleteListener {
            if (it.isSuccessful) {
                val id: String = auth.currentUser?.uid.toString()
                mentor.id = id

                usersReference.child(id).setValue(mentor).addOnCompleteListener {
                    if (it.isSuccessful) {
                        callback.onSignupSuccess("Berhasil register")
                    } else {
                        callback.onSignupFailure("Gagal register")
                    }
                }
            } else {
                callback.onSignupFailure("Gagal register")
            }
        }

    }

}