package com.example.zanatbizkod.di

import com.example.zanatbizkod.repository.DobrokDatabase
import com.example.zanatbizkod.repository.service.SigningService
import com.example.zanatbizkod.util.Consts
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val dataStoreModule = module {
    single {
        DobrokDatabase.getDatabase(androidContext())
    }
    single {
        get<DobrokDatabase>().dailyMenuItemDao()
    }
    single {
        val logging = HttpLoggingInterceptor()
        logging.setLevel(HttpLoggingInterceptor.Level.BASIC)

        val client = OkHttpClient.Builder()
            .addInterceptor(logging)
            .build()

        Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(Consts.BASE_URL)
            .client(client)
            .build()
            .create(SigningService::class.java)
    }
}