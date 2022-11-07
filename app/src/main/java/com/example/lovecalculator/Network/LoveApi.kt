package com.geektech.lovecalculator.Network


import com.geektech.lovecalculator.Model.LoveModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface LoveApi {
    @GET("getPercentage")
    fun getPercentage(
        @Query("fname")
        firstName: String,
        @Query("sname")
        secondName: String,
        @Header("X-RapidAPI-Key") key: String = "7897cefdb8msety39bbc091e85641135a7jsn0uHdd39e26yr7",
        @Header("X-RapidAPI-Host") host: String = "love-calculator.p.rapidapi.com"
    ): Call<LoveModel>
}
