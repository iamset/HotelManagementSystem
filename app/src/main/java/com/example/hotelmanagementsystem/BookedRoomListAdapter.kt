package com.example.hotelmanagementsystem

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.hotelmanagementsystem.model.Room

class BookedRoomListAdapter(private val mRooms: ArrayList<Room>, val context: Context): RecyclerView.Adapter<BookedRoomListAdapter.ViewHolder>() {
    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val room:ImageView = itemView.findViewById(R.id.img_booked_room)
        val numOfBeds: TextView = itemView.findViewById(R.id.txt_booked_num_beds)
        val settings: ImageView = itemView.findViewById(R.id.img_settings)

    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.booked_room_list_item, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val room = mRooms[position]
        holder.numOfBeds.text = room.numOfBeds.toString()
        Glide.with(context).asBitmap().load(room.image).into(holder.room)


        holder.settings.setOnClickListener(object : View.OnClickListener{
            override fun onClick(v: View?) {

                Toast.makeText(context, "Clicked the room with ${room.numOfBeds} beds", Toast.LENGTH_SHORT).show()

            }

        })

    }

    override fun getItemCount(): Int {
        return mRooms.size
    }


}