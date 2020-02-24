package com.go.arnite.ui.common.signin

interface SigninContract {

    interface LoginCallback {

        fun onLoginSuccess(message: String)

        fun onLoginFailure(message: String)

    }

    interface View {

        fun showLoginSuccess(message: String)

        fun showLoginFailure(message: String)

    }

    interface Presenter {

        fun doLogin(username: String, password: String)

    }

}