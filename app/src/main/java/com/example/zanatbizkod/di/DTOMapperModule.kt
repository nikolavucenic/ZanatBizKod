package com.example.zanatbizkod.di

import com.example.zanatbizkod.dtomappers.ApiResponseDTOMapper
import com.example.zanatbizkod.repository.mapper.logindtomapper.LoginResponseDTOMapper
import com.example.zanatbizkod.repository.mapper.signupdtomappers.SignUpRequestLegalEntityDTOMapper
import com.example.zanatbizkod.repository.mapper.signupdtomappers.SignUpRequestPrivatePersonDTOMapper
import org.koin.dsl.module

val dtoMapperModule = module {
    single {
        LoginResponseDTOMapper()
    }
    single {
        SignUpRequestPrivatePersonDTOMapper()
    }
    single {
        SignUpRequestLegalEntityDTOMapper()
    }
    single {
        ApiResponseDTOMapper()
    }
    /*
    single {
        OrderNextTenDaysResponseDTOMapper(get())
    }
    single {
        MealDTOMapper()
    }
    single {
        ChangeableIngredientsDTOMapper()
    }
    single {
        DailyMenuItemResponseDTOMapper(get(), get(), get())
    }
    single {
        MealFlagsDTOMapper()
    }
    single {
        NutritionalValueDTOMapper()
    }
    single {
        RealizationsDTOMapper(get())
    }
    single {
        GetByDateResponseDTOMapper()
    }
    single {
        MealOrderOverviewDTOMapper(get())
    }
    single {
        OrderedMealsDTOMapper()
    }
    single {
        DailyMenuItemResponseToDailyMenuItemEntityDTOMapper()
    }
    single {
        MealFlagsDTOToMealFlagsEntityMapper()
    }
    single {
        IngredientsDTOToIngredientsEntityMapper()
    }
    single {
        RealizationsDTOToRealizationsEntityMapper()
    }
    single {
        NutritionalValueDTOToNutritionalValueEntityMapper()
    }
    single {
        DailyMenuItemDTOToDailyMenuItemResponseDTOMapper(get(), get(), get())
    }
    single {
        MealFlagsEntityToMealFlagsDTOMapper()
    }
    single {
        IngredientsEntityToIngredientsDTOMapper()
    }
    single {
        RealizationsEntityToRealizationsDTOMapper(get(),get())
    }
    single {
        NutritionalValueEntityToNutritionalValueDTOMapper()
    }
    single {
        OrderRequestDTOToOrderEntityMapper()
    }
    single {
        DeliveryTimesResponseToDTOMapper()
    }*/
}