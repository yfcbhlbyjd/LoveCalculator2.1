package com.example.lovecalculator

import android.content.Context
import com.example.lovecalculator.model.LoveApi
import com.example.lovecalculator.room.AppDataBase
import com.example.lovecalculator.room.LoveDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    fun provideApi():LoveApi{
        return Retrofit.Builder().baseUrl("https://love-calculator.p.rapidapi.com/")
            .addConverterFactory(GsonConverterFactory.create()).build()
            .create(LoveApi::class.java)
    }
    @Provides
    fun providePrefs(@ApplicationContext context: Context):Prefs{
        return Prefs(context)
    }

}