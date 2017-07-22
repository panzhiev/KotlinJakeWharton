package com.tim.kotlinjakewharton.view.adapters

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.tim.kotlinjakewharton.R
import kotlinx.android.synthetic.main.item_repository.view.*

/**
 * Created by TIM on 22.07.2017.
 */
class RecyclerViewAdapter(var context: Context, var list: ArrayList<String>)
    : RecyclerView.Adapter<RecyclerViewAdapter.MyHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        return MyHolder(LayoutInflater.from(context).inflate(R.layout.item_repository, parent, false))
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        holder.bindData(list[position])
    }

    override fun getItemCount(): Int {
        return  list.size
    }

    class MyHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bindData(name: String) {
            itemView.tv_name_repo.text = name
        }
    }
}