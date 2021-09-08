package com.example.herokotlin

import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.fragment.app.*
import com.example.herokotlin.fragments.MainFragment1
import com.example.herokotlin.fragments.MainFragment2
import com.example.herokotlin.presenters.MainPresenter
import com.example.herokotlin.views.MainView

class MainActivity : MvpActivity<MainPresenter>(), MainView {

    lateinit var frag1: Button
    lateinit var frag2: Button
    lateinit var fragmentManager: FragmentManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            fragmentManager = supportFragmentManager
        }

        frag1 = findViewById(R.id.frag1)
        frag2 = findViewById(R.id.frag2)


        frag1.setOnClickListener {
            fragmentManager.commit {
                setReorderingAllowed(true)
                replace<MainFragment1>(R.id.fragment_container, "fragment1")
            }
        }

        frag2.setOnClickListener {
            fragmentManager.commit {
                setReorderingAllowed(true)
                replace<MainFragment2>(R.id.fragment_container, "fragment2")
            }
        }
    }

    override fun success(message: String) {
        Log.d("test2x", "msg: $message")
    }

    override fun fail(message: String) {

    }

    override fun createPresenter(): MainPresenter {
        return MainPresenter(this)
    }

    override fun onBackPressed() {
        val arrayList = fragmentManager.fragments

        for (item in arrayList) {
            val fragment: Fragment? = fragmentManager.findFragmentByTag(item.tag)
            if (fragment != null) {
                fragmentManager.commit {
                    remove(fragment)
                }
            }
        }

        if (arrayList.size == 0) {
            finish()
        }

        Log.d("test2x", "list: $arrayList")
    }

}