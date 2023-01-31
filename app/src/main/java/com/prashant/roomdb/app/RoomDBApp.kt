package com.prashant.roomdb.app

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class RoomDBApp : Application() {

    override fun onCreate() {
        super.onCreate()
       /* if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }*/
    }
}