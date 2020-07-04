package com.example.krishna.activitydetails

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.krishna.R
import kotlinx.android.synthetic.main.activity_c.*
import kotlinx.android.synthetic.main.activity_d.*

class D : AppCompatActivity() {
    val tag :String ="D - Activity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_d)
        DTxt.setOnClickListener {
            startActivity(Intent(this@D,B::class.java))
        }
    }
    override fun onStart() {
        super.onStart()
        Log.d(tag," onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d(tag," onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d(tag," onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d(tag," onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(tag," onDestroy")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(tag," onRestart")
    }
}
