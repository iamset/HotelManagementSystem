package com.example.hotelmanagementsystem.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager

import androidx.recyclerview.widget.RecyclerView

import com.example.hotelmanagementsystem.R
import com.example.hotelmanagementsystem.SelectedDatesAdapter
import com.example.hotelmanagementsystem.model.SelectedDate
import com.example.hotelmanagementsystem.model.SelectedDates


class SelectedDatesActivity : AppCompatActivity() {
    lateinit var rv: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_selected_dates)
        rv = findViewById(R.id.recycler_view_items)

        val date:String? = intent.getStringExtra("date").toString()
        val price:Double? = intent.getDoubleExtra("rate",0.0)
        val dayOfMonth: Int? = intent.getIntExtra("day", 1)
        SelectedDates.dates.add(SelectedDate(date, price, dayOfMonth))
        rv.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        val adapter = SelectedDatesAdapter(SelectedDates.dates, this)
        rv.adapter = adapter
    }
}