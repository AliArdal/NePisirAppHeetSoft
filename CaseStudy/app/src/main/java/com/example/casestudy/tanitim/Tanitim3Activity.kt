package com.example.casestudy.tanitim

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.casestudy.R
import com.example.casestudy.databinding.ActivityTanitim3Binding

class Tanitim3Activity : AppCompatActivity() {

    private lateinit var binding : ActivityTanitim3Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTanitim3Binding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.devamEt.setOnClickListener {

            val intent = Intent(this,Tanitim4Activity::class.java)
            startActivity(intent)
        }

        binding.geri.setOnClickListener {

            val intent = Intent(this,Tanitim2Activity::class.java)
            startActivity(intent)
        }
    }
}