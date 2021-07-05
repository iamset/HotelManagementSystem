package com.example.hotelmanagementsystem.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager.widget.ViewPager
import com.example.hotelmanagementsystem.HomeScreenPagerAdapter

import com.example.hotelmanagementsystem.R
import com.google.android.material.tabs.TabLayout

class HomeScreenActivity : AppCompatActivity() {
    lateinit var pager: ViewPager
    lateinit var tabLayout: TabLayout
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_screen)
        tabLayout = findViewById(R.id.tablayout1)
        pager = findViewById(R.id.pager1)

        tabLayout.addTab(tabLayout.newTab().setText("ROOMS"))
        tabLayout.addTab(tabLayout.newTab().setText("BOOKED"))
        tabLayout.tabGravity = TabLayout.GRAVITY_FILL

        val adapter = HomeScreenPagerAdapter(this, supportFragmentManager, tabLayout.tabCount)
        pager.adapter = adapter
        pager.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(tabLayout))
        tabLayout.addOnTabSelectedListener(object: TabLayout.OnTabSelectedListener{
            override fun onTabSelected(tab: TabLayout.Tab?) {
                if (tab != null) {
                    pager.currentItem = tab.position
                }
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {

            }

            override fun onTabReselected(tab: TabLayout.Tab?) {

            }

        })

    }

}