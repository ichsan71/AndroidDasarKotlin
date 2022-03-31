package com.marqumil.androiddasarkotlin

import android.app.Application
import android.util.Log

class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        Log.i("APP", "wkwk")
    }
}