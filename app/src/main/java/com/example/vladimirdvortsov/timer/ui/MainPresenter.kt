package com.example.vladimirdvortsov.timer.ui

import android.os.Handler
import android.os.Looper
import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import com.example.vladimirdvortsov.timer.api.ServerClient
import com.google.gson.JsonObject
import io.reactivex.Observable
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import java.util.concurrent.TimeUnit


@InjectViewState
class MainPresenter : MvpPresenter<MvpViewTimer>() {
    init {
        viewState.updateTimer(0)
        onCreate()
    }

    private fun updateView(count: Int) {
        Handler(Looper.getMainLooper()).post {
            viewState.updateTimer(count)
        }
    }

    private fun send(count: Int) {
        val createJson = JsonObject()
        createJson.addProperty("timer", count)
        ServerClient().getClient().postTimer(createJson)
    }

    private fun onCreate() {
        var count = 0
        val timerDisposable: Disposable = Observable
            .interval(1, TimeUnit.SECONDS, Schedulers.io())
            .subscribe(
                { onNext ->
                    updateView(count)
                    count++
                    if (count % 30 == 0) {
                        send(count)
                    }
                },
                { onError ->

                })

    }

}
