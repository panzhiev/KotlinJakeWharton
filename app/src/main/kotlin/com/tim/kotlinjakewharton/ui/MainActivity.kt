package com.tim.kotlinjakewharton.ui

import ApiModule
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.ListView
import android.widget.Toast
import com.tim.kotlinjakewharton.R
import com.tim.kotlinjakewharton.model.JakeWhartonReposInfo
import com.tim.kotlinjakewharton.ui.adapters.ListViewAdapter
import rx.Subscriber
import rx.Subscription
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers

class MainActivity : AppCompatActivity() {

    private var subscription: Subscription? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        getList()

    }

    fun getList() {
        subscription = ApiModule().apiInterface.listReposJakeWharton("JakeWharton")
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .map { list -> getRepoNames(list) }
                .subscribe(object : Subscriber<ArrayList<String>>() {
                    override fun onNext(list: ArrayList<String>) {
                        setData(list)
                    }

                    override fun onCompleted() {
                        //Completed
                    }

                    override fun onError(e: Throwable?) {
                        Toast.makeText(MainActivity(), e.toString(), Toast.LENGTH_LONG).show()
                    }
                })
    }

    fun getRepoNames(list: List<JakeWhartonReposInfo>): ArrayList<String> {
        var listWithoutT: ArrayList<String> = ArrayList()
        for (jakeWhartonRepoInfo in list) {

            var str: String = jakeWhartonRepoInfo.name
            if (!str.toUpperCase().startsWith("T"))
                listWithoutT.add(str)
        }
        return listWithoutT
    }

    fun setData(list: ArrayList<String>) {

        val listView = findViewById(R.id.lv_names_repos) as ListView
        listView.adapter = ListViewAdapter(this, list)
    }

    override fun onStop() {
        if (subscription != null) {
            if (!subscription!!.isUnsubscribed)
                subscription!!.unsubscribe()
        }
        super.onStop()
    }
}
