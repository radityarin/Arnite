package com.go.arnite.ui.user.signup

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.go.arnite.R
import com.go.arnite.models.User
import com.go.arnite.ui.common.signin.SignUpContract
import com.go.arnite.ui.common.signin.SignUpPresenter
import com.go.arnite.ui.common.signin.SigninPresenter
import com.go.arnite.ui.user.main.MainUserActivity
import kotlinx.android.synthetic.main.activity_sign_up_user.*

class SignUpUserActivity : AppCompatActivity(),SignUpContract.View, View.OnClickListener {

    lateinit var mPresenter: SignUpContract.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up_user)

        mPresenter = SignUpPresenter(this)

        btnSignUp.setOnClickListener(this)

    }

    override fun onClick(v: View?) {
        when (v?.id){
            btnSignUp.id -> signUp()
        }
    }

    private fun signUp() {
        val email: String = etEmail.text.toString()
        val name: String = etUsername.text.toString()
        val password: String = etPassword.text.toString()
        val phoneNumber: String = etPhoneNumber.text.toString()
        val user = User("", email, name, phoneNumber)

        mPresenter.doSignUp(email, password, user)
    }

    override fun registerSuccess(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
        startActivity(Intent(this,MainUserActivity::class.java))
    }

    override fun registerFailure(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

}
