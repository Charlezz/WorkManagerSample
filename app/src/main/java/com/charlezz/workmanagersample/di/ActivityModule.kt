package com.charlezz.finalarchitecture.di

import com.charlezz.workmanagersample.log.LogActivity
import com.charlezz.workmanagersample.log.LogActivityModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityModule {

    @ActivityScope
    @ContributesAndroidInjector(modules = [(LogActivityModule::class)])
    abstract fun getMainActivity(): LogActivity

}
