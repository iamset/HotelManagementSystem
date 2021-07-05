package com.example.hotelmanagementsystem.model

import java.time.Month

class SelectedDate(var date:String?, var price:Double?, var dayOfMonth:Int?){
    init {
       price =  when(dayOfMonth){
            1,2,3,4,5,6,7,8,9,10 -> 100.5
            11,12,13,14,15,16,17 -> 80.5
            18,19,20,21,22,23,24,25,26,27,28,29,30,31 -> 70.8
            else -> 0.00
        }
    }
}
object SelectedDates{
    val dates:ArrayList<SelectedDate> = arrayListOf()
}
