package com.example.memesapp.navigation


sealed class NavigationRoutes(val routes:String) {
    object FirstScree:NavigationRoutes("first_screen")
    object DetailsScreen:NavigationRoutes("details_screen")

}