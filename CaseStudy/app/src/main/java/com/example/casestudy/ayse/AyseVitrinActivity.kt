package com.example.casestudy.ayse

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.casestudy.MainActivity
import com.example.casestudy.ProfilimActivity
import com.example.casestudy.TakipciActivity
import com.example.casestudy.databinding.ActivityAyseVitrinBinding

class AyseVitrinActivity : AppCompatActivity() {

    private lateinit var binding : ActivityAyseVitrinBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAyseVitrinBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.Profil.setOnClickListener {
            val intent = Intent(this, ProfilimActivity::class.java)
            startActivity(intent)
            finish()
        }
        binding.textView49.setOnClickListener {
            val intent = Intent(this, AyseTakipciActivity::class.java)
            startActivity(intent)
            finish()
        }
        binding.textView50.setOnClickListener {
            val intent = Intent(this, AyseTakipciActivity::class.java)
            startActivity(intent)
            finish()
        }
        binding.imageView74.setOnClickListener {
            val intent = Intent(this, TakipciActivity::class.java)
            startActivity(intent)
            finish()
        }
        binding.anasayfa.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
        binding.textView59.setOnClickListener {
            val intent = Intent(this, AyseActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}