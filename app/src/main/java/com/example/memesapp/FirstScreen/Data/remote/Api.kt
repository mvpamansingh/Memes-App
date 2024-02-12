package com.example.memesapp.FirstScreen.Data.remote

import com.example.memesapp.FirstScreen.Data.remote.model.Data
import com.example.memesapp.FirstScreen.Data.remote.model.Memes
import retrofit2.http.GET


interface Api {

    @GET("get_memes")
    suspend fun getMemesList(): Memes

    companion object{



        const val BASE_URL = "https://api.imgflip.com/"
    }
}