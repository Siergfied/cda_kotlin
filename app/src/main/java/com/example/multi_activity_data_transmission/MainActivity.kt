package com.example.multi_activity_data_transmission

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val name = findViewById<EditText>(R.id.input_name)
        val occupation = findViewById<EditText>(R.id.input_occupation)
        val company = findViewById<EditText>(R.id.input_company)

        val button = findViewById<Button>(R.id.start_second_activity)
        button.setOnClickListener{
            val intent = Intent(this, SecondActivity::class.java)
            intent.putExtra("name", name.getText().toString())
            intent.putExtra("occupation", occupation.getText().toString())
            intent.putExtra("company", company.getText().toString())
            startActivity(intent)
        }
    }
}
