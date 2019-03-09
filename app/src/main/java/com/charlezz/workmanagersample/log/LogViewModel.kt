package com.charlezz.workmanagersample.log

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.ViewModel
import android.arch.paging.LivePagedListBuilder
import android.arch.paging.PagedList
import com.charlezz.workmanagersample.data.LogDao
import com.charlezz.workmanagersample.data.entity.LogData

class LogViewModel(val dao: LogDao) : ViewModel(){
    val logs : LiveData<PagedList<LogData>> = LivePagedListBuilder(dao.getPersonSource(),30).build()
}