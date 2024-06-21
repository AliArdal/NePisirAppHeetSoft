package com.example.casestudy

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.casestudy.Adapter.MainAdapter10
import com.example.casestudy.Class.DataClass5
import com.example.casestudy.databinding.ActivityTakipEdilenBinding
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class TakipEdilenActivity : AppCompatActivity() {

    private lateinit var binding : ActivityTakipEdilenBinding
    private lateinit var database: DatabaseReference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTakipEdilenBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.textView55.setOnClickListener {
            val intent = Intent(this,TakipciActivity::class.java)
            startActivity(intent)
            finish()
        }
        binding.imageView51.setOnClickListener {
            val intent = Intent(this,ProfilimActivity::class.java)
            startActivity(intent)
            finish()
        }
        binding.anasayfa.setOnClickListener {
            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
            finish()
        }
        binding.Profil.setOnClickListener {
            val intent = Intent(this,ProfilimActivity::class.java)
            startActivity(intent)
            finish()
        }

        database = FirebaseDatabase.getInstance().reference
        binding.recyclerView.layoutManager = StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL)

        val tumTarifler = ArrayList<DataClass5>()
        val mainAdapter10 = MainAdapter10(this,tumTarifler)
        binding.recyclerView.adapter = mainAdapter10

        database.child("takipedilen").addListenerForSingleValueEvent(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                if (snapshot.exists()) {
                    for (yemekSnapshot in snapshot.children) {
                        val tarif = yemekSnapshot.getValue(DataClass5::class.java)
                        tarif?.let {
                            tumTarifler.add(it)
                        }
                    }
                    mainAdapter10.notifyDataSetChanged()
                }
            }

            override fun onCancelled(error: DatabaseError) {
                println("Veri okuma işlemi iptal edildi. Hata: ${error.message}")
            }
        })
    }
}

