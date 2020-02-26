package com.go.arnite.ui.common.signin

import com.google.firebase.auth.FirebaseAuth

class SigninInteractor {

    var mPresenter: SigninContract.Presenter
    var auth: FirebaseAuth

    constructor(presenter: SigninContract.Presenter){
        mPresenter = presenter
        auth = FirebaseAuth.getInstance()
    }

    fun login(username: String, password: String, callback: SigninContract.LoginCallback){
        auth.signInWithEmailAndPassword(username, password)
            .addOnCompleteListener{
                if (it.isSuccessful){
                    callback.onLoginSuccess("Berhasil login")
                } else {
                    callback.onLoginFailure("Gagal login")
                }
            }
    }

    fun isLogin(): Boolean {
        return auth.currentUser != null
    }

}