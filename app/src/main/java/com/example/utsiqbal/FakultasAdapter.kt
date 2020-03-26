package com.example.utsiqbal

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.tugasuts.R
import kotlinx.android.synthetic.main.detail_fakultas_layout.view.*
import kotlinx.android.synthetic.main.list_fakultas_layout.view.*

class FakultasAdapter(val fakultasItemList: List<FakultasData>, val clickListener: (FakultasData) -> Unit) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.list_fakultas_layout, parent, false)
        return PartViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as PartViewHolder).bind(fakultasItemList[position], clickListener)
    }

    override fun getItemCount() = fakultasItemList.size

    class PartViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(fakultas: FakultasData, clickListener: (FakultasData) -> Unit) {
            itemView.namaFakultas.text = fakultas.namaFakultas.toString()
            itemView.fotoFakultas.setImageResource(fakultas.fotoFakultas)
            itemView.setOnClickListener{clickListener(fakultas)}
        }
    }
}