package com.example.localhomeservicebookingapp.ui.auth

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import androidx.appcompat.app.AppCompatActivity
import com.example.localhomeservicebookingapp.R
import com.example.localhomeservicebookingapp.ui.customer.CustomerHomeActivity
import com.example.localhomeservicebookingapp.ui.worker.WorkerHomeActivity

class RegisterActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        val roleGroup = findViewById<RadioGroup>(R.id.roleGroup)
        val btnRegister = findViewById<Button>(R.id.btnRegister)

        btnRegister.setOnClickListener {

            val selectedRoleId = roleGroup.checkedRadioButtonId

            if (selectedRoleId == -1) {
                // No role selected — later we show Snackbar
                return@setOnClickListener
            }

            val selectedRole = findViewById<RadioButton>(selectedRoleId)

            if (selectedRole.id == R.id.rbCustomer) {
                startActivity(
                    Intent(this, CustomerHomeActivity::class.java)
                )
            } else {
                startActivity(
                    Intent(this, WorkerHomeActivity::class.java)
                )
            }

            finish()
        }
    }
}
