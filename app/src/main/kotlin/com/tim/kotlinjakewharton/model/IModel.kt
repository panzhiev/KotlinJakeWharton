package com.tim.kotlinjakewharton.model

import com.tim.kotlinjakewharton.model.data.JakeWhartonReposInfo
import rx.Observable

/**
 * Created by TIM on 22.07.2017.
 */
interface IModel {
    fun getReposList(): Observable<List<JakeWhartonReposInfo>>
}