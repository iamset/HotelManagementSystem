package com.example.hotelmanagementsystem

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.hotelmanagementsystem.model.Room
import com.example.hotelmanagementsystem.views.ManageBookedRoomActivity

class RoomListAdapter(private val mRooms: ArrayList<Room>, val context: Context): RecyclerView.Adapter<RoomListAdapter.ViewHolder>() {
    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val room:ImageView = itemView.findViewById(R.id.img_room)
        val numOfBeds: TextView = itemView.findViewById(R.id.txt_num_beds)
        val price: TextView = itemView.findViewById(R.id.txt_room_price)
        val book: TextView = itemView.findViewById(R.id.txt_book)
//        val parentLayout: ConstraintLayout = itemView.findViewById(R.id.room_list_item_parent)


    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.room_list_item, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val room = mRooms[position]
        holder.numOfBeds.text = room.numOfBeds.toString()
        holder.price.text = room.rate.toString()
        Glide.with(context).asBitmap().load(room.image).into(holder.room)

        holder.book.setOnClickListener(object : View.OnClickListener{
            override fun onClick(v: View?) {

                Toast.makeText(context, "You have booked the room with ${room.numOfBeds} beds", Toast.LENGTH_SHORT).show()
                val intent: Intent = Intent(context, ManageBookedRoomActivity::class.java)
                context.startActivity(intent)

//                mRooms.removeAt(holder.absoluteAdapterPosition)
//                room.isBooked = true
//                notifyItemRemoved(holder.absoluteAdapterPosition);
//                notifyItemRangeChanged(position, mRooms.size);

            }

        })

    }

    override fun getItemCount(): Int {
        return mRooms.size
    }


}