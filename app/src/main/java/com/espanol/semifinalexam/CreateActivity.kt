package com.espanol.semifinalexam

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.espanol.semifinalexam.databinding.ActivityCreateBinding

class CreateActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCreateBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCreateBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnCreate.setOnClickListener {
            MainActivity.globalRetrofitBackend?.create(Request(binding.editTextCreateName.text.toString(), binding.editTextCreateDescription.text.toString()))
            Toast.makeText(this, "Posted", Toast.LENGTH_SHORT).show()
            finish()
        }

        binding.btnCreateBack.setOnClickListener { finish() }

    }
}