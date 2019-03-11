package com.charlezz.workmanagersample.data

import android.arch.persistence.db.SupportSQLiteDatabase
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.ContentValues
import android.database.sqlite.SQLiteDatabase
import com.charlezz.workmanagersample.App.Companion.context

object AppDB {
    val instance : AppDatabase

    init {
        instance = Room
            .databaseBuilder(context, AppDatabase::class.java, "my_db") // permanent
            .fallbackToDestructiveMigration()
            .addCallback(object : RoomDatabase.Callback() {
                override fun onCreate(db: SupportSQLiteDatabase) {
                    super.onCreate(db)
                    val cv = ContentValues()
                    cv.put("message", "onCreate from Dagger")
                    cv.put("timestamp", System.currentTimeMillis())
                    db.insert("log", SQLiteDatabase.CONFLICT_REPLACE, cv)
                }
            })
            .build()
    }

}