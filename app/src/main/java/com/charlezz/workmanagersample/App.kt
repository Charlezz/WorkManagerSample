package com.charlezz.workmanagersample

import android.content.Context
import android.support.multidex.MultiDex
import com.charlezz.finalarchitecture.di.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication

class App : DaggerApplication() {

    companion object{
        lateinit var context:Context
    }


    override fun onCreate() {
        super.onCreate()
        context = this
    }
    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerAppComponent.builder().create(this)
    }

    override fun attachBaseContext(base: Context) {
        super.attachBaseContext(base)
        MultiDex.install(this)
    }
}