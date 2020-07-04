package com.example.krishna.activitydetails

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.krishna.R
import kotlinx.android.synthetic.main.activity_b.*
import kotlinx.android.synthetic.main.activity_c.*

class C : AppCompatActivity() {
    val tag :String ="C - Activity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_c)
        CTxt.setOnClickListener {
            startActivity(Intent(this@C,D::class.java))
        }
        textView.setOnClickListener {
            startActivity(Intent(this@C,C::class.java))
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
