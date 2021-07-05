package com.example.hotelmanagementsystem.views

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import com.example.hotelmanagementsystem.R
import com.example.hotelmanagementsystem.model.SelectedDate
import com.example.hotelmanagementsystem.model.SelectedDates
import com.example.hotelmanagementsystem.utils.General


class ReservationActivity : AppCompatActivity() {
    override fun onStart() {
        super.onStart()
        val checkInTextView = findViewById<TextView>(R.id.txt_check_in_str)
        val checkOutTextView = findViewById<TextView>(R.id.txt_check_out_str)
        if(SelectedDates.dates.size > 0){
            checkInTextView.text = SelectedDates.dates[0].date
            checkOutTextView.text = SelectedDates.dates[SelectedDates.dates.size-1].date
        }

    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reservation)

        //Selection of View components
        val spinner1: Spinner = findViewById(R.id.spinner1)
        val spinner2: Spinner = findViewById(R.id.spinner2)
        val spinner3: Spinner = findViewById(R.id.spinner3)
        val spinner4: Spinner = findViewById(R.id.spinner4)

        val calendarView : CalendarView = findViewById(R.id.cal_main)
        val button:Button = findViewById(R.id.btn_place_reservation)
        Toast.makeText(this, SelectedDates.dates.size.toString(), Toast.LENGTH_SHORT).show()

        calendarView.setOnDateChangeListener{view: CalendarView, year: Int, month: Int, dayOfMonth: Int ->
            val date = "$dayOfMonth/${month+1}/$year"
            val price = 48.7
            val intent = Intent(this, SelectedDatesActivity::class.java)
            intent.putExtra("date", date)
            intent.putExtra("rate", price)
            intent.putExtra("day", dayOfMonth)
            startActivity(intent)
        }
        General.setAdapter(spinner1, R.array.nights, this)
        General.setAdapter(spinner2, R.array.adults, this)
        General.setAdapter(spinner3, R.array.beds, this)
        General.setAdapter(spinner4, R.array.children, this)

        // Reserve Room and navigate to Guest information Page
        fun reserveAndNavigateToGuestInfo(view: View){
            if(SelectedDates.dates.size < 1){
                Toast.makeText(this, "Please Select date", Toast.LENGTH_LONG).show()
            } else {
                val intent = Intent(this, GuestInformationActivity::class.java)
                startActivity(intent)
            }

        }
        button.setOnClickListener{
           reserveAndNavigateToGuestInfo(button)
        }

    }
    fun onItemClicked(){
        Toast.makeText(this, "Please select a date from the calendar", Toast.LENGTH_SHORT).show()
    }

}