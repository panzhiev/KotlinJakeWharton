package com.tim.kotlinjakewharton.model.api

import com.google.gson.GsonBuilder
import com.tim.kotlinjakewharton.tools.BASE_URL
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class ApiModule {

    fun apiInterface(): ApiInterface{
        val gson = GsonBuilder()
                .setLenient()
                .create()

        val retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .baseUrl(BASE_URL)
                .build()

        return retrofit.create(ApiInterface::class.java)
    }

}
