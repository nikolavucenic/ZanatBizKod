package com.example.zanatbizkod.repository.loginrepository

import android.content.Context
import android.view.View
import com.example.zanatbizkod.model.login.LoginRequest

interface LoginRepository {

    suspend fun passLoginInformation(loginRequest: LoginRequest, context: Context, view: View): String?

}