package com.example.localhomeservicebookingapp.ui.auth

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.example.localhomeservicebookingapp.R

class WorkerRegisterActivity : AppCompatActivity() {

    private lateinit var serviceContainer: LinearLayout
    private lateinit var btnAddService: Button
    private lateinit var btnUploadDoc: Button
    private lateinit var btnRegister: Button
    private lateinit var tvFileName: TextView

    private var selectedFileUri: Uri? = null

    companion object {
        private const val FILE_PICK_CODE = 101
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_worker_register)

        // ---------- BASIC INPUTS ----------
        val etName = findViewById<EditText>(R.id.etName)
        val etEmail = findViewById<EditText>(R.id.etEmail)
        val etPassword = findViewById<EditText>(R.id.etPassword)
        val etPhone = findViewById<EditText>(R.id.etPhone)
        val etCity = findViewById<EditText>(R.id.etCity)
        val etArea = findViewById<EditText>(R.id.etArea)

        // ---------- SERVICES ----------
        serviceContainer = findViewById(R.id.serviceContainer)
        btnAddService = findViewById(R.id.btnAddService)

        // ---------- FILE UPLOAD ----------
        btnUploadDoc = findViewById(R.id.btnUploadDoc)
        tvFileName = findViewById(R.id.tvFileName)

        // ---------- REGISTER ----------
        btnRegister = findViewById(R.id.btnRegisterWorker)

        // Add first service field by default
        addServiceField()

        // Add more service fields dynamically
        btnAddService.setOnClickListener {
            addServiceField()
        }

        // Upload document
        btnUploadDoc.setOnClickListener {
            openFilePicker()
        }

        // Register button
        btnRegister.setOnClickListener {

            val name = etName.text.toString().trim()
            val email = etEmail.text.toString().trim()
            val password = etPassword.text.toString().trim()
            val phone = etPhone.text.toString().trim()
            val city = etCity.text.toString().trim()
            val area = etArea.text.toString().trim()

            if (name.isEmpty() || email.isEmpty() || password.isEmpty()
                || phone.isEmpty() || city.isEmpty() || area.isEmpty()
            ) {
                Toast.makeText(this, "Please fill all details", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val services = getAllServices()

            if (services.isEmpty()) {
                Toast.makeText(this, "Please add at least one service", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if (selectedFileUri == null) {
                Toast.makeText(this, "Please upload certificate or proof", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // ✅ FOR NOW: Just confirmation
            Toast.makeText(
                this,
                "Worker Registered Successfully\nServices: ${services.joinToString()}",
                Toast.LENGTH_LONG
            ).show()

            // Later → Firebase + Admin approval + Dashboard
        }
    }

    // ---------------- ADD SERVICE FIELD ----------------
    private fun addServiceField() {
        val serviceInput = EditText(this)
        serviceInput.hint = "Service Name"
        serviceInput.layoutParams = LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.MATCH_PARENT,
            LinearLayout.LayoutParams.WRAP_CONTENT
        )
        serviceContainer.addView(serviceInput)
    }

    // ---------------- GET ALL SERVICES ----------------
    private fun getAllServices(): List<String> {
        val services = mutableListOf<String>()

        for (i in 0 until serviceContainer.childCount) {
            val view = serviceContainer.getChildAt(i)
            if (view is EditText) {
                val service = view.text.toString().trim()
                if (service.isNotEmpty()) {
                    services.add(service)
                }
            }
        }
        return services
    }

    // ---------------- FILE PICKER ----------------
    private fun openFilePicker() {
        val intent = Intent(Intent.ACTION_GET_CONTENT)
        intent.type = "*/*"
        startActivityForResult(intent, FILE_PICK_CODE)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == FILE_PICK_CODE && resultCode == Activity.RESULT_OK) {
            selectedFileUri = data?.data
            tvFileName.text = selectedFileUri?.lastPathSegment ?: "File selected"
        }
    }
}
