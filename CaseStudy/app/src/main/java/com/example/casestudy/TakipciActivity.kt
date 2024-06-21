package com.example.casestudy

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.casestudy.Adapter.MainAdapter8
import com.example.casestudy.Adapter.MainAdapter9
import com.example.casestudy.Class.DataClass
import com.example.casestudy.Class.DataClass5
import com.example.casestudy.databinding.ActivityTakipciBinding
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class TakipciActivity : AppCompatActivity() {

    private lateinit var binding : ActivityTakipciBinding
    private lateinit var database: DatabaseReference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTakipciBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.textView58.setOnClickListener {
            val intent = Intent(this,TakipEdilenActivity::class.java)
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
        val mainAdapter9 = MainAdapter9(this,tumTarifler)
        binding.recyclerView.adapter = mainAdapter9

        database.child("takipci").addListenerForSingleValueEvent(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                if (snapshot.exists()) {
                    for (yemekSnapshot in snapshot.children) {
                        val tarif = yemekSnapshot.getValue(DataClass5::class.java)
                        tarif?.let {
                            tumTarifler.add(it)
                        }
                    }
                    mainAdapter9.notifyDataSetChanged()
                }
            }

            override fun onCancelled(error: DatabaseError) {
                println("Veri okuma işlemi iptal edildi. Hata: ${error.message}")
            }
        })
    }
}