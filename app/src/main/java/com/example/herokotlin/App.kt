package com.example.herokotlin

import android.app.Activity
import android.app.Application
import android.util.Log

class App: Application() {


    companion object {

        val list: ArrayList<Activity> = ArrayList()

        @JvmStatic
        public fun addActivity(activity: Activity) {
            list.add(activity)
            Log.d("test2x", "Add Activity: $list")
        }

        @JvmStatic
        public fun removeActivity(activity: Activity) {
            list.remove(activity)
            Log.d("test2x", "Remove Activity: $list")
        }
    }



}