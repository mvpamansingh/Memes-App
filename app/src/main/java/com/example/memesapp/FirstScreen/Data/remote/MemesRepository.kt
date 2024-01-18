package com.example.memesapp.FirstScreen.Data.remote

import com.example.memesapp.FirstScreen.Data.remote.model.Meme
import kotlinx.coroutines.flow.Flow


interface MemesRepository {

    suspend fun getAllMemesList(): Flow<Result<List<Meme>>>
}