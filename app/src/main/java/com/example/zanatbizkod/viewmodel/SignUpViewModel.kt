package com.example.zanatbizkod.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.zanatbizkod.model.signup.SignUpRequestLegalEntity
import com.example.zanatbizkod.model.signup.SignUpRequestPrivatePerson
import com.example.zanatbizkod.repository.signuprepository.SignUpRepository
import kotlinx.coroutines.launch

class SignUpFragmentViewModel(
    private val repository: SignUpRepository
) : ViewModel() {

    var signUpLiveData: MutableLiveData<Boolean?> = MutableLiveData()

    fun sendSignUpInformationPrivatePerson(
        email: String, password: String, phoneNumber: String, firstName: String, lastName: String
    ) {
        viewModelScope.launch {
            repository.runCatching {
                passSignUpInformationPrivatePerson(
                    SignUpRequestPrivatePerson(
                        email,
                        password,
                        phoneNumber,
                        firstName,
                        lastName,
                    )
                )
            }.mapCatching {
                signUpLiveData.value = it
            }.onFailure {
                signUpLiveData.value = null
            }
        }
    }

    fun sendSignUpInformationLegalEntity(
        name: String, tin: String, companyNumber: String, phoneNumber: String, email: String
    ) {
        viewModelScope.launch {
            repository.runCatching {
                passSignUpInformationLegalEntity(
                    SignUpRequestLegalEntity(
                        name,
                        tin,
                        companyNumber,
                        phoneNumber,
                        email,
                    )
                )
            }.mapCatching {
                signUpLiveData.value = it
            }.onFailure {
                signUpLiveData.value = null
            }
        }
    }
}