package com.example.memesapp.FirstScreen.Presentation

import com.example.memesapp.FirstScreen.Data.remote.model.Meme


data class FirstScreenState(

    val memesList: List<Meme> = emptyList(),
    val searchQuery:String= "",
    val memeId:Int?= null
)