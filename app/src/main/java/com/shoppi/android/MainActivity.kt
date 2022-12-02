package com.shoppi.android

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

private const val TAG = "MainActivity"

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    // 공통적으로 어떠한 이벤트를 알려주는 메소드일 경우에는 Android SDK는 on + 메소드 이름으로 되어있다
    override fun onRestart() {
        super.onRestart()
        Log.e(TAG, "onReStart")
    }

    override fun onStart() {
        super.onStart()
        Log.e(TAG, "onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.e(TAG, "onResume")
    }

}