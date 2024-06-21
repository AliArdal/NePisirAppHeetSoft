package com.example.casestudy.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.casestudy.Class.DataClass4
import com.example.casestudy.ProfilimActivity
import com.example.casestudy.R

interface OnItemClickListener {
    fun onItemClick(index: Int)
}

class MainAdapter7(
    private val context: Context,
    private val dataList: ArrayList<DataClass4>,
    private val itemClickListener: ProfilimActivity
) : RecyclerView.Adapter<MainAdapter7.ViewHolderClass>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderClass {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.card_tasarim5, parent, false)
        return ViewHolderClass(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolderClass, position: Int) {
        val currentItem = dataList[position]
        holder.rvImage.setImageResource(currentItem.dataImage)
        holder.rvTitle.text = currentItem.dataTitle

        holder.itemView.setOnClickListener {
            itemClickListener.onItemClick(currentItem.index)
        }
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    class ViewHolderClass(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val rvImage: ImageView = itemView.findViewById(R.id.rvImage)
        val rvTitle: TextView = itemView.findViewById(R.id.rvTitle)
    }
}