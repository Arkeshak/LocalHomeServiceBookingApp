package com.example.localhomeservicebookingapp.ui.customer

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.localhomeservicebookingapp.R
import com.example.localhomeservicebookingapp.ui.customer.adapter.BookingAdapter
import com.example.localhomeservicebookingapp.ui.customer.model.Booking

class CustomerBookingsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_customer_bookings)

        val recyclerView = findViewById<RecyclerView>(R.id.rvBookings)
        recyclerView.layoutManager = LinearLayoutManager(this)



        val dummyBookings = listOf(
            Booking(
                "Plumbing Service",
                "12 June 2026 • 10:30 AM",
                "Mumbai, Andheri East",
                "Pending"
            ),
            Booking(
                "Electrician Service",
                "10 June 2026 • 02:00 PM",
                "Mumbai, Bandra",
                "Completed"
            ),
            Booking(
                "AC Repair",
                "08 June 2026 • 11:00 AM",
                "Mumbai, Powai",
                "Cancelled"
            )

        )
        val adapter = BookingAdapter(this, dummyBookings)
        recyclerView.adapter = adapter

        recyclerView.adapter = BookingAdapter(this, dummyBookings)
    }
}
