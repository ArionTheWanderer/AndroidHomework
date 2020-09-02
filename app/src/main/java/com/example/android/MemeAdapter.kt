package com.example.android

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class MemeAdapter(var dataSrc: ArrayList<Meme>) : RecyclerView.Adapter<MemeItemHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MemeItemHolder =
        MemeItemHolder.create(parent)


    override fun getItemCount(): Int = dataSrc.size


    override fun onBindViewHolder(holder: MemeItemHolder, position: Int) {
        holder.bind(dataSrc[position])
    }
}
