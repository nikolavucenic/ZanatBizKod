package com.example.zanatbizkod.di

import com.example.zanatbizkod.repository.DobrokDatabase
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
}