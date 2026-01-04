package com.example.localhomeservicebookingapp

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class BookingDetailsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_booking_details)

        val tvService = findViewById<TextView>(R.id.tvService)
        val tvDate = findViewById<TextView>(R.id.tvDate)
        val tvLocation = findViewById<TextView>(R.id.tvLocation)
        val tvStatus = findViewById<TextView>(R.id.tvStatus)

        tvService.text = intent.getStringExtra("service")
        tvDate.text = intent.getStringExtra("date")
        tvLocation.text = intent.getStringExtra("location")
        tvStatus.text = intent.getStringExtra("status")
    }
}
