package com.example.hotelmanagementsystem

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.hotelmanagementsystem.views.BookedRoomListFragment
import com.example.hotelmanagementsystem.views.RoomListFragment

class HomeScreenPagerAdapter(
    var context: Context,
    fm: FragmentManager,
    var totalTabs: Int
): FragmentPagerAdapter(fm){
    override fun getCount(): Int {
        return totalTabs
    }

    override fun getItem(position: Int): Fragment {
        return when (position){
            0-> {
                RoomListFragment()
            }
            1->{
                BookedRoomListFragment()
            }
            else-> getItem(position)
        }
    }
}