package com.go.arnite.ui.common.signin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.go.arnite.R

class SignInActivity : AppCompatActivity(), SigninContract.View {

    lateinit var mPresenter: SigninContract.Presenter
    lateinit var etUsername: EditText
    lateinit var etPassword: EditText
    lateinit var btnSignin: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)

        etUsername = findViewById(R.id.etUsername)
        etPassword = findViewById(R.id.etPassword)

        mPresenter = SigninPresenter(this);
        btnSignin.setOnClickListener {

            mPresenter.doLogin(etUsername.text.toString(), etPassword.text.toString())

        }
    }

    override fun showLoginSuccess(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    override fun showLoginFailure(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

}