package com.axiaworks.tutorial

import android.app.Application

class TutorialApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        Property.context = applicationContext
    }
}