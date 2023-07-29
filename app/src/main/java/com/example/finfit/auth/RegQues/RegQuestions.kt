package com.example.finfit.auth.RegQues

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.RadioButton
import com.example.finfit.R
import com.example.finfit.databinding.ActivityRegQuestionsBinding
import com.example.finfit.util.FirebaseObj
import com.example.finfit.view.Dashboard
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore

class RegQuestions : AppCompatActivity() {
    lateinit var binding: ActivityRegQuestionsBinding
    var counter = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegQuestionsBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        val db = FirebaseFirestore.getInstance()

        db.collection("user_data").document(FirebaseObj.auth.currentUser?.uid.toString())


        binding.apply {

            // condition for radio button
            doYouEarnRadioGRP.setOnCheckedChangeListener { radioGroup, i ->
                when (i) {
                    R.id.doYouEarnRadioYES -> layoutHowMuchDoYouEarn.visibility = View.VISIBLE
                    R.id.doYouEarnRadioNO -> layoutHowMuchDoYouEarn.visibility = View.GONE
                }
            }

            btnSignUpNext.setOnClickListener {
                counter++

                when (counter) {
                    1 -> {
                        layoutDoYouEarn.visibility = View.GONE
                        layoutHowMuchDoYouEarn.visibility = View.GONE
                        layoutIsThereEMI.visibility = View.VISIBLE
                    }
                    2 -> {
                        startActivity(Intent(applicationContext, Dashboard::class.java))
                        finish()
                    }
                }
            }
        }
    }
}