package com.example.syncdark.app

import android.app.Application
import androidx.appcompat.app.AppCompatDelegate
import androidx.appcompat.app.AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM

class BaseApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        setThemeDayNightDefault()
    }

    private fun setThemeDayNightDefault() =
        AppCompatDelegate.setDefaultNightMode(MODE_NIGHT_FOLLOW_SYSTEM)
}