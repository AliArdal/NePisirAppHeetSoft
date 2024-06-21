package com.example.casestudy.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.casestudy.Class.DataClass3
import com.example.casestudy.databinding.CardTasarim4Binding
import com.squareup.picasso.Picasso

class MainAdapter5 (var mContext: Context, var yorumlar:List<DataClass3>)
    : RecyclerView.Adapter<MainAdapter5.CardTasarimTutucu>(){

    inner class CardTasarimTutucu(var tasarim: CardTasarim4Binding) : RecyclerView.ViewHolder(tasarim.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardTasarimTutucu {
        val binding = CardTasarim4Binding.inflate(LayoutInflater.from(mContext), parent, false)
        return CardTasarimTutucu(binding)
    }


    override fun onBindViewHolder(holder: CardTasarimTutucu, position: Int) {
        val yorumlar = yorumlar[position]
        val t = holder.tasarim

        Picasso.get().load(yorumlar.kisiFoto).into(t.kisiFoto)

        t.kisiAd.text = yorumlar.kisiAd
        t.tarih.text = yorumlar.tarih
        t.yorum.text = yorumlar.yorum
        t.begeni.text = yorumlar.begeni.toString()
        t.paylas.text = yorumlar.paylas.toString()
    }

    override fun getItemCount(): Int {
        return yorumlar.size
    }




}