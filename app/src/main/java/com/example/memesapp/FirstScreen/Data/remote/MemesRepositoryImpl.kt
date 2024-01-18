package com.example.memesapp.FirstScreen.Domain.Repository

import android.net.http.HttpException
import android.os.Build
import androidx.annotation.RequiresExtension
import com.example.memesapp.FirstScreen.Data.remote.Api
import com.example.memesapp.FirstScreen.Data.remote.model.Meme
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import okio.IOException
import javax.inject.Inject


class MemesRepositoryImpl @Inject constructor(
    private val api: Api
) : MemesRepository {





    @RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
    override suspend fun getAllMemesList(): Flow<Result<List<Meme>>> {


        return flow {
            val productsFromApi = try{
                api.getMemesList()
            }
            catch (e: IOException)
            {
                e.printStackTrace()
                emit(Result.Error)
                return@flow
            }
            catch (e:HttpException)
            {
                e.printStackTrace()
                emit(Result.Error(message = "Error loading the products HTTP"))
                return@flow
            }
            catch (e:Exception)
            {
                e.printStackTrace()
                emit(Result.Error(message = "Error loading the products Random"))
                return@flow
            }

            emit(Result.Success(productsFromApi.memes))  // productFromApi will return / contain all the 4 types like{ product , lmit, ski
        }
    }
   // Error(message = "Error loading the products IO ")

}

















