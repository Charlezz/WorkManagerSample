package com.charlezz.finalarchitecture.di

import android.app.Application
import android.content.Context
import com.charlezz.workmanagersample.App
import com.charlezz.workmanagersample.data.AppDB
import com.charlezz.workmanagersample.data.AppDatabase
import com.charlezz.workmanagersample.data.LogDao
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule {

    @Provides
    @Singleton
    fun provideAppContext(app: App): Context {
        return app
    }

    @Provides
    @Singleton
    fun provideApplication(app: App): Application {
        return app
    }

    @Provides
    @Singleton
    fun provideAppDatabase(context: Context): AppDatabase {
        return AppDB.instance
    }
    @Provides
    @Singleton
    fun providePersonDao(appDatabase: AppDatabase): LogDao {
        return appDatabase.dao()
    }

}