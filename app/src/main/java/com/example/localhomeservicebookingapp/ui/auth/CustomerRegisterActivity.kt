package com.example.localhomeservicebookingapp.ui.auth

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.localhomeservicebookingapp.R
import com.example.localhomeservicebookingapp.ui.customer.CustomerHomeActivity

class CustomerRegisterActivity : AppCompatActivity() {

    private lateinit var etName: EditText
    private lateinit var etEmail: EditText
    private lateinit var etPassword: EditText
    private lateinit var btnRegister: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_customer_register)

        // Initialize views
        etName = findViewById(R.id.etName)
        etEmail = findViewById(R.id.etEmail)
        etPassword = findViewById(R.id.etPassword)
        btnRegister = findViewById(R.id.btnRegister)

        btnRegister.setOnClickListener {
            handleRegister()
        }
    }

    private fun handleRegister() {
        val name = etName.text.toString().trim()
        val email = etEmail.text.toString().trim()
        val password = etPassword.text.toString().trim()

        // Basic validation
        if (name.isEmpty()) {
            etName.error = "Name required"
            return
        }

        if (email.isEmpty()) {
            etEmail.error = "Email required"
            return
        }

        if (password.isEmpty()) {
            etPassword.error = "Password required"
            return
        }

        if (password.length < 6) {
            etPassword.error = "Password must be at least 6 characters"
            return
        }

        // TEMP success message (Firebase later)
        Toast.makeText(
            this,
            "Customer registered successfully",
            Toast.LENGTH_SHORT
        ).show()

        // Navigate to Customer Home
        startActivity(
            Intent(this, CustomerHomeActivity::class.java)
        )

        finish()
    }
}
