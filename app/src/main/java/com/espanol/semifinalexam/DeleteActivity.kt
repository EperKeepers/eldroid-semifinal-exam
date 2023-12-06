package com.espanol.semifinalexam

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.espanol.semifinalexam.databinding.ActivityDeleteBinding

class DeleteActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDeleteBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDeleteBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.editTextDeleteUniqueId.setText(intent.getStringExtra("delete_id"))

        binding.btnDelete.setOnClickListener {
            MainActivity.globalRetrofitBackend?.delete(intent.getStringExtra("delete_id").toString())
            Toast.makeText(this, "Deleted", Toast.LENGTH_SHORT).show()
            finish()
        }

        binding.btnDeleteBack.setOnClickListener { finish() }

    }
}