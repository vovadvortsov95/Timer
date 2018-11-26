package com.example.vladimirdvortsov.timer.ui

import com.arellomobile.mvp.MvpView

interface MvpViewTimer : MvpView{
    fun updateTimer(time : Int) {}

}