package com.charlezz.workmanagersample.log

import android.content.Context
import androidx.work.Worker
import androidx.work.WorkerParameters

class LogWorker(context: Context, workerParams: WorkerParameters): Worker(context,workerParams) {
    val TAG = LogWorker::class.java.simpleName
    override fun doWork(): Result {
        return Result.success()
    }
}
