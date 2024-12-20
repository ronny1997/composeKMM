package org.appmaster.labs.composekmm

import android.app.Application
import org.appmaster.labs.composekmm.di.initKoin
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.logger.Level

class ComposeApp : Application() {

    override fun onCreate() {
        super.onCreate()
         initKoin {
             androidLogger(Level.DEBUG)
              androidContext(this@ComposeApp)
         }
    }

}