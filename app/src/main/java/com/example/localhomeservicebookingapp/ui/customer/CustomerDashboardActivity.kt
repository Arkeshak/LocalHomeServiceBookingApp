package com.example.localhomeservicebookingapp.ui.customer

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.localhomeservicebookingapp.R
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.localhomeservicebookingapp.model.Service
import com.example.localhomeservicebookingapp.ui.customer.adapter.ServiceAdapter

class CustomerDashboardActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_customer_dashboard)
        val rvServices = findViewById<RecyclerView>(R.id.rvServices)

        rvServices.layoutManager = GridLayoutManager(this, 2)

        val services = listOf(
            Service("Plumbing", R.drawable.ic_service),
            Service("Electrician", R.drawable.ic_service),
            Service("Cleaning", R.drawable.ic_service),
            Service("Painting", R.drawable.ic_service)
        )

        rvServices.adapter = ServiceAdapter(services)

    }
}
