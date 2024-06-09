package com.example.mymvvm

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MyAdapter : RecyclerView.Adapter<MyAdapter.MyViewHolder>() {

    private var arrayList: List<MyData> = listOf()

    fun submitList(data: List<MyData>) {
        arrayList = data
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_view, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(arrayList[position])
    }

    override fun getItemCount(): Int = arrayList.size

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val id: TextView = itemView.findViewById(R.id.tvId)
        val body: TextView = itemView.findViewById(R.id.tvBody)
        val title: TextView = itemView.findViewById(R.id.tvTitle)
        fun bind(data: MyData) {
            id.text = data.id
            body.text = data.body
            title.text = data.title

        }
    }
}
