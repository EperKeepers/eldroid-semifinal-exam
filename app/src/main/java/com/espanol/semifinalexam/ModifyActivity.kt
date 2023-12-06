package com.espanol.semifinalexam

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.espanol.semifinalexam.databinding.ActivityModifyBinding

class ModifyActivity : AppCompatActivity() {

    private lateinit var binding: ActivityModifyBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityModifyBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.editTextUpdateUniqueId.setText(intent.getStringExtra("edit_id"))
        binding.editTextUpdateName.setText(intent.getStringExtra("edit_name"))
        binding.editTextUpdateDescription.setText(intent.getStringExtra("edit_description"))

        binding.btnUpdate.setOnClickListener {
            MainActivity.globalRetrofitBackend?.modify(intent.getStringExtra("edit_id").toString(), Request(binding.editTextUpdateName.text.toString(), binding.editTextUpdateDescription.text.toString()))
            Toast.makeText(this, "Updated", Toast.LENGTH_SHORT).show()
            finish()
        }

        binding.btnUpdateBack.setOnClickListener { finish() }

    }
}