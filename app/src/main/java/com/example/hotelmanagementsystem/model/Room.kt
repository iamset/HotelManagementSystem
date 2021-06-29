package com.example.hotelmanagementsystem.model

data class Room (
    private var number:Int,
    private var rate:Double,
    private var isEmpty: Boolean,
    private var paymentType:String
        )