package com.example.medapp

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.CheckBox
import android.widget.LinearLayout
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import com.example.medapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var checkboxContainer: LinearLayout
    private val addTaskLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
        if (result.resultCode == Activity.RESULT_OK) {
            val intent = result.data
            val bundle: Bundle? = intent?.extras
            val msg = bundle?.getString("AddedTask")
            Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
            binding.tvTaskName.text = msg

            // Step 3: Dynamically create and add CheckBox elements
            val checkBox = CheckBox(this)
            checkBox.text = msg
            checkBox.layoutParams = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            )
            checkboxContainer.addView(checkBox)
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_main)

        checkboxContainer = findViewById(R.id.checkboxContainer)

        setContentView(binding.root)



        binding.btnAddTask.setOnClickListener{
            Toast.makeText(this, "Task added !",Toast.LENGTH_SHORT).show()

           val intent = Intent(this, AddTaskActivity ::class.java)


            addTaskLauncher.launch(intent)

        }
    }
}