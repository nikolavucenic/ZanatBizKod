package com.example.zanatbizkod

import android.app.Application
import com.example.zanatbizkod.di.dataStoreModule
import com.example.zanatbizkod.di.dtoMapperModule
import com.example.zanatbizkod.di.repositoryModule
import com.example.zanatbizkod.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class MyApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@MyApplication)
            modules(listOf(repositoryModule, viewModelModule, dtoMapperModule, dataStoreModule))
        }
    }
}