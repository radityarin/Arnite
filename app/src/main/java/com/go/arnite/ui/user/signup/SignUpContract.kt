package com.go.arnite.ui.common.signin

import com.go.arnite.models.User

interface SignUpContract {

    interface RegisterCallback {

        fun onRegisterSuccess(message: String)

        fun onRegisterFailure(message: String)

    }

    interface View {

        fun registerSuccess(message: String)

        fun registerFailure(message: String)

    }

    interface Presenter {

        fun doSignUp(email: String, password: String, user: User)

    }

}