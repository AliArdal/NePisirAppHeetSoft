package com.example.casestudy
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.casestudy.Adapter.MainAdapter
import com.example.casestudy.Adapter.MainAdapter2
import com.example.casestudy.Adapter.MainAdapter3
import com.example.casestudy.Adapter.MainAdapter4
import com.example.casestudy.Class.DataClass
import com.example.casestudy.Class.DataClass2
import com.example.casestudy.databinding.ActivityMainBinding
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding
    private lateinit var database: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)




        database = FirebaseDatabase.getInstance().reference

        binding.Profil.setOnClickListener {
            val intent = Intent(this,ProfilimActivity::class.java)
            startActivity(intent)
            finish()
        }

        binding.imageView17.setOnClickListener {
            val intent = Intent(this,BildirimActivity::class.java)
            startActivity(intent)
            finish()
        }

        binding.recyclerView.layoutManager = StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL)
        binding.recyclerView2.layoutManager = StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL)
        binding.recyclerView3.layoutManager = StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.HORIZONTAL)
        binding.recyclerView4.layoutManager = StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL)


        val yemekler = ArrayList<DataClass>()
        val mainAdapter = MainAdapter(this, yemekler)
        binding.recyclerView.adapter = mainAdapter


        database.child("yemekler").addListenerForSingleValueEvent(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                if (snapshot.exists()) {
                    for (yemekSnapshot in snapshot.children) {
                        val yemek = yemekSnapshot.getValue(DataClass::class.java)
                        yemek?.let {
                            yemekler.add(it)
                        }
                    }
                    mainAdapter.notifyDataSetChanged()
                }
            }

            override fun onCancelled(error: DatabaseError) {
                println("Veri okuma işlemi iptal edildi. Hata: ${error.message}")
            }
        })

        val tumTarifler = ArrayList<DataClass>()
        val mainAdapter2 = MainAdapter2(this,tumTarifler)
        binding.recyclerView2.adapter = mainAdapter2

        database.child("tumTarifler").addListenerForSingleValueEvent(object : ValueEventListener {
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

        val arkadaslar = ArrayList<DataClass2>()
        val mainAdapter3 = MainAdapter3(this,arkadaslar)
        binding.recyclerView3.adapter = mainAdapter3

        database.child("arkadas").addListenerForSingleValueEvent(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                if (snapshot.exists()) {
                    for (yemekSnapshot in snapshot.children) {
                        val dost = yemekSnapshot.getValue(DataClass2::class.java)
                        dost?.let {
                            arkadaslar.add(it)
                        }
                    }
                    mainAdapter3.notifyDataSetChanged()
                }
            }

            override fun onCancelled(error: DatabaseError) {
                println("Veri okuma işlemi iptal edildi. Hata: ${error.message}")
            }
        })

        val tumTariflerr = ArrayList<DataClass>()
        val mainAdapter4 = MainAdapter4(this,tumTariflerr)
        binding.recyclerView4.adapter = mainAdapter4

        database.child("tumTariflerr").addListenerForSingleValueEvent(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                if (snapshot.exists()) {
                    for (yemekSnapshot in snapshot.children) {
                        val dost = yemekSnapshot.getValue(DataClass::class.java)
                        dost?.let {
                            tumTariflerr.add(it)
                        }
                    }
                    mainAdapter4.notifyDataSetChanged()
                }
            }

            override fun onCancelled(error: DatabaseError) {
                println("Veri okuma işlemi iptal edildi. Hata: ${error.message}")
            }
        })
    }

    }



