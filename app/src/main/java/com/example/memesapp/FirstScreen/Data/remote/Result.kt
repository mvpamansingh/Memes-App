package com.example.memesapp.FirstScreen.Data.remote




sealed class Result<T>(
    val data: T? = null,  // for successful fetching
    val message: String? = null  // for not successful , message to show to user
) {

    class Success<T> (data: T?): Result<T>(data)
    class Error<T> (data: T? = null, message: String): Result<T>(data, message)
}