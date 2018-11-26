package com.example.vladimirdvortsov.timer.ui

import android.os.Bundle
import com.arellomobile.mvp.MvpAppCompatActivity
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.PresenterType
import com.example.vladimirdvortsov.timer.R
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : MvpViewTimer, MvpAppCompatActivity() {

    @InjectPresenter(type = PresenterType.GLOBAL)
    lateinit var mainPresenter: MainPresenter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun updateTimer(time: Int) {
        //   super.updateTimer(time)
        timer.text = time.toString()
    }

}
