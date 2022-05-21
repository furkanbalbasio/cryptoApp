package com.balbasio.cryptokotlin.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.balbasio.cryptokotlin.R
import com.balbasio.cryptokotlin.model.CryptoModel
import kotlinx.android.synthetic.main.row_layout.view.*
import okhttp3.internal.http2.Http2Connection

class RecyclerViewAdapter(private val cryptoList:ArrayList<CryptoModel>): RecyclerView.Adapter<RecyclerViewAdapter.RowHolder>() {
    class RowHolder(view: View):RecyclerView.ViewHolder(view){

        fun bind(cryptoModel: CryptoModel){
            itemView.text_price.text=cryptoModel.price
            itemView.text_name.text=cryptoModel.currency

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RowHolder {
val view=LayoutInflater.from(parent.context).inflate(R.layout.row_layout,parent,false)
    return RowHolder(view)
    }

    override fun onBindViewHolder(holder: RowHolder, position: Int) {
holder.bind(cryptoList[position])
    }

    override fun getItemCount(): Int {
return cryptoList.count()   }
}