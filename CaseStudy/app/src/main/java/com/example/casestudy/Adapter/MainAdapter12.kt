package com.example.casestudy.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.casestudy.Class.DataClass6
import com.example.casestudy.databinding.CardTasarim10Binding
import com.squareup.picasso.Picasso

class MainAdapter12(var mContext: Context, var arkadasListesi:List<DataClass6>)
    : RecyclerView.Adapter<MainAdapter12.CardTasarimTutucu>(){

    inner class CardTasarimTutucu(var tasarim: CardTasarim10Binding) : RecyclerView.ViewHolder(tasarim.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardTasarimTutucu {
        val binding = CardTasarim10Binding.inflate(LayoutInflater.from(mContext), parent, false)
        return CardTasarimTutucu(binding)
    }

    override fun onBindViewHolder(holder: CardTasarimTutucu, position: Int) {
        val arkadas = arkadasListesi[position]
        val t = holder.tasarim

        Picasso.get().load(arkadas.kisiFoto).into(t.kisiFoto)
        Picasso.get().load(arkadas.durum).into(t.durum)

        t.kisiAd.text = arkadas.kisiAd
        t.metin.text = arkadas.metin
        t.saat.text = arkadas.saat

    }

    override fun getItemCount(): Int {
        return arkadasListesi.size
    }

}