package com.example.zanatbizkod.repository.service

import android.util.Log
import com.example.zanatbizkod.model.login.LoginRequest
import com.example.zanatbizkod.model.signup.SignUpRequestLegalEntity
import com.example.zanatbizkod.model.signup.SignUpRequestPrivatePerson
import com.example.zanatbizkod.model.signupdtos.SignUpRequestLegalEntityDTO
import com.example.zanatbizkod.model.signupdtos.SignUpRequestPrivatePersonDTO
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
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

    fun login(loginRequest: LoginRequest): Boolean {
        var loginResult = false
        if(!getPrivatePerson(loginRequest)) loginResult = getLegalEntity(loginRequest)

        return loginResult
    }

    private fun getPrivatePerson(loginRequest: LoginRequest): Boolean {
        var successfulLogin = false
        FirebaseDatabase.getInstance().getReference("PrivatePerson").addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                for (childSnapshot in snapshot.children) {
                    if(childSnapshot.getValue(SignUpRequestPrivatePerson::class.java)?.checkData(loginRequest) == true) {
                        successfulLogin = true
                    }
                }
            }

            override fun onCancelled(error: DatabaseError) {
                Log.e("Firebase error", "Failed to read values")
            }
        })
        return successfulLogin
    }

    private fun SignUpRequestPrivatePerson.checkData(loginData: LoginRequest): Boolean {
        if(this.email == loginData.username) {
            if(this.password == loginData.password) {
                return true
            }
        }
        return false
    }

    private fun SignUpRequestLegalEntity.checkData(loginData: LoginRequest): Boolean {
        if(this.email == loginData.username) {
            if(this.pib == loginData.password) {
                return true
            }
        }
        return false
    }

    private fun getLegalEntity(loginRequest: LoginRequest): Boolean {
        var successfulLogin = false
        FirebaseDatabase.getInstance().getReference("LegalEntity").addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                for (childSnapshot in snapshot.children) {
                    if(childSnapshot.getValue(SignUpRequestLegalEntity::class.java)?.checkData(loginRequest) == true) {
                        successfulLogin = true
                    }
                }
            }

            override fun onCancelled(error: DatabaseError) {
                Log.e("Firebase error", "Failed to read values")
            }
        })
        return successfulLogin
    }
}