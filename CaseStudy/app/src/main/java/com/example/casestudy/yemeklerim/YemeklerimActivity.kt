package com.example.casestudy.yemeklerim

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.casestudy.Adapter.MainAdapter2
import com.example.casestudy.Class.DataClass
import com.example.casestudy.MainActivity
import com.example.casestudy.ProfilimActivity

import com.example.casestudy.databinding.ActivityYemeklerimBinding
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class YemeklerimActivity : AppCompatActivity() {

    private lateinit var binding : ActivityYemeklerimBinding
    private lateinit var database: DatabaseReference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityYemeklerimBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.anasayfa.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
        binding.arsiv.setOnClickListener {
            val intent = Intent(this, ArsivActivity::class.java)
            startActivity(intent)
            finish()
        }
        binding.arsivText.setOnClickListener {
            val intent = Intent(this, ArsivActivity::class.java)
            startActivity(intent)
            finish()
        }
        binding.textView56.setOnClickListener {
            val intent = Intent(this, UrettigimActivity::class.java)
            startActivity(intent)
            finish()
        }
        binding.textView58.setOnClickListener {
            val intent = Intent(this, GonderdigimActivity::class.java)
            startActivity(intent)
            finish()
        }
        binding.imageView51.setOnClickListener {
            val intent = Intent(this, ProfilimActivity::class.java)
            startActivity(intent)
            finish()
        }
        binding.Profil.setOnClickListener {
            val intent = Intent(this, ProfilimActivity::class.java)
            startActivity(intent)
            finish()
        }

        database = FirebaseDatabase.getInstance().reference

        binding.recyclerView.layoutManager = StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL)

        val tumTarifler = ArrayList<DataClass>()
        val mainAdapter2 = MainAdapter2(this,tumTarifler)
        binding.recyclerView.adapter = mainAdapter2

        database.child("yemeklerim").addListenerForSingleValueEvent(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                if (snapshot.exists()) {
                    for (yemekSnapshot in snapshot.children) {
                        val tarif = yemekSnapshot.getValue(DataClass::class.java)
                        tarif?.let {
                            tumTarifler.add(it)
                        }
                    }
                    mainAdapter2.notifyDataSetChanged()
                }
            }

            override fun onCancelled(error: DatabaseError) {
                println("Veri okuma işlemi iptal edildi. Hata: ${error.message}")
            }
        })
    }
}