package com.go.arnite.ui.mentor.signup

import com.go.arnite.models.Mentor

interface SignupMentorContract {

    interface SignupCallback {

        fun onSignupSuccess(message: String)

        fun onSignupFailure(message: String)

    }

    interface View {

        fun showSignupSuccess(message: String)

        fun showSignupFailure(message: String)

    }

    interface Presenter {

        fun doSignup(
            mentor: Mentor,
            username: String,
            password: String
        )

    }

    interface Interactor {

        fun signup(
            mentor: Mentor,
            email: String,
            password: String,
            callback: SignupCallback
        )

    }

}