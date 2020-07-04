package com.example.krishna.activitydetails

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.krishna.R
import kotlinx.android.synthetic.main.activity_a.*

class A : BaseActivity() {
    val tag :String ="A - Activity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_a)
        Log.d(tag," onCreate")
        var userData=UserData("SALEELKHAN",33)
        A_TXT.setOnClickListener {
            var i = Intent(this@A,B::class.java)
            i.putExtra("name","HGK")
            i.putExtra("Age",22)
            i.putExtra("UserDetails",userData)
            startActivityForResult(i,102)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode == 102 ){
            Log.d(tag,"onActivityResult" +  data?.getStringExtra("MESSAGE"))
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
