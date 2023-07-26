package com.example.finfit.auth.RegQues

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.RadioButton
import com.example.finfit.R
import com.example.finfit.databinding.ActivityRegQuestionsBinding
import com.example.finfit.util.FirebaseObj
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore

class RegQuestions : AppCompatActivity() {
    lateinit var binding: ActivityRegQuestionsBinding
    var counter = 0
    lateinit var radioButton: RadioButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegQuestionsBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        val db = FirebaseFirestore.getInstance()

        db.collection("user_data").document(FirebaseObj.auth.currentUser?.uid.toString())


        binding.apply {

            // condition for radio button
            val intSelectButton: Int = doYouEarnRadioGRP.checkedRadioButtonId

            radioButton = findViewById(intSelectButton)

            if (radioButton.text.equals("YES")) {
                layoutHowMuchDoYouEarn.visibility = View.VISIBLE
            }

            btnSignUpNext.setOnClickListener {
                counter++

                if (counter == 1) {
                    layoutDoYouEarn.visibility = View.GONE
                    layoutHowMuchDoYouEarn.visibility = View.GONE
                }
            }
        }
    }
}