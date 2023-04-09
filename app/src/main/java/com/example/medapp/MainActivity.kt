package com.example.medapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.example.medapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnAddTask.setOnClickListener{
            Toast.makeText(this, "Task added !",Toast.LENGTH_SHORT).show()

           val intent = Intent(this, AddTaskActivity ::class.java)
            startActivity(intent)
        }
    }
} 