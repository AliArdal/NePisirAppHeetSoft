package com.example.casestudy

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import com.example.casestudy.FotoEkle.FotoEkleActivity
import com.example.casestudy.databinding.ActivityYemekTarifiBinding

class YemekTarifiActivity : AppCompatActivity() {
    private lateinit var binding : ActivityYemekTarifiBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityYemekTarifiBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.yemegiYaptM.setOnClickListener {
            val intent = Intent(this, FotoEkleActivity::class.java)
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