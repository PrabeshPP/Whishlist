package com.example.wishlist

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.inputmethod.InputMethodManager
import android.widget.AbsListView.RecyclerListener
import android.widget.Button
import android.widget.EditText
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var items: MutableList<Item>
    private lateinit var itemsRv:RecyclerView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        itemsRv=findViewById(R.id.recyclerView)
        val itemNameId=findViewById<EditText>(R.id.editTextTextPersonName4)
        val itemPriceId=findViewById<EditText>(R.id.priceId)
        val itemUrlId=findViewById<EditText>(R.id.editTextTextPersonName5)
        val buttonId=findViewById<Button>(R.id.button)
        items=ArrayList<Item>()
        val adapter=EmailAdapter(items)
        itemsRv.adapter=adapter
        itemsRv.layoutManager=LinearLayoutManager(this)
        buttonId.setOnClickListener {
            this.currentFocus?.let { view ->
                val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as? InputMethodManager
                imm?.hideSoftInputFromWindow(view.windowToken, 0)
            }
            var currentName=itemNameId.getText().toString();
            var currentPrice=itemPriceId.getText().toString()
            var currentURL=itemUrlId.getText().toString()
            val newItem=Item(currentName,currentURL,currentPrice)
            items.add(newItem)

            itemNameId.text.clear()
            itemPriceId.text.clear()
            itemUrlId.text.clear()
            adapter.notifyDataSetChanged()
        }
    }
}