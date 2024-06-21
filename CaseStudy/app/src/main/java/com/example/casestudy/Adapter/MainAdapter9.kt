package com.example.casestudy.Adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.casestudy.Class.DataClass5
import com.example.casestudy.databinding.CardTasarim7Binding
import com.example.casestudy.ayse.AyseActivity
import com.example.casestudy.TakipciActivity
import com.squareup.picasso.Picasso

class MainAdapter9(var mContext: Context, var arkadasListesi: List<DataClass5>)
    : RecyclerView.Adapter<MainAdapter9.CardTasarimTutucu>() {

    inner class CardTasarimTutucu(var tasarim: CardTasarim7Binding) : RecyclerView.ViewHolder(tasarim.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardTasarimTutucu {
        val binding = CardTasarim7Binding.inflate(LayoutInflater.from(mContext), parent, false)
        return CardTasarimTutucu(binding)
    }

    override fun onBindViewHolder(holder: CardTasarimTutucu, position: Int) {
        val arkadas = arkadasListesi[position]
        val t = holder.tasarim

        Picasso.get().load(arkadas.kisiFoto).into(t.kisiFoto)
        t.kisiAd.text = arkadas.kisiAd

        t.root.setOnClickListener {
            val intent = when (position) {
                0 -> Intent(mContext, AyseActivity::class.java)
                else -> Intent(mContext, TakipciActivity::class.java)
            }
            intent.putExtra("id", arkadas.id)
            mContext.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return arkadasListesi.size
    }
}
