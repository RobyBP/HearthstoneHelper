package com.robybp.hearthstonehelper

import android.app.Application
import com.robybp.hearthstonehelper.di.retrofitModule
import com.robybp.hearthstonehelper.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class HearthstoneHelperApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@HearthstoneHelperApplication)
            modules(getModules())
        }
    }

    private fun getModules() =
        listOf(
            viewModelModule,
            retrofitModule
        )
}
