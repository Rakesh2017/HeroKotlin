package com.example.herokotlin

import android.os.Bundle
import android.util.Log
import android.widget.Button
import com.example.herokotlin.presenters.MainPresenter
import com.example.herokotlin.views.MainView

class MainActivity : MvpActivity<MainPresenter>(), MainView {

    lateinit var button: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button = findViewById(R.id.home)


        button.setOnClickListener {
           mvpPresenter.apply {
               this.makeApiCall()
               this.globalApiCall()
           }
        }


        val map: HashMap<String, String> = HashMap()
        

    }

    override fun success(message: String) {
       Log.d("test2x", "msg: $message")
    }

    override fun fail(message: String) {

    }

    override fun createPresenter(): MainPresenter {
        return MainPresenter(this)
    }

}