package com.example.hotelmanagementsystem


import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.hotelmanagementsystem.model.Room
import com.example.hotelmanagementsystem.model.SelectedDate
import com.example.hotelmanagementsystem.model.SelectedDates

class SelectedDatesAdapter(
    private var dataSet: ArrayList<SelectedDate>,
    val context: Context
): RecyclerView.Adapter<SelectedDatesAdapter.ViewHolder>(){
     inner class ViewHolder(view: View) :RecyclerView.ViewHolder(view){
        val textViewDate : TextView
        val textViewPrice : TextView
        val buttonRemove : Button


        init {
            textViewDate = view.findViewById(R.id.txt_date)
            textViewPrice = view.findViewById(R.id.txt_room_rate)
            buttonRemove = view.findViewById(R.id.btn_remove_room)

        }

    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SelectedDatesAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.selected_date, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val selectedDate = dataSet[position]
        holder.textViewDate.text = selectedDate.date
        holder.textViewPrice.text = selectedDate.price.toString()
        holder.buttonRemove.setOnClickListener {
            SelectedDates.dates.removeAt(holder.absoluteAdapterPosition)
            notifyItemRemoved(holder.absoluteAdapterPosition);
            notifyItemRangeChanged(position, dataSet.size);
        }

    }

    override fun getItemCount(): Int  = dataSet.size
}