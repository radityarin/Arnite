package com.go.arnite.ui.common.signin

import com.go.arnite.models.User

class SignUpPresenter : SignUpContract.Presenter {

    var mView: SignUpContract.View
    var mInteractor: SignUpInteractor

    constructor(view: SignUpContract.View) {
        mView = view
        mInteractor = SignUpInteractor(this)
    }

    override fun doSignUp(email: String, password: String, user: User) {
        mInteractor.register(email,password, user, object : SignUpContract.RegisterCallback {
            override fun onRegisterSuccess(message: String) {
                mView.registerSuccess(message)
            }

            override fun onRegisterFailure(message: String) {
                mView.registerFailure(message)
            }
        })
    }

}