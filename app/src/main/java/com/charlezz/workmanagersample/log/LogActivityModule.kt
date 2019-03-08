package com.charlezz.workmanagersample.log

import android.databinding.DataBindingUtil
import com.charlezz.finalarchitecture.di.ActivityScope
import com.charlezz.workmanagersample.R
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
        fun provideMainActivityBinding(activity: LogActivity): ActivityLogBinding{
            return DataBindingUtil.setContentView(activity, R.layout.activity_log)
        }

    }
}