package com.tim.kotlinjakewharton.view.activities

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import com.tim.kotlinjakewharton.R
import com.tim.kotlinjakewharton.presenter.IPresenter
import com.tim.kotlinjakewharton.presenter.MainPresenter
import com.tim.kotlinjakewharton.view.adapters.RecyclerViewAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), IActivity {

    private var mainPresenter: IPresenter = MainPresenter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mainPresenter.getData()
    }

    override fun setData(list: ArrayList<String>) {
        rv_names_repos.hasFixedSize()
        rv_names_repos.adapter = RecyclerViewAdapter(this, list)
    }

    override fun showException(e: Throwable) {
        Toast.makeText(this, e.toString(), Toast.LENGTH_LONG).show()
    }

    override fun onStop() {
        mainPresenter.onUnsubscribe()
        super.onStop()
    }
}
