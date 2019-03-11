package com.charlezz.workmanagersample.log

import android.annotation.SuppressLint
import android.arch.lifecycle.Observer
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import androidx.work.PeriodicWorkRequest
import androidx.work.WorkManager
import com.charlezz.workmanagersample.data.LogDao
import com.charlezz.workmanagersample.databinding.ActivityLogBinding
import dagger.android.support.DaggerAppCompatActivity
import java.util.concurrent.TimeUnit
import javax.inject.Inject

class LogActivity : DaggerAppCompatActivity() {

    @Inject lateinit var viewModel:LogViewModel
    @Inject lateinit var adapter:LogAdapter
    @Inject lateinit var binding:ActivityLogBinding
    @Inject lateinit var dao : LogDao

    @SuppressLint("RestrictedApi")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.lifecycleOwner = this
        binding.recyclerView.adapter = adapter
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.viewModel = viewModel

        viewModel.logs.observe(this, Observer {
            adapter.submitList(it)
        })


        val workRequest = PeriodicWorkRequest
                .Builder(LogWorker::class.java, 15, TimeUnit.MINUTES)
                .build()
        WorkManager.getInstance().enqueue(workRequest)
    }
}
