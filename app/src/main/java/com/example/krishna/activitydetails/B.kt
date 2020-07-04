package com.example.krishna.activitydetails

import android.R.id.message
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.krishna.R
import kotlinx.android.synthetic.main.activity_b.*


class B : BaseActivity() {
    val tag :String ="B - Activity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_b)
        Log.d(tag," onCreate")
        val data =intent
        Log.d(tag," onCreate - "+ data.extras?.getString("name"))
        Log.d(tag," onCreate - "+data.extras?.getString("Age"))
       val user =  data.extras?.getParcelable<UserData>("UserDetails")
        Log.d(tag," onCreate - "+user?.name)
        BTxt.setOnClickListener {
            startActivity(Intent(this@B,C::class.java))
//            val intent = Intent()
//            intent.putExtra("MESSAGE", "HELLOOOO")
//            setResult(102, intent)
//            finish() //finishing activity

        }
    }
    override fun onStart() {
        super.onStart()
        Log.d(tag," onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d(tag," onResume")
        getNumberOfTasks()
    }

    override fun onPause() {
        super.onPause()

//        finish()
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
