package com.go.arnite.ui.common.splashscreen

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.Window
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import com.go.arnite.R
import com.go.arnite.ui.common.signin.SignInActivity

class SplashScreenActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        makeFullScreen()

        setContentView(R.layout.activity_splash_screen)


        // Using a handler to delay loading the MainUserActivity
        Handler().postDelayed({

            // Start activity
            startActivity(Intent(this, SignInActivity::class.java))

            // Animate the loading of new activity
            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)

            // Close this activity
            finish()

        }, 2000)
    }

    private fun makeFullScreen() {
        // Remove Title
        requestWindowFeature(Window.FEATURE_NO_TITLE)

        // Make Fullscreen
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )

        // Hide the toolbar
        supportActionBar?.hide()
    }
}
