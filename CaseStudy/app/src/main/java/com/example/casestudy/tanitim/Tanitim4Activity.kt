package com.example.casestudy.tanitim

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.casestudy.databinding.ActivityTanitim4Binding

class Tanitim4Activity : AppCompatActivity() {

    private lateinit var binding : ActivityTanitim4Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTanitim4Binding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.devamEt.setOnClickListener {

            val intent = Intent(this,Tanitim5Activity::class.java)
            startActivity(intent)
        }
        binding.geri.setOnClickListener {

            val intent = Intent(this,Tanitim3Activity::class.java)
            startActivity(intent)
        }
    }
}