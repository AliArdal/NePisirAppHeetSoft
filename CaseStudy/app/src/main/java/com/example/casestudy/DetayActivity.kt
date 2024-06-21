package com.example.casestudy

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.casestudy.Adapter.MainAdapter5
import com.example.casestudy.Adapter.MainAdapter6
import com.example.casestudy.Class.DataClass
import com.example.casestudy.Class.DataClass3
import com.example.casestudy.databinding.ActivityDetayBinding
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class DetayActivity : AppCompatActivity() {

    private lateinit var binding : ActivityDetayBinding
    private lateinit var database: DatabaseReference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetayBinding.inflate(layoutInflater)
        setContentView(binding.root)

        database = FirebaseDatabase.getInstance().reference
        binding.recylerView.layoutManager = StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.HORIZONTAL)
        binding.recyclerView2.layoutManager = StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL)

        binding.geri.setOnClickListener {
            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
            finish()
        }

        binding.paylasButon.setOnClickListener {
            val intent = Intent(this,YemekTarifiActivity::class.java)
            startActivity(intent)
            finish()
        }


        val yorumlar = ArrayList<DataClass3>()
        val mainAdapter5 = MainAdapter5(this,yorumlar )
        binding.recylerView.adapter = mainAdapter5

        database.child("yorumlar").addListenerForSingleValueEvent(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                if (snapshot.exists()) {
                    for (yemekSnapshot in snapshot.children) {
                        val yemek = yemekSnapshot.getValue(DataClass3::class.java)
                        yemek?.let {
                            yorumlar.add(it)
                        }
                    }
                    mainAdapter5.notifyDataSetChanged()
                }
            }

            override fun onCancelled(error: DatabaseError) {
                println("Veri okuma işlemi iptal edildi. Hata: ${error.message}")
            }
        })

        val yemekler = ArrayList<DataClass>()
        val mainAdapter6 = MainAdapter6(this, yemekler)
        binding.recyclerView2.adapter = mainAdapter6


        database.child("denediler").addListenerForSingleValueEvent(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                if (snapshot.exists()) {
                    for (yemekSnapshot in snapshot.children) {
                        val yemek = yemekSnapshot.getValue(DataClass::class.java)
                        yemek?.let {
                            yemekler.add(it)
                        }
                    }
                    mainAdapter6.notifyDataSetChanged()
                }
            }

            override fun onCancelled(error: DatabaseError) {
                println("Veri okuma işlemi iptal edildi. Hata: ${error.message}")
            }
        })
    }
}