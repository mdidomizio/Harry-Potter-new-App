package com.example.harrypotterappnew

import retrofit2.http.GET

interface HarryPotterService {

    @GET("characters")
    suspend fun getData(): List<HarryPotterData>
}