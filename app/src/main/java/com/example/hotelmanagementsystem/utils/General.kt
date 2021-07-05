package com.example.hotelmanagementsystem.utils

import android.content.Context
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast

object General {
    fun setAdapter(spinner: Spinner, rName: Int, context: Context){
        ArrayAdapter.createFromResource(
            context,
            rName,
            android.R.layout.simple_spinner_item
        ).also {
                adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinner.adapter = adapter

        }
    }
}