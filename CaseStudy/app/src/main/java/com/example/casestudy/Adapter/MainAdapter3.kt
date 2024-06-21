package com.example.casestudy.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.casestudy.Class.DataClass2
import com.example.casestudy.databinding.CardTasarim3Binding
import com.squareup.picasso.Picasso

class MainAdapter3(var mContext: Context, var arkadasListesi:List<DataClass2>)
    : RecyclerView.Adapter<MainAdapter3.CardTasarimTutucu>(){

    inner class CardTasarimTutucu(var tasarim: CardTasarim3Binding) : RecyclerView.ViewHolder(tasarim.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardTasarimTutucu {
        val binding = CardTasarim3Binding.inflate(LayoutInflater.from(mContext), parent, false)
        return CardTasarimTutucu(binding)
    }

    override fun onBindViewHolder(holder: CardTasarimTutucu, position: Int) {
        val arkadas = arkadasListesi[position]
        val t = holder.tasarim

        Picasso.get().load(arkadas.kisiFoto).into(t.kisiFoto)

        t.kisiAd.text = arkadas.kisiAd
        t.takipci.text = "${arkadas.takipci} Takipçi."
    }

    override fun getItemCount(): Int {
        return arkadasListesi.size
    }




}