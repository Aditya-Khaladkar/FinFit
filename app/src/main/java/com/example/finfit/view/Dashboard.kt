package com.example.finfit.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.finfit.R
import com.example.finfit.adapter.carousel.ImageAdapter
import com.example.finfit.databinding.ActivityDashboardBinding

class Dashboard : AppCompatActivity() {
    lateinit var binding: ActivityDashboardBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        val imageList = ArrayList<Int>()

        imageList += R.drawable.login
        imageList += R.drawable.currencyrupee48px
        imageList += R.drawable.sports_esports48px
        imageList += R.drawable.person48px
        imageList += R.drawable.local_library48px
        imageList += R.drawable.home

        // on below line we are initializing our view
        // pager adapter and adding image list to it.
        val viewPagerAdapter = ImageAdapter(this, imageList)

        // on below line we are setting
        // adapter to our view pager.
        binding.imageSlider.adapter = viewPagerAdapter
        binding.dot1.setViewPager(binding.imageSlider)
    }
}