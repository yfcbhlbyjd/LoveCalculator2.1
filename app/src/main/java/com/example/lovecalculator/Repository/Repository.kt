package com.geektech.lovecalculator.Repository

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.geektech.lovecalculator.Model.LoveModel
import com.geektech.lovecalculator.Network.LoveApi
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class Repository @Inject constructor(private val api: LoveApi){
    fun getMutableLiveDataOfLoveModel(
        firstName: String,
        secondName: String
    ): MutableLiveData<LoveModel> {
        val liveLoveModel: MutableLiveData<LoveModel> = MutableLiveData()

        api.getPercentage(firstName, secondName).enqueue(object : Callback<LoveModel> {
            override fun onResponse(call: Call<LoveModel>, response: Response<LoveModel>) {
                if (response.isSuccessful) {
                    response.body()?.let {
                        liveLoveModel.postValue(it)
                    }
                }
            }

            override fun onFailure(call: Call<LoveModel>, t: Throwable) {
                Log.e("ololo", "onFailure: ${t.message.toString()}")
            }
        })
        return liveLoveModel
    }
}