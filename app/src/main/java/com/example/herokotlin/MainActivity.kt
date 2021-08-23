package com.example.herokotlin

import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.fragment.app.add
import androidx.fragment.app.commit
import androidx.fragment.app.replace
import com.example.herokotlin.fragments.MainFragment1
import com.example.herokotlin.fragments.MainFragment2
import com.example.herokotlin.presenters.MainPresenter
import com.example.herokotlin.views.MainView

class MainActivity : MvpActivity<MainPresenter>(), MainView {

    lateinit var frag1: Button
    lateinit var frag2: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fragment1: Fragment = MainFragment1()
        val fragment2: Fragment = MainFragment2()

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction().apply {
                add(R.id.fragment_container, fragment1)
                add(R.id.fragment_container, fragment2)
                hide(fragment2)
                commit()
                addToBackStack(null)
            }
        }

        frag1 = findViewById(R.id.frag1)
        frag2 = findViewById(R.id.frag2)

        App.addActivity(this)
        App.removeActivity(this)




        frag1.setOnClickListener {

            val fragment = supportFragmentManager.findFragmentById(R.id.fragment_container)

            Log.d("test2x", "Fragment: $fragment")

            supportFragmentManager.beginTransaction().apply {
                hide(fragment2)
                show(fragment1)
                commit()
            }


//            supportFragmentManager.beginTransaction().apply {
//                replace(R.id.fragment_container, fragment1)
//                commit()
//            }
        }

        frag2.setOnClickListener {

            supportFragmentManager.beginTransaction().apply {
                hide(fragment1)
                show(fragment2)
                commit()
            }

//            supportFragmentManager.beginTransaction().apply {
//                replace(R.id.fragment_container, fragment2)
//                commit()
//                addToBackStack(null)
//            }

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
        super.onBackPressed()
        if (supportFragmentManager.backStackEntryCount > 0) {
            for (fragment in supportFragmentManager.fragments) {
                if (fragment != null)
                supportFragmentManager.beginTransaction().remove(fragment).detach(fragment).commit()
            }
        }
        finish()
    }

}