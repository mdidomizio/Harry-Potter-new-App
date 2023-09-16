package com.example.harrypotterappnew

class HarryPotterRepository {
    private val harryPotterService = RetrofitInstance.harryPotterService

    suspend fun getHarryPotterData(): List<HarryPotterData> {
        return harryPotterService.getData()
    }
}