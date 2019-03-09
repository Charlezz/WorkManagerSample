package com.charlezz.workmanagersample.log

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import com.charlezz.finalarchitecture.di.ActivityScope
import com.charlezz.workmanagersample.R
import com.charlezz.workmanagersample.data.LogDao
import com.charlezz.workmanagersample.databinding.ActivityLogBinding
import dagger.Module
import dagger.Provides

@Module
abstract class LogActivityModule {
    @Module
    companion object {
        @JvmStatic
        @Provides
        @ActivityScope
        fun provideBinding(activity: LogActivity): ActivityLogBinding{
            return DataBindingUtil.setContentView(activity, R.layout.activity_log)
        }

        @JvmStatic
        @Provides
        @ActivityScope
        fun provideAdapter() = LogAdapter()

        @JvmStatic
        @Provides
        @ActivityScope
        fun provideViewModel(activity:LogActivity,logDao: LogDao) = ViewModelProviders.of(activity, object:ViewModelProvider.Factory{
            override fun <T : ViewModel?> create(modelClass: Class<T>): T {
                return LogViewModel(logDao) as T
            }
        }).get(LogViewModel::class.java)
    }
}