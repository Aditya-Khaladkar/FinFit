package com.example.finfit.auth

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.finfit.databinding.ActivityLoginBinding
import com.example.finfit.util.FirebaseObj

class Login : AppCompatActivity() {
    lateinit var binding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.btnSignIn.setOnClickListener {
            val email: String = binding.logEmail.text.toString()
            val password: String = binding.logPassword.text.toString()

            if (email.isEmpty() && password.isEmpty()) {
                Toast.makeText(this, "Enter email and password", Toast.LENGTH_LONG).show()
            } else {
                FirebaseObj.auth.signInWithEmailAndPassword(email, password)
                    .addOnSuccessListener {
                        startActivity(Intent(this, Dashboard::class.java))
                        finish()
                    }.addOnFailureListener {
                        Toast.makeText(this, "Error", Toast.LENGTH_LONG).show()
                    }
            }
        }
    }
}