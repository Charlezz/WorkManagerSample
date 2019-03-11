package com.charlezz.workmanagersample.log

import android.arch.persistence.db.SupportSQLiteDatabase
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import androidx.work.Worker
import androidx.work.WorkerParameters
import com.charlezz.workmanagersample.data.AppDatabase
import com.charlezz.workmanagersample.data.entity.LogData

class LogWorker(context: Context, val workerParams: WorkerParameters): Worker(context,workerParams) {
    val TAG = LogWorker::class.java.simpleName
    override fun doWork(): Result {
        Room.databaseBuilder(applicationContext, AppDatabase::class.java, "my_db") // permanent
                .fallbackToDestructiveMigration()
                .addCallback(object: RoomDatabase.Callback(){
                    override fun onCreate(db: SupportSQLiteDatabase) {
                        super.onCreate(db)
                        val cv = ContentValues()
                        cv.put("message", "onCreate from worker")
                        cv.put("timestamp", System.currentTimeMillis())
                        db.insert("log", SQLiteDatabase.CONFLICT_REPLACE,  cv)
                    }
                })
                .build().dao()
                .insert(LogData(null, "leave a trace...", System.currentTimeMillis()))
        return Result.success()
    }
}
