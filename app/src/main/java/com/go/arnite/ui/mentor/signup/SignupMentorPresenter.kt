package com.go.arnite.ui.mentor.signup

import com.go.arnite.models.Mentor

class SignupMentorPresenter : SignupMentorContract.Presenter {

    var mView: SignupMentorContract.View
    var mInteractor: SignupMentorInteractor

    constructor(view: SignupMentorContract.View){
        mView = view
        mInteractor = SignupMentorInteractor()
    }

    override fun doSignup(
        mentor: Mentor,
        email: String,
        password: String
    ) {
        mInteractor.signup(mentor, email, password, object: SignupMentorContract.SignupCallback {
            override fun onSignupSuccess(message: String) {
                mView.showSignupSuccess(message)
            }

            override fun onSignupFailure(message: String) {
                mView.showSignupFailure(message)
            }

        })
    }
}