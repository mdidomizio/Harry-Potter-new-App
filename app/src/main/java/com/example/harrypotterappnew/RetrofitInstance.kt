package com.example.harrypotterappnew

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
    private const val BASE_URL = "https://hp-api.onrender.com/api/"



    private val retrofit: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
    val harryPotterService: HarryPotterService by lazy {
        retrofit.create(HarryPotterService::class.java)
    }
}