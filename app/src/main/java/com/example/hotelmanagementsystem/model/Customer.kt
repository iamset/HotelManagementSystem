package com.example.hotelmanagementsystem.model

data class Customer (
    private var firstName:String,
    private var lastName:String,
    private var phoneNumber:String,
    private var amountOwed: Int,
    private var feedback:String
)