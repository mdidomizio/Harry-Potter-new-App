package com.example.harrypotterappnew

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import java.lang.Exception

class HarryPotterViewModel : ViewModel() {
    private val repository = HarryPotterRepository()
    private val _harryPotterData = MutableLiveData<List<HarryPotterData>>()
    val harryPotterData: LiveData<List<HarryPotterData>> = _harryPotterData

    fun fetchHarryPotterApi(){
        viewModelScope.launch {
            try {
                val data = repository.getHarryPotterData()
                _harryPotterData.value = data
            } catch (e: Exception) {
                //handle error
            }
        }
    }
}