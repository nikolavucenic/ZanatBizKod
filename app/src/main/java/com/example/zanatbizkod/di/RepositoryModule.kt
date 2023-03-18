package com.example.zanatbizkod.di

import com.example.zanatbizkod.repository.loginrepository.LoginRepository
import com.example.zanatbizkod.repository.loginrepository.LoginRepositoryImpl
import org.koin.dsl.module

val repositoryModule = module {
    single<LoginRepository> {
        LoginRepositoryImpl(get(), get(), get())
    }
    /*single<SignUpRepository> {
        SignUpRepositoryImpl(get(), get(), get(), get())
    }
    single<ResetPasswordRepository> {
        ResetPasswordRepositoryImpl(get(), get())
    }
    single<HomeRepository> {
        HomeRepositoryImpl(get(), get(), get(), get(), get(), get(), get(), get(), get(), get(), get())
    }
    single<OrderRepository> {
        OrderRepositoryImpl(get(), get(), get(), get())
    }
    single<OrderOverviewRepository> {
        OrderOverviewRepositoryImpl(get(), get(), get(), get())
    }*/
}