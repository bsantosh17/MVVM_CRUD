package com.example.mymvvm

import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("posts")
    fun getData(): Call<List<MyData>>
}