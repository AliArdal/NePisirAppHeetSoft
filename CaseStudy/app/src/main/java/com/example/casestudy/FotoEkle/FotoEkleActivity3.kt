package com.example.casestudy.FotoEkle

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import com.example.casestudy.DetayActivity
import com.example.casestudy.databinding.ActivityFotoEkle3Binding

class FotoEkleActivity3 : AppCompatActivity() {
    private lateinit var binding : ActivityFotoEkle3Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFotoEkle3Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.geriDon.setOnClickListener {
            val intent = Intent(this, FotoEkleActivity2::class.java)
            startActivity(intent)
            finish()
        }
        binding.paylasButon.setOnClickListener {
            val intent = Intent(this, TebriklerActivity::class.java)
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
