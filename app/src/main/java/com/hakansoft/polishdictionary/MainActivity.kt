package com.hakansoft.polishdictionary

import android.os.Bundle
import android.view.View
import android.view.View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
import android.view.Window
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val window: Window = getWindow()
        supportActionBar?.hide()
        Utility.prepareWindow(window, this)
    }
}