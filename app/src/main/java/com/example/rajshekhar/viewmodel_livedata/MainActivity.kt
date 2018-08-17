package com.example.rajshekhar.viewmodel_livedata

import android.arch.lifecycle.LiveData
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModelProvider
import org.jetbrains.annotations.Nullable
import java.util.*
import android.arch.lifecycle.ViewModelProviders
import android.graphics.Color
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.View
import android.widget.Toast
import org.w3c.dom.Text


class MainActivity : AppCompatActivity() {
    private var mModel: NameViewModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // Other code to setup the activity...

        mModel = ViewModelProviders.of(this).get(NameViewModel::class.java)

        val colorObserver =object :android.arch.lifecycle.Observer<Int>{
            override fun onChanged(t: Int?) {
                textView.setTextColor(t!!)
            }

        }

        // Create the observer which updates the UI.
        val nameObserver = object : android.arch.lifecycle.Observer<String> {
            override fun onChanged(newName: String?) {
                // Update the UI, in this case, a TextView.
                val newName = "RajShekhar"
                textView.setText(newName)
            }
        }

        button.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View) {
                val newName = ""
                mModel!!.currentName.setValue(newName)
                mModel!!.colorChange.value = colorGet()

            }
        })

        // Observe the LiveData, passing in this activity as the LifecycleOwner and the observer.
        mModel!!.currentName.observe(this, nameObserver)
        mModel!!.colorChange.observe(this,colorObserver)
    }

    private fun colorGet(): Int? {
        val rnd=Random()
        return Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256))
    }
}

















