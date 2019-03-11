package com.charlezz.workmanagersample.log

import android.arch.paging.PagedListAdapter
import android.support.v7.util.DiffUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.charlezz.workmanagersample.data.entity.LogData
import com.charlezz.workmanagersample.databinding.ViewLogBinding

class LogAdapter : PagedListAdapter<LogData,LogAdapter.ViewHolder>(
    object:DiffUtil.ItemCallback<LogData>(){
        override fun areItemsTheSame(p0: LogData, p1: LogData): Boolean {
            return false
        }

        override fun areContentsTheSame(p0: LogData, p1: LogData): Boolean {
            return false
        }
    }
){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(
        ViewLogBinding.inflate(LayoutInflater.from(parent.context),parent, false)
    )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.data = getItem(position)
        holder.binding.executePendingBindings()
    }

    inner class ViewHolder(val binding: ViewLogBinding): RecyclerView.ViewHolder(binding.root)
}