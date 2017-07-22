package com.tim.kotlinjakewharton.ui.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.tim.kotlinjakewharton.R

/**
 * Created by TIM on 21.07.2017.
 */
class ListViewAdapter(context: Context, private val list: ArrayList<String>) : BaseAdapter() {

    val mInflator: LayoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View? {
        var view: View? = convertView
        if (view == null) {
            view = mInflator.inflate(R.layout.item, parent, false)
        }

        var tv: TextView? = view?.findViewById(R.id.tv_name_repo) as TextView?
        tv?.text = list[position]

        return view
    }

    override fun getItem(position: Int): Any {
        return list[position].hashCode()
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getCount(): Int {
        return list.size
    }
}