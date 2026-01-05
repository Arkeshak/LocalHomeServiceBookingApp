package com.example.localhomeservicebookingapp.ui.auth

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.localhomeservicebookingapp.R

class RegisterSelectionActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register_selection)

        findViewById<Button>(R.id.btnCustomer).setOnClickListener {
            startActivity(Intent(this, CustomerRegisterActivity::class.java))
        }

        findViewById<Button>(R.id.btnWorker).setOnClickListener {
            startActivity(Intent(this, WorkerRegisterActivity::class.java))
        }
    }
}
