package com.example.memesapp.DI

import com.example.memesapp.FirstScreen.Data.remote.Api
import com.example.memesapp.FirstScreen.Data.remote.MemesRepository
import com.example.memesapp.FirstScreen.Data.remote.MemesRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@InstallIn(SingletonComponent::class)
@Module
class AppModule {


    @Provides
    @Singleton
    fun provideMemeRepository(api: Api): MemesRepository {
        return MemesRepositoryImpl(api)
    }


    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit {



        val interceptor = HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }

        val client = OkHttpClient.Builder().addInterceptor(interceptor).build()


        return Retrofit.Builder()
            .baseUrl(Api.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()
    }

    @Provides
    @Singleton
    fun provideMemeAPi(retrofit: Retrofit): Api {
        return retrofit.create(Api::class.java)
    }

}