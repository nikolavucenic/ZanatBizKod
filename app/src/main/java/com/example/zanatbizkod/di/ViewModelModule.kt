package com.example.zanatbizkod.di

import com.example.zanatbizkod.viewmodel.LoginFragmentViewModel
import com.example.zanatbizkod.viewmodel.SignUpFragmentViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel {
        LoginFragmentViewModel(get())
    }
    viewModel {
        SignUpFragmentViewModel(get())
    }
    /*viewModel {
        ResetPasswordFragmentViewModel(get())
    }
    viewModel {
        HomeFragmentViewModel(get())
    }
    viewModel {
        OrderFragmentViewModel(get())
    }
    viewModel {
        OrderOverviewFragmentViewModel(get())
    }*/
}