package com.charlezz.workmanagersample.data

import android.arch.paging.DataSource
import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query
import com.charlezz.workmanagersample.data.entity.LogData



@Dao
interface LogDao {
    @Query("SELECT * FROM log ORDER BY timestamp DESC")
    fun getPersonSource(): DataSource.Factory<Int, LogData>

    @Insert
    fun insert(logData:LogData)
}