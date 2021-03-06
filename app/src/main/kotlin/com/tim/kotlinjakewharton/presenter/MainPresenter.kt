package com.tim.kotlinjakewharton.presenter

import com.tim.kotlinjakewharton.model.Model
import com.tim.kotlinjakewharton.tools.T
import com.tim.kotlinjakewharton.view.activities.MainActivity
import rx.Observable
import rx.Subscription
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers

/**
 * Created by TIM on 22.07.2017.
 */
class MainPresenter(var activity: MainActivity) : IPresenter {

    private var subscription: Subscription? = null

    override fun getData() {
        subscription = Model().getReposList()
                .flatMap { list -> Observable.from(list) }        
                .map { obj -> obj.name }                          
                .filter { s -> !s.toUpperCase().startsWith(T) }   
                .toList()                                       
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ s -> activity.setData(s as ArrayList<String>) },
                        { e -> activity.showException(e) })
    }

    override fun onUnsubscribe() {
        if (subscription != null && !subscription!!.isUnsubscribed)
            subscription!!.unsubscribe()
    }
}
