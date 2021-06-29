package com.example.hotelmanagementsystem.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Spinner
import com.example.hotelmanagementsystem.R

class ReservationActivity : AppCompatActivity() {

    fun setAdapter(spinner: Spinner, stringArray: Int){
        ArrayAdapter.createFromResource(
            this,
            stringArray,
            android.R.layout.simple_spinner_item
        ).also {
                adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinner.adapter = adapter

        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reservation)

        val spinner1: Spinner = findViewById(R.id.spinner1)
        val spinner2: Spinner = findViewById(R.id.spinner2)
        val spinner3: Spinner = findViewById(R.id.spinner3)
        val spinner4: Spinner = findViewById(R.id.spinner4)

        setAdapter(spinner1, R.array.nights)
        setAdapter(spinner2, R.array.adults)
        setAdapter(spinner3, R.array.beds)
        setAdapter(spinner4, R.array.children)

    }
}