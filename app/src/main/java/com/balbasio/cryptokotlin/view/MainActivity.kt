package com.balbasio.cryptokotlin.view

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.balbasio.cryptokotlin.R
import com.balbasio.cryptokotlin.adapter.RecyclerViewAdapter
import com.balbasio.cryptokotlin.model.CryptoModel
import com.balbasio.cryptokotlin.service.CryptoAPI
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
class   MainActivity: AppCompatActivity() {
    private val BASE_URL="https://raw.githubusercontent.com"
    private var cryptoModels:ArrayList<CryptoModel>? =null
    //https://raw.githubusercontent.com/atilsamancioglu/K21-JSONDataSet/master/crypto.json
private var recyclerViewAdapter:RecyclerViewAdapter?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
val layoutManager: RecyclerView.LayoutManager=LinearLayoutManager(this)
recyclerView.layoutManager=layoutManager
loadData()
}
    private fun loadData(){
        val retrofit=Retrofit.Builder().baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        val service=retrofit.create(CryptoAPI::class.java)
        val call=service.getData()
        call.enqueue(object :Callback<List<CryptoModel>>{
            override fun onResponse(
                call: Call<List<CryptoModel>>,
                response: Response<List<CryptoModel>>
            ) {
if (response.isSuccessful){
    response.body()?.let {
        cryptoModels=ArrayList(it)
recyclerViewAdapter=RecyclerViewAdapter(cryptoModels!!)
 recyclerView.adapter=recyclerViewAdapter!!                                                                        }}}
            override fun onFailure(call: Call<List<CryptoModel>>, t: Throwable) {
t.printStackTrace()
            }
        })
    }

}