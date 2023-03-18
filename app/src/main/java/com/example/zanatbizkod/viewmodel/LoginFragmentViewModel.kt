package com.example.zanatbizkod.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.zanatbizkod.model.dto.LoginResponseDTO
import com.example.zanatbizkod.model.login.LoginRequest
import com.example.zanatbizkod.repository.loginrepository.LoginRepository
import kotlinx.coroutines.launch

class LoginFragmentViewModel(
    private val repository: LoginRepository
) : ViewModel() {

    var loginLiveData: MutableLiveData<LoginResponseDTO?> = MutableLiveData()

    fun sendLoginInformation(username: String, password: String) {
        viewModelScope.launch {
            repository.runCatching {
                passLoginInformation(LoginRequest(username, password))
            }.mapCatching {
                //loginLiveData.value = it
            }.onFailure {
                //loginLiveData.value = null
            }
        }
    }
}