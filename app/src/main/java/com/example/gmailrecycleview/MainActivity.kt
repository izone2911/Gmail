package com.example.gmailrecycleview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val rv = findViewById<RecyclerView>(R.id.rv);
        //name date boolean
        val dataa = arrayListOf(itemModel("A", "12/03/1979", true),
            itemModel("B", "19/07/2019", false),
            itemModel("C", "02/10/1969", true),
            itemModel("D", "15/01/2029", false),
            itemModel("E", "15/04/1452", true),
            itemModel("F", "25/12/1642", false),
            itemModel("G", "30/11/1974", true),
            itemModel("H", "12/02/1909", false),
            itemModel("I", "12/02/1909", true),
            itemModel("K", "24/02/2055", false),
            itemModel("L", "26/04/1564", true),
            itemModel("M", "17/01/2042", false),
            itemModel("N", "26/08/2010", true),
            itemModel("O", "14/01/1975", false),
            itemModel("P", "07/11/1967", true),
            itemModel("Q", "08/01/2035", false),
            itemModel("R", "29/05/2017", true));
        rv.layoutManager = LinearLayoutManager(this);
        val adapter = RVCustom(dataa);
        val imageView = findViewById<ImageView>(R.id.imageView);
        imageView.setOnClickListener{
            dataa.removeAt(1);
            adapter.notifyItemRemoved(2)
        }

        rv.adapter = adapter
    }
}