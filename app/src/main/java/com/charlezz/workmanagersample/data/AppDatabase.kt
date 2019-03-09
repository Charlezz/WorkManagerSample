package com.charlezz.workmanagersample.data

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import com.charlezz.workmanagersample.data.entity.LogData

@Database(entities = [(LogData::class)], version = 2, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun dao(): LogDao
}