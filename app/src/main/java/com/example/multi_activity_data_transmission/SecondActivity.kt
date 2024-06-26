package com.example.multi_activity_data_transmission

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_second)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val name = findViewById<TextView>(R.id.name)
        name.text = intent.getStringExtra("name")

        val occupation = findViewById<TextView>(R.id.occupation)
        occupation.text = intent.getStringExtra("occupation")

        val company = findViewById<TextView>(R.id.company)
        company.text = intent.getStringExtra("company")


        val button = findViewById<Button>(R.id.start_third_activity)
        button.setOnClickListener {
            val intent = Intent(this, ThirdActivity::class.java)
            intent.putExtra("name", name.text)
            intent.putExtra("occupation", occupation.text)
            intent.putExtra("company", company.text)
            startActivity(intent)
        }
    }
}
