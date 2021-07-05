package com.example.hotelmanagementsystem.model

object Customer {
    lateinit var personalInfo:PersonalInfo
    lateinit var address: Address
    lateinit var additionalDetails:AdditionalDetails
}
data class PersonalInfo(
    var title:String,
    var firstName:String,
    var lastName:String,
    var inits:String?,
    var emailAddress:String,
    var gender:String,
)
data class Address(
    var companyName:String? = "null",
    var address:String = "null",
    var city:String = "null",
    var postalCode:String = "null",
    var country:String = "null",
    var dayTimePhone:String = "null",
    var mobilePhone:String? = "null"
)

data class AdditionalDetails(
    var reasonForVisit:String?,
    var comments:String?
)