package com.example.herokotlin.views

interface MainView {

    fun success(message: String): Unit
    fun fail(message: String): Unit

}