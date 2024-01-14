package com.example.harrypotterappnew

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import java.lang.Exception

class HarryPotterViewModel : ViewModel() {
    /*implementation done for the splashScreen*/
    private val _isReady = MutableStateFlow(false)
    val isReady = _isReady.asStateFlow()

    init {
        viewModelScope.launch {
            delay(1000)
            _isReady.value = true
        }
    }

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