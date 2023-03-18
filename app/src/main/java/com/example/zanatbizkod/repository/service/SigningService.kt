package com.example.zanatbizkod.repository.service

import com.example.zanatbizkod.model.signupdtos.SignUpRequestPrivatePersonDTO
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

object SigningService {

    fun signUpPrivatePerson(signUpRequestPrivatePersonDTO: SignUpRequestPrivatePersonDTO) {
        val database = Firebase.database
        val myRef = database.getReference("PrivatePerson")

        myRef.setValue(signUpRequestPrivatePersonDTO)
    }

}