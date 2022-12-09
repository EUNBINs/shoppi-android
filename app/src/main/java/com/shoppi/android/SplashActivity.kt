package com.shoppi.android

import android.animation.ObjectAnimator
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.View
import android.view.ViewTreeObserver
import android.view.animation.AnticipateInterpolator
import androidx.core.animation.doOnEnd
import kotlin.concurrent.thread

class SplashActivity : AppCompatActivity() {
    var isReady = false
    var isStart = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.e("splashActivity", "splash 등장")

        startActivity(Intent(this, MainActivity::class.java))
        finish()
    }
}