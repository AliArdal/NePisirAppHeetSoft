package com.example.casestudy.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.casestudy.Class.DataClass
import com.example.casestudy.databinding.CardTasarim2Binding
import com.example.casestudy.databinding.CardTasarim6Binding
import com.squareup.picasso.Picasso

class MainAdapter8 (var mContext: Context, var yemeklerListesi:List<DataClass>)
    :RecyclerView.Adapter<MainAdapter8.CardTasarimTutucu>() {

    inner class CardTasarimTutucu(var tasarim: CardTasarim6Binding) : RecyclerView.ViewHolder(tasarim.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardTasarimTutucu {
        val binding = CardTasarim6Binding.inflate(LayoutInflater.from(mContext), parent, false)
        return CardTasarimTutucu(binding)
    }

    override fun onBindViewHolder(holder: CardTasarimTutucu, position: Int) {
        val yemek = yemeklerListesi[position]
        val t = holder.tasarim


        Picasso.get().load(yemek.yemekFoto).into(t.yemekFoto)
        Picasso.get().load(yemek.kisiFoto).into(t.kisiFoto)

        t.yemekAdi.text = yemek.yemekAdi
        t.yemekSahibi.text = yemek.yemekSahibi
        t.yemekSuresi.text = "${yemek.yemekSuresi} dk."
        t.rating.text = yemek.rating.toString()
        t.sinif.text = yemek.sinif

    }

    override fun getItemCount(): Int {
        return yemeklerListesi.size
    }

}

