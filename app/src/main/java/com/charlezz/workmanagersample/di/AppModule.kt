package com.charlezz.finalarchitecture.di

import android.app.Application
import android.arch.persistence.db.SupportSQLiteDatabase
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import com.charlezz.workmanagersample.App
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
        return Room
                .databaseBuilder(context, AppDatabase::class.java, "my_db") // permanent
                .fallbackToDestructiveMigration()
                .addCallback(object: RoomDatabase.Callback(){
                    override fun onCreate(db: SupportSQLiteDatabase) {
                        super.onCreate(db)
                        val cv = ContentValues()
                        cv.put("message", "onCreate from Dagger")
                        cv.put("timestamp", System.currentTimeMillis())
                        db.insert("log", SQLiteDatabase.CONFLICT_REPLACE,  cv)
                    }
                })
                .build()
    }
    @Provides
    @Singleton
    fun providePersonDao(appDatabase: AppDatabase): LogDao {
        return appDatabase.dao()
    }

}