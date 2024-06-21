package com.example.casestudy

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.casestudy.Adapter.MainAdapter7
import com.example.casestudy.Class.DataClass4
import com.example.casestudy.databinding.ActivityProfilimBinding
import com.example.casestudy.yemeklerim.YemeklerimActivity

class ProfilimActivity : AppCompatActivity() {

    private lateinit var binding : ActivityProfilimBinding
    private lateinit var recyclerView: RecyclerView
    private lateinit var dataList : ArrayList<DataClass4>
    lateinit var imageList:Array<Int>
    lateinit var titleList:Array<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProfilimBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.anasayfa.setOnClickListener {
            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
            finish()
        }
        binding.textView49.setOnClickListener {
            val intent = Intent(this,TakipciActivity::class.java)
            startActivity(intent)
            finish()
        }
        binding.textView50.setOnClickListener {
            val intent = Intent(this,TakipciActivity::class.java)
            startActivity(intent)
            finish()
        }
        binding.textView51.setOnClickListener {
            val intent = Intent(this,TakipEdilenActivity::class.java)
            startActivity(intent)
            finish()
        }
        binding.textView52.setOnClickListener {
            val intent = Intent(this,TakipEdilenActivity::class.java)
            startActivity(intent)
            finish()
        }


        imageList = arrayOf(
            R.drawable.img_59,
            R.drawable.img_61,
            R.drawable.img_62,
            R.drawable.img_63

        )

        titleList = arrayOf(
            "Tarif Defterim",
            "Yemeklerim",
            "Taslaktaki Tariflerim",
            "Onaydaki Tariflerim"

        )
        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.setHasFixedSize(true)

        dataList = arrayListOf<DataClass4>()
        getData()

        val adapter = MainAdapter7(this, dataList, this)
        recyclerView.adapter = adapter
    }
    private fun getData() {
        for (i in imageList.indices) {
            val dataClass = DataClass4(imageList[i], titleList[i], i)
            dataList.add(dataClass)
        }
    }
    fun onItemClick(index: Int) {

        when (index) {
            1 -> {
                val intent = Intent(this, YemeklerimActivity::class.java)
                startActivity(intent)
            }


        }
    }
}