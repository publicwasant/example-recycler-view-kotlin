package com.example.myrecycleview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myrecycleview.adapters.ItemAdapter
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.item_custom_row.*
import kotlinx.android.synthetic.main.item_custom_row.view.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.setContentView(R.layout.activity_main)

        recycler_view_items.layoutManager = LinearLayoutManager(this)
//        recycler_view_items.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
//        recycler_view_items.layoutManager = GridLayoutManager(this, 3)

        val items = this.getItemsList()
        val itemAdapter = ItemAdapter(this, items)

        itemAdapter.addOnClickItem {
            it.setBackgroundColor(ContextCompat.getColor(this, R.color.purple_200))
            it.visibility = View.GONE
        }

        recycler_view_items.adapter = itemAdapter

    }

    private fun getItemsList(): ArrayList<String> {
        val list = ArrayList<String>()

        for(i in 1..15) {
            list.add("I-$i")
        }

        return list
    }
}
