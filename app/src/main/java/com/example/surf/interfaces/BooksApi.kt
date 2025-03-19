package com.example.surf.interfaces

object BooksApi{
    val retrofitService: BooksApiService by lazy{
        retrofit.create(BooksApiService::class.java)
    }
}