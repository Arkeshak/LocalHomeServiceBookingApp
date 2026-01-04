package com.example.localhomeservicebookingapp.ui.worker

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.localhomeservicebookingapp.R

class WorkerDashboardActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_worker_dashboard)

        val rvJobs = findViewById<RecyclerView>(R.id.rvJobs)

        rvJobs.layoutManager = LinearLayoutManager(this)
        // Adapter will be added later (UI first 👍)
    }
}
