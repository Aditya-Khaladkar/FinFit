package com.example.finfit.auth

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import com.example.finfit.R
import com.example.finfit.auth.RegQues.RegQuestions
import com.example.finfit.databinding.ActivityRegisterBinding
import com.example.finfit.util.FirebaseObj
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore

class Register : AppCompatActivity() {
    lateinit var binding: ActivityRegisterBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val db = FirebaseFirestore.getInstance()

        binding.btnSignUp.setOnClickListener {

            val firstname: String = binding.regUsername.text.toString()
            val lastname: String = binding.regLastname.text.toString()
            val DOB: String = binding.regDOB.text.toString()
            val email: String = binding.regEmail.text.toString()
            val password: String = binding.regPassword.text.toString()

            val userData = HashMap<String, Any>()
            userData["firstname"] = firstname
            userData["lastname"] = lastname
            userData["DOB"] = DOB
            userData["email"] = email
            userData["password"] = password

            FirebaseObj.auth.createUserWithEmailAndPassword(email, password)
                .addOnSuccessListener {
                    // storing user details to firebase cloud
                    db.collection("user_data").document(FirebaseObj.auth.currentUser?.uid.toString())
                        .set(userData)
                        .addOnSuccessListener {
                            startActivity(Intent(this, RegQuestions::class.java))
                            finish()
                        }
                        .addOnFailureListener {
                            Toast.makeText(this, "There was some error while uploading user data", Toast.LENGTH_LONG).show()
                        }
                }
                .addOnFailureListener {
                    Toast.makeText(this, "There was some error while registering user", Toast.LENGTH_LONG).show()
                }
        }
    }
}