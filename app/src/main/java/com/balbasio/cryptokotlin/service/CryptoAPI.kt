package com.balbasio.cryptokotlin.service

import android.telecom.Call
import com.balbasio.cryptokotlin.model.CryptoModel
import retrofit2.http.GET

interface CryptoAPI {
    //https://raw.githubusercontent.com/atilsamancioglu/K21-JSONDataSet/master/crypto.json
    @GET("atilsamancioglu/K21-JSONDataSet/master/crypto.json")
    fun getData():retrofit2.Call<List<CryptoModel>>
}