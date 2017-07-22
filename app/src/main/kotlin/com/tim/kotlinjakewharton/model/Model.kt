package com.tim.kotlinjakewharton.model

import com.tim.kotlinjakewharton.model.api.ApiModule
import com.tim.kotlinjakewharton.model.data.JakeWhartonReposInfo
import com.tim.kotlinjakewharton.tools.USERNAME
import rx.Observable

/**
 * Created by TIM on 22.07.2017.
 */
class Model : IModel {

    override fun getReposList(): Observable<List<JakeWhartonReposInfo>> {
        return ApiModule().apiInterface.getListReposJakeWharton(USERNAME)
    }
}