package com.example.finfit.data.db

import androidx.room.RoomDatabase

abstract class ExpenseDatabase : RoomDatabase() {
    abstract fun expenseDao(): ExpenseDao
}