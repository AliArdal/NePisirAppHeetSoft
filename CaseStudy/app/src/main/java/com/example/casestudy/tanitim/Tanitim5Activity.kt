package com.example.casestudy.tanitim

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.casestudy.databinding.ActivityTanitim5Binding

class Tanitim5Activity : AppCompatActivity() {

    private lateinit var binding : ActivityTanitim5Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTanitim5Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.geri.setOnClickListener {

            val intent = Intent(this,Tanitim4Activity::class.java)
            startActivity(intent)
        }

        binding.uyeOl.setOnClickListener {

            val intent = Intent(this, UyeOlActivity::class.java)
            startActivity(intent)
        }
        binding.girisYap.setOnClickListener {

            val intent = Intent(this, GirisActivity::class.java)
            startActivity(intent)
        }
    }


}