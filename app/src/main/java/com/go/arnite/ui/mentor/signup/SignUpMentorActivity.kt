package com.go.arnite.ui.mentor.signup

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.go.arnite.R
import com.go.arnite.models.Mentor
import kotlinx.android.synthetic.main.activity_sign_up_mentor.*

class SignUpMentorActivity : AppCompatActivity(), SignupMentorContract.View {

    lateinit var mPresenter: SignupMentorContract.Presenter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up_mentor)

        mPresenter = SignupMentorPresenter(this)

        btnSignup.setOnClickListener {

            val email = etEmail.text.toString()
            val password = etPassword.text.toString()

            mPresenter.doSignup(Mentor(email = email), email, password)

        }
    }

    override fun showSignupSuccess(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    override fun showSignupFailure(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}
