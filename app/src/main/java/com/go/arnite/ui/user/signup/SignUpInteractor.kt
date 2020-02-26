package com.go.arnite.ui.user.signup

import com.go.arnite.models.User
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class SignUpInteractor(presenter: SignUpContract.Presenter) {

    var mPresenter: SignUpContract.Presenter = presenter
    var auth: FirebaseAuth
    var database: DatabaseReference

    init {
        auth = FirebaseAuth.getInstance()
        database = FirebaseDatabase.getInstance().reference
    }

    fun register(email: String, password: String, user: User, callback: SignUpContract.RegisterCallback){
        auth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(){
            if (it.isSuccessful){
                user.id = auth.uid.toString()
                database.child("users").child(auth.uid.toString()).setValue(user)
                callback.onRegisterSuccess("Berhasil register")
            } else {
                callback.onRegisterFailure("Gagal register")
            }
        }
    }

}