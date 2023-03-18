package com.example.zanatbizkod.repository

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "daily_menu_item")
data class DailyMenuItem(
    @PrimaryKey
    val mealId: Int,
    @ColumnInfo(name = "meal_name")
    val mealName: String,
    @ColumnInfo(name = "description")
    val description: String,
    @ColumnInfo(name = "image_name")
    val imageName: String,
    @ColumnInfo(name = "likes")
    val likes: Int,
    @ColumnInfo(name = "is_liked")
    val isLiked: Boolean,
    @ColumnInfo(name = "ingredients")
    val ingredients: String,
    @ColumnInfo(name = "meal_type")
    val mealType: Int,
    @ColumnInfo(name = "orders_count")
    val ordersCount: Int,
    @ColumnInfo(name = "period_type")
    val periodType: Int,
)
