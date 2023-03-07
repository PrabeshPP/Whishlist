package com.example.wishlist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class EmailAdapter(private val items:List<Item>): RecyclerView.Adapter<EmailAdapter.ViewHolder>() {
    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val nameTextView:TextView
        val priceTextView:TextView
        val urlTextView:TextView

        init {
            nameTextView=itemView.findViewById(R.id.itemName)
            priceTextView=itemView.findViewById(R.id.itemPrice)
            urlTextView=itemView.findViewById(R.id.itemUrl)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val context=parent.context
        val inflater=LayoutInflater.from(context)
        val contactView=inflater.inflate(R.layout.whilist_item,parent,false)
        return ViewHolder(contactView)

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.setIsRecyclable(false)
        val item= items[position]
        holder.nameTextView.text=item.name
        holder.priceTextView.text=item.price
        holder.urlTextView.text=item.url
    }

    override fun getItemCount(): Int {
        return items.size
    }
}