package com.example.medapp

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.medapp.databinding.ActivityAddtaskBinding

class AddTaskActivity : AppCompatActivity(){
    private lateinit var binding: ActivityAddtaskBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_addtask)

        binding = ActivityAddtaskBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnConfirmAddTask.setOnClickListener{
            val message: String = binding.etTaskName.text.toString()
            Toast.makeText(this,message,Toast.LENGTH_SHORT).show()

            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra("AddedTask",message)
            setResult(Activity.RESULT_OK, intent)
            finish()
        }

    }
}