package com.example.herokotlin.presenters

import com.example.herokotlin.views.MainView

class MainPresenter(override var mvpView: MainView) : BasePresenter(mvpView) {

    fun makeApiCall () {
        mvpView.success("Yes it is a success!")
    }


}