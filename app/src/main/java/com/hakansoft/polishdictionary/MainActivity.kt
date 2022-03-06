package com.hakansoft.polishdictionary

import android.os.Bundle
import android.view.Window
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val window: Window = getWindow()
        supportActionBar?.hide()
        Utility.prepareWindow(window, this)
    }
}