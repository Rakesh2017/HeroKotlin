package com.example.herokotlin.presenters

import com.example.herokotlin.views.MainView

open class BasePresenter(open var mvpView: MainView) {

    fun globalApiCall() {
        mvpView.success("Global success too!!")
    }

}