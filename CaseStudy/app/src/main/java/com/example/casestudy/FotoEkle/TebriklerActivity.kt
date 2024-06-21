package com.example.casestudy.FotoEkle

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.casestudy.MainActivity
import com.example.casestudy.databinding.ActivityTebriklerActivityBinding

class TebriklerActivity : AppCompatActivity() {

    private lateinit var binding : ActivityTebriklerActivityBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityTebriklerActivityBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.kapat.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}