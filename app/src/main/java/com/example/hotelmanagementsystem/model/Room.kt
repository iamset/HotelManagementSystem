package com.example.hotelmanagementsystem.model

class Room (
     var number:Int,
     var rate:Double,
     var isBooked: Boolean,
     var numOfBeds: Int,
     var image: String
){
    companion object{
        val rooms: ArrayList<Room> = arrayListOf(
            Room(1, 300.0, false, 3, "https://www.hotelbusiness.com/wp-content/uploads/2020/07/190131_05_dish-business_hotel_business-man_2_1886_HighRes-CMYK_stock-1-scaled.jpg"),
            Room(2, 100.0, false, 1, "https://media.cntraveler.com/photos/56799015c2ebbef23e7d927b/master/pass/Hotelroom-Alamy.jpg"),
            Room(3, 250.0, false, 2, "https://static01.nyt.com/images/2019/03/24/travel/24trending-shophotels1/24trending-shophotels1-superJumbo.jpg"),
            Room(4, 590.0, true, 2, "https://static01.nyt.com/images/2019/03/24/travel/24trending-shophotels1/24trending-shophotels1-superJumbo.jpg")
        )

//        val bookedRooms:ArrayList<Room> = arrayListOf(
//            Room(1, 300.0, true, 3, "https://www.hotelbusiness.com/wp-content/uploads/2020/07/190131_05_dish-business_hotel_business-man_2_1886_HighRes-CMYK_stock-1-scaled.jpg"),
//            Room(2, 100.0, false, 1, "https://media.cntraveler.com/photos/56799015c2ebbef23e7d927b/master/pass/Hotelroom-Alamy.jpg"),
//            Room(3, 250.0, false, 2, "https://static01.nyt.com/images/2019/03/24/travel/24trending-shophotels1/24trending-shophotels1-superJumbo.jpg")
//        )

//

    }


}