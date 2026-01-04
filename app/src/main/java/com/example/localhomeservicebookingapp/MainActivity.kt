package com.example.localhomeservicebookingapp

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import com.example.localhomeservicebookingapp.ui.auth.LoginActivity // ✅ Ensure this import is present

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            Button(onClick = {
                // The reference here should now be resolved correctly
                startActivity(Intent(this, LoginActivity::class.java))
            }) {
                Text("Go to Login")
            }
        }
    }
}
