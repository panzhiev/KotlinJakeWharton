package com.tim.kotlinjakewharton.model.api

import com.tim.kotlinjakewharton.model.data.JakeWhartonReposInfo
import retrofit2.http.GET
import retrofit2.http.Path
import rx.Observable

interface ApiInterface {

    @GET("users/{username}/repos")
    fun getListReposJakeWharton(@Path("username") username: String): Observable<List<JakeWhartonReposInfo>>
}
