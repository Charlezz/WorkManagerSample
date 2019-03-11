package com.charlezz.workmanagersample.data.entity

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import java.text.SimpleDateFormat

@Entity(tableName = "log")
data class LogData(
        @PrimaryKey(autoGenerate = true) val id:Long?,
        val message:String,
        val timestamp:Long){

    fun getTimestampToString():String{
        return SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(timestamp)
    }
}
