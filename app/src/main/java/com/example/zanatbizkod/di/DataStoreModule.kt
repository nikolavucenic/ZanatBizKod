package com.example.zanatbizkod.di

import com.example.zanatbizkod.repository.ZanatDatabase
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val dataStoreModule = module {
    single {
        ZanatDatabase.getDatabase(androidContext())
    }
    single {
        get<ZanatDatabase>().dailyMenuItemDao()
    }
}