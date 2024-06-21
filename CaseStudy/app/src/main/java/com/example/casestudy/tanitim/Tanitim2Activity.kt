package com.example.casestudy.tanitim

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.casestudy.R
import com.example.casestudy.databinding.ActivityTanitim2Binding

class Tanitim2Activity : AppCompatActivity() {

    private lateinit var binding : ActivityTanitim2Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTanitim2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.devamEt.setOnClickListener {

            val intent = Intent(this,Tanitim3Activity::class.java)
            startActivity(intent)
        }

        binding.geri.setOnClickListener {

            val intent = Intent(this,Tanitim1Activity::class.java)
            startActivity(intent)
        }
    }
}