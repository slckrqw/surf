package com.example.surf.api

object BooksApi{
    val retrofitService: BooksApiService by lazy{
        retrofit.create(BooksApiService::class.java)
    }
}