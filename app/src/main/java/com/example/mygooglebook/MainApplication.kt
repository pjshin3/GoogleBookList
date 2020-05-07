package com.example.mygooglebook

import android.app.Application
import com.example.mygooglebook.di.apiModule
import com.example.mygooglebook.di.remoteModule
import com.example.mygooglebook.di.viewmodelModule
import org.koin.core.context.startKoin

class MainApplication : Application(){

    override fun onCreate() {
        super.onCreate()
            startKoin{
                modules(listOf(
                    remoteModule,
                    apiModule,
                    viewmodelModule
                ))
            }
    }

}