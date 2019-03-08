package com.charlezz.workmanagersample.log

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import androidx.work.PeriodicWorkRequest
import androidx.work.WorkManager
import com.charlezz.workmanagersample.R
import java.util.concurrent.TimeUnit

class LogActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_log)
        val workRequest = PeriodicWorkRequest.Builder(LogWorker::class.java, 1000L, TimeUnit.MILLISECONDS)
            .build()
        WorkManager.getInstance().enqueue(workRequest)
    }
}
