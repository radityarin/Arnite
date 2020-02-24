package com.go.arnite.ui.common.signin

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.go.arnite.R
import com.go.arnite.ui.mentor.signup.SignUpMentorActivity
import com.go.arnite.ui.user.signup.SignUpUserActivity
import kotlinx.android.synthetic.main.activity_sign_in.*

class SignInActivity : AppCompatActivity(), SigninContract.View {

    lateinit var mPresenter: SigninContract.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)

        mPresenter = SigninPresenter(this)
        btnSignin.setOnClickListener {

            mPresenter.doLogin(etEmail.text.toString(), etPassword.text.toString())

        }

        btnSignupUser.setOnClickListener{

            startActivity(Intent(this, SignUpUserActivity::class.java))

        }

        btnSignupMentor.setOnClickListener {

            startActivity(Intent(this, SignUpMentorActivity::class.java))

        }
    }

    override fun showLoginSuccess(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    override fun showLoginFailure(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

}