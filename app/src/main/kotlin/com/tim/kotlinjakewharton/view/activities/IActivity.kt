package com.tim.kotlinjakewharton.view.activities

/**
 * Created by TIM on 22.07.2017.
 */
interface IActivity {
    fun setData(list: ArrayList<String>)
    fun showException(e: Throwable)
}