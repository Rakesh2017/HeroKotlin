package com.example.herokotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.herokotlin.presenters.BasePresenter
import com.example.herokotlin.presenters.MainPresenter

abstract class MvpActivity<P : BasePresenter> : AppCompatActivity() {

   lateinit var mvpPresenter:P

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mvpPresenter = createPresenter()

    }

    abstract fun createPresenter(): P

    override fun onDestroy() {
        super.onDestroy()
    }


}