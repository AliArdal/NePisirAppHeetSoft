package com.example.casestudy

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.casestudy.Adapter.MainAdapter10
import com.example.casestudy.Adapter.MainAdapter12
import com.example.casestudy.Class.DataClass5
import com.example.casestudy.Class.DataClass6
import com.example.casestudy.databinding.ActivityBildirimBinding
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class BildirimActivity : AppCompatActivity() {

    private lateinit var binding : ActivityBildirimBinding
    private lateinit var database: DatabaseReference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBildirimBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.geri.setOnClickListener {
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

        val tumTarifler = ArrayList<DataClass6>()
        val mainAdapter12 = MainAdapter12(this,tumTarifler)
        binding.recyclerView.adapter = mainAdapter12

        database.child("bildirimler").addListenerForSingleValueEvent(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                if (snapshot.exists()) {
                    for (yemekSnapshot in snapshot.children) {
                        val tarif = yemekSnapshot.getValue(DataClass6::class.java)
                        tarif?.let {
                            tumTarifler.add(it)
                        }
                    }
                    mainAdapter12.notifyDataSetChanged()
                }
            }

            override fun onCancelled(error: DatabaseError) {
                println("Veri okuma işlemi iptal edildi. Hata: ${error.message}")
            }
        })

    }
}