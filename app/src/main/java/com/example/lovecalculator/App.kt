package com.example.lovecalculator

import android.app.Application
import androidx.room.Room
import com.example.lovecalculator.AppDataBase
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class App: Application() {



    override fun onCreate() {
        super.onCreate()

    }
}