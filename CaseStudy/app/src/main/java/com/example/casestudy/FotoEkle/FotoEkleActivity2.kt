package com.example.casestudy.FotoEkle

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import com.example.casestudy.DetayActivity
import com.example.casestudy.databinding.ActivityFotoEkle2Binding

class FotoEkleActivity2 : AppCompatActivity() {

    private lateinit var binding : ActivityFotoEkle2Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFotoEkle2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.geriDon.setOnClickListener {
            val intent = Intent(this, FotoEkleActivity::class.java)
            startActivity(intent)
            finish()
        }
        binding.devamEt.setOnClickListener {
            val intent = Intent(this, FotoEkleActivity3::class.java)
            startActivity(intent)
            finish()
        }
        binding.geri.setOnClickListener {
            val alertDialogBuilder = AlertDialog.Builder(this)
            alertDialogBuilder.setMessage("Çıkmak istediğinize emin misiniz?")
                .setCancelable(false)
                .setPositiveButton("Evet") { dialog, id ->
                    // Kullanıcı evet'e tıkladığında yapılacak işlemler
                    val intent = Intent(this, DetayActivity::class.java)
                    startActivity(intent)
                    finish()
                }
                .setNegativeButton("Hayır") { dialog, id ->
                    // Kullanıcı hayır'a tıkladığında yapılacak işlemler
                    dialog.cancel() // Dialog'u kapat
                }
            val alertDialog = alertDialogBuilder.create()
            alertDialog.show()
        }
    }
}