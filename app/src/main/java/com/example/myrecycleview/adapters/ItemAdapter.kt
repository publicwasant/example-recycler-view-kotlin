package com.example.myrecycleview.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.myrecycleview.R
import kotlinx.android.synthetic.main.item_custom_row.view.*

class ItemAdapter(private val context: Context, private val items: ArrayList<String>): RecyclerView.Adapter<ItemAdapter.ViewHolder>() {
    private var clickItemTask: ((v: View) -> Unit)? = null

    class ViewHolder(private val view: View): RecyclerView.ViewHolder(view) {
        val it: CardView = this.view.card_view_item
        val name: TextView = this.view.tv_item_name
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater
            .from(this.context)
            .inflate(R.layout.item_custom_row, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.it.setOnClickListener {
            this.clickItemTask!!(holder.it)
        }

        holder.name.text = items[position]
    }

    override fun getItemCount(): Int {
        return this.items.size
    }


    fun addOnClickItem(clickItemTask: (v: View) -> Unit) {
        this.clickItemTask = clickItemTask
    }
}