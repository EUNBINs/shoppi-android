package com.shoppi.android

import android.animation.ObjectAnimator
import android.animation.PropertyValuesHolder
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.animation.AnticipateInterpolator
import androidx.core.animation.doOnEnd
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView

private const val TAG = "MainActivity"

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 바텀아이콘 그라데이션 컬러 안먹어서 선언
        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.navigation_main)
        bottomNavigationView.itemIconTintList = null


        // navHost에서 destination을 관리하는 객체
        val navController = supportFragmentManager.findFragmentById(R.id.container_main)?.findNavController()
        navController?.let {
            bottomNavigationView.setupWithNavController(it)
        }
    }
    // 공통적으로 어떠한 이벤트를 알려주는 메소드일 경우에는 Android SDK는 on + 메소드 이름으로 되어있다
//    override fun onRestart() {
//        super.onRestart()
//        Log.e(TAG, "onReStart")
//    }
//
//    override fun onStart() {
//        super.onStart()
//        Log.e(TAG, "onStart")
//    }
//
//    override fun onResume() {
//        super.onResume()
//        Log.e(TAG, "onResume")
//    }

}