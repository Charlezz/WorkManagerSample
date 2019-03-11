package com.charlezz.workmanagersample.log

import android.content.Context
import androidx.work.Worker
import androidx.work.WorkerParameters
import com.charlezz.workmanagersample.data.AppDB
import com.charlezz.workmanagersample.data.entity.LogData

class LogWorker(context: Context, val workerParams: WorkerParameters): Worker(context,workerParams) {
    val TAG = LogWorker::class.java.simpleName
    override fun doWork(): Result {
        AppDB.instance.dao().insert(LogData(null, "leave a trace...", System.currentTimeMillis()))
        return Result.success()
    }
}
