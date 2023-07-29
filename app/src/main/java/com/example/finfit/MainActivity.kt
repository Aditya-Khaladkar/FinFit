package com.example.finfit

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.example.finfit.auth.Login
import com.example.finfit.auth.RegQues.RegQuestions
import com.example.finfit.util.FirebaseObj
import com.example.finfit.view.Dashboard

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Handler().postDelayed(Runnable {
            if (FirebaseObj.auth.currentUser != null) {
                startActivity(Intent(this, RegQuestions::class.java))
                finish()
            } else {
                startActivity(Intent(this, Login::class.java))
                finish()
            }
        }, 2000)
    }
}