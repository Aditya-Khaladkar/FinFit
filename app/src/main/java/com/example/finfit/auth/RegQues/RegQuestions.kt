package com.example.finfit.auth.RegQues

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.finfit.R
import com.example.finfit.databinding.ActivityRegQuestionsBinding
import com.google.firebase.firestore.FirebaseFirestore

class RegQuestions : AppCompatActivity() {
    lateinit var binding: ActivityRegQuestionsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegQuestionsBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val db = FirebaseFirestore.getInstance()


    }
}