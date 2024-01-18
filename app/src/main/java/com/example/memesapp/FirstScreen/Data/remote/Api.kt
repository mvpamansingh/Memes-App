package com.example.memesapp.FirstScreen.Data.remote

import com.example.memesapp.FirstScreen.Data.remote.model.Data
import retrofit2.http.GET


interface Api {

    @GET("get_memes")
    suspend fun getMemesList(): Data

    companion object{



        const val BASE_URL = "https://api.imgflip.com/"
    }
}