package com.geektech.lovecalculator.Room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.geektech.lovecalculator.Model.LoveModel

@Database(entities = [LoveModel::class], version = 1)
abstract class AppDataBase:RoomDatabase() {
    abstract fun historyDao():HistoryDao
}