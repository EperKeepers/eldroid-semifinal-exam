package com.espanol.semifinalexam

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.espanol.semifinalexam.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var retrofitBackend: RetrofitBackend
    private lateinit var adapter: Adapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        adapter = Adapter(this)
        retrofitBackend = RetrofitBackend(adapter)
        binding.recyclerView.adapter = adapter

        globalRetrofitBackend = retrofitBackend

        retrofitBackend.display()

        binding.createButton.setOnClickListener {
            startActivity(Intent(this, CreateActivity::class.java))
        }

    }

    companion object {
        var globalRetrofitBackend: RetrofitBackend? = null
    }

}