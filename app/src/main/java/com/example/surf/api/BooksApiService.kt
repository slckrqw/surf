package com.example.surf.api

import com.example.surf.data.book_model.BooksResponse
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

private const val BASE_URL = "https://www.googleapis.com/"

val retrofit = Retrofit.Builder()
.addConverterFactory(GsonConverterFactory.create())
.baseUrl(BASE_URL)
.build()

interface BooksApiService{
    @GET("/books/v1/volumes")
    fun searchVolumes(@Query("q") query: String): Call<BooksResponse>
}