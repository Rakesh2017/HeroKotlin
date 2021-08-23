package com.example.herokotlin.fragments

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.herokotlin.R

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class MainFragment2 : Fragment() {

    private var param1: String? = null
    private var param2: String? = null
    lateinit var textView2: TextView

    override fun onAttach(context: Context) {
        super.onAttach(context)
        Log.d("test2z", "Fragment 2 onattach(): $context")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
        Log.d("test2z", "Fragment 2 onCreated")
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.d("test2z", "Fragment 2 onCreateView")
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main2, container, false)

    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            MainFragment2().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d("test2z", "Fragment 2 onViewCreated")
        textView2 = view.findViewById<TextView>(R.id.textView2)
        view.findViewById<TextView>(R.id.textView).setOnClickListener {
            Log.d("test2z", "Fragment 2 clicked textview")
            textView2.setText("text changed")
        }
    }

    override fun onViewStateRestored(savedInstanceState: Bundle?) {
        super.onViewStateRestored(savedInstanceState)
        Log.d("test2z", "Fragment 2 onViewStateRestored: $savedInstanceState")
    }

    override fun onStart() {
        super.onStart()
        Log.d("test2z", "Fragment 2 onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d("test2z", "Fragment 2 onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d("test2z", "Fragment 2 onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d("test2z", "Fragment 2 onStop")
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString("textview2", textView2.text.toString())
        Log.d("test2z", "Fragment 2 onSaveInstanceState: $outState")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Log.d("test2z", "Fragment 2 onDestroyView")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("test2z", "Fragment 2 onDestroy")
    }

    override fun onDetach() {
        super.onDetach()
        Log.d("test2z", "Fragment 2 onDetach")
    }

}