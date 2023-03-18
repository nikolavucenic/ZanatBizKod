package com.example.zanatbizkod.repository.service

import com.example.zanatbizkod.model.signupdtos.SignUpRequestLegalEntityDTO
import com.example.zanatbizkod.model.signupdtos.SignUpRequestPrivatePersonDTO
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

object SigningService {

    fun signUpPrivatePerson(signUpRequestPrivatePersonDTO: SignUpRequestPrivatePersonDTO): Boolean {
        val database = FirebaseDatabase.getInstance().getReference("PrivatePerson")
        var status = false
        database.child(signUpRequestPrivatePersonDTO.phoneNumber).setValue(signUpRequestPrivatePersonDTO).addOnSuccessListener {
            status = true
        }
        return status
    }

    fun signUpLegalEntity(signUpRequestLegalEntityDTO: SignUpRequestLegalEntityDTO): Boolean {
        val database = FirebaseDatabase.getInstance().getReference("LegalEntity")
        var status = false
        database.child(signUpRequestLegalEntityDTO.phoneNumber).setValue(signUpRequestLegalEntityDTO).addOnSuccessListener {
            status = true
        }
        return status
    }
}