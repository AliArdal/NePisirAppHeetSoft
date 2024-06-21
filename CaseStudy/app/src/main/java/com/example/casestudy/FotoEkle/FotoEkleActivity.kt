package com.example.casestudy.FotoEkle

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import com.example.casestudy.DetayActivity
import com.example.casestudy.YemekTarifiActivity
import com.example.casestudy.databinding.ActivityFotoEkleBinding

class FotoEkleActivity : AppCompatActivity() {

    private lateinit var binding : ActivityFotoEkleBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFotoEkleBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.geriDon.setOnClickListener {
            val intent = Intent(this, YemekTarifiActivity::class.java)
            startActivity(intent)
            finish()
        }
        binding.devamEt.setOnClickListener {
            val intent = Intent(this, FotoEkleActivity2::class.java)
            startActivity(intent)
            finish()
        }
        binding.view.setOnClickListener {
            val intent = Intent(this, FotoEkleActivity2::class.java)
            startActivity(intent)
            finish()
        }
        binding.geri.setOnClickListener {
            val alertDialogBuilder = AlertDialog.Builder(this)
            alertDialogBuilder.setMessage("Çıkmak istediğinize emin misiniz?")
                .setCancelable(false)
                .setPositiveButton("Evet") { dialog, id ->

                    val intent = Intent(this, DetayActivity::class.java)
                    startActivity(intent)
                    finish()
                }
                .setNegativeButton("Hayır") { dialog, id ->

                    dialog.cancel()
                }
            val alertDialog = alertDialogBuilder.create()
            alertDialog.show()
        }
    }
}