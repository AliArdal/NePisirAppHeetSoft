package com.example.casestudy.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.casestudy.Class.DataClass5
import com.example.casestudy.databinding.CardTasarim9Binding
import com.squareup.picasso.Picasso

class MainAdapter11(var mContext: Context, var arkadasListesi:List<DataClass5>)
    : RecyclerView.Adapter<MainAdapter11.CardTasarimTutucu>(){

    inner class CardTasarimTutucu(var tasarim: CardTasarim9Binding) : RecyclerView.ViewHolder(tasarim.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardTasarimTutucu {
        val binding = CardTasarim9Binding.inflate(LayoutInflater.from(mContext), parent, false)
        return CardTasarimTutucu(binding)
    }

    override fun onBindViewHolder(holder: CardTasarimTutucu, position: Int) {
        val arkadas = arkadasListesi[position]
        val t = holder.tasarim

        Picasso.get().load(arkadas.kisiFoto).into(t.kisiFoto)

        t.kisiAd.text = arkadas.kisiAd

    }

    override fun getItemCount(): Int {
        return arkadasListesi.size
    }

}