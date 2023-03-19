package com.example.zanatbizkod.repository.service

import android.content.Context
import android.util.Log
import android.view.View
import com.example.zanatbizkod.R
import com.example.zanatbizkod.model.login.LoginRequest
import com.example.zanatbizkod.model.signup.SignUpRequestLegalEntity
import com.example.zanatbizkod.model.signup.SignUpRequestPrivatePerson
import com.example.zanatbizkod.model.signupdtos.SignUpRequestLegalEntityDTO
import com.example.zanatbizkod.model.signupdtos.SignUpRequestPrivatePersonDTO
import com.example.zanatbizkod.ui.snackbar
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.database.ktx.getValue
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

    fun login(loginRequest: LoginRequest, context: Context, view: View): String? =
        checkPrivatePerson(loginRequest, context, view)

    private fun checkPrivatePerson(loginRequest: LoginRequest, context: Context, view: View): String? {
        var user: String? = null
        FirebaseDatabase.getInstance().getReference("PrivatePerson").addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                for (childSnapshot in snapshot.children) {
                    childSnapshot.getValue<SignUpRequestPrivatePerson>()?.apply {
                        val email = email
                        val password = password
                        if(loginRequest.username == email) {
                            if(loginRequest.password == password) {
                                user = phoneNumber
                            } else {
                                context.getString(R.string.incorrect_password).snackbar(view)
                            }
                        }
                    }
                }
                if(user == null) {
                    user = checkLegalEntity(loginRequest, context, view)
                }
            }

            override fun onCancelled(error: DatabaseError) {
                Log.e("Firebase error", "Failed to read values")
            }
        })
        return user
    }

    private fun checkLegalEntity(loginRequest: LoginRequest, context: Context, view: View): String? {
        var user: String? = null
        FirebaseDatabase.getInstance().getReference("LegalEntity").addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                for (childSnapshot in snapshot.children) {
                    childSnapshot.getValue<SignUpRequestLegalEntity>()?.apply {
                        val email = email
                        val password = pib
                        if(loginRequest.username == email) {
                            if(loginRequest.password == password) {
                                user = phoneNumber
                            } else {
                                context.getString(R.string.incorrect_password).snackbar(view)
                            }
                        }
                    }
                }
                context.getString(R.string.email_doesnt_exist).snackbar(view)
            }

            override fun onCancelled(error: DatabaseError) {
                Log.e("Firebase error", "Failed to read values")
            }
        })
        return user
    }
}