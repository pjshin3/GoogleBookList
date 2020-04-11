package com.example.mygooglebook

import android.app.Application
import com.example.mygooglebook.di.remoteModule
import org.koin.android.ext.android.startKoin

class MainApplication : Application(){

    override fun onCreate() {
        super.onCreate()
            startKoin(this, listOf(
                remoteModule
            ))
    }

}