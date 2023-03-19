package com.example.zanatbizkod.repository

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(
    entities = [
        DailyMenuItem::class,
        /*MealFlags::class,
        DailyMenuItemMealFlagsCrossRef::class,*/
        //ChangeableIngredients::class,
        //DailyMenuItemIngredientsCrossRef::class,
        /*Realizations::class,
        DailyMenuItemRealizationsCrossRef::class,
        NutritionalValue::class,
        RealizationsNutritionalValueCrossRef::class,
        Order::class*/],
    version = 1,
    exportSchema = true,
)
abstract class ZanatDatabase : RoomDatabase() {

    abstract fun dailyMenuItemDao(): DailyMenuItemDao

/*    abstract fun orderDao(): OrderDao*/

    companion object {
        fun getDatabase(context: Context): ZanatDatabase =
            Room.databaseBuilder(
                context,
                ZanatDatabase::class.java,
                "dobrok.db"
            ).build()
    }

}