package com.example.zanatbizkod.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class HomeFragmentViewModel(
    //private val repository: HomeRepository
) : ViewModel() {

    var homeLiveData: MutableLiveData<Boolean?> = MutableLiveData()

    /*fun sendLoginInformation(username: String, password: String) {
        viewModelScope.launch {
            repository.runCatching {
                passLoginInformation(LoginRequest(username, password))
            }.mapCatching {
                loginLiveData.value = it
            }.onFailure {
                loginLiveData.value = null
            }
        }
    }*/
}