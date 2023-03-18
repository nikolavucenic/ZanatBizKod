package com.example.zanatbizkod.repository

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy

@Dao
interface DailyMenuItemDao {

    @Insert(entity = DailyMenuItem::class, onConflict = OnConflictStrategy.REPLACE)
    suspend fun addDailyMenuItem(dailyMenuItem: DailyMenuItem)
}