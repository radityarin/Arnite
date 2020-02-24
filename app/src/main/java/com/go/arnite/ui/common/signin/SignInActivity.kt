package com.go.arnite.ui.common.signin

import android.app.ProgressDialog
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.go.arnite.R
import com.go.arnite.ui.common.forgotpassword.ForgotPasswordActivity
import com.go.arnite.ui.mentor.signup.SignUpMentorActivity
import com.go.arnite.ui.user.main.MainUserActivity
import com.go.arnite.ui.user.signup.SignUpUserActivity
import kotlinx.android.synthetic.main.activity_sign_in.*

class SignInActivity : AppCompatActivity(), SigninContract.View, View.OnClickListener {

    lateinit var mPresenter: SigninContract.Presenter
    private var progressDialog : ProgressDialog?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)

        mPresenter = SigninPresenter(this)
        btnSignin.setOnClickListener(this)
        btnSignupUser.setOnClickListener(this)
        btnSignupMentor.setOnClickListener (this)
        tvForgotPassword.setOnClickListener(this)
    }

    private fun doLogin() {
        progressDialog = ProgressDialog(this)
        progressDialog?.setMessage("Loading...")
        progressDialog?.setCancelable(true)
        progressDialog?.show()
        val email = etEmail.text.toString()
        val password = etPassword.text.toString()
        mPresenter.doLogin(email, password)
    }

    override fun onClick(v: View?) {
        when(v?.id){
            btnSignin.id -> doLogin()
            btnSignupUser.id -> startActivity(Intent(this, SignUpUserActivity::class.java))
            btnSignupMentor.id -> startActivity(Intent(this, SignUpMentorActivity::class.java))
            tvForgotPassword.id -> startActivity(Intent(this, ForgotPasswordActivity::class.java))
        }
    }

    override fun showLoginSuccess(message: String) {
        progressDialog?.dismiss()
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
        startActivity(Intent(this, MainUserActivity::class.java))
    }

    override fun showLoginFailure(message: String) {
        progressDialog?.dismiss()
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

}