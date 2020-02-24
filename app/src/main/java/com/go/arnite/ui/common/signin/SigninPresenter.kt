package com.go.arnite.ui.common.signin

class SigninPresenter : SigninContract.Presenter {

    var mView: SigninContract.View
    var mInteractor: SigninInteractor

    constructor(view: SigninContract.View){
        mView = view
        mInteractor = SigninInteractor(this)
    }

    override fun doLogin(username: String, password: String) {
        mInteractor.login(username, password, object: SigninContract.LoginCallback {
            override fun onLoginSuccess(message: String) {
                mView.showLoginSuccess(message)
            }

            override fun onLoginFailure(message: String) {
                mView.showLoginFailure(message)
            }
        })
    }

}