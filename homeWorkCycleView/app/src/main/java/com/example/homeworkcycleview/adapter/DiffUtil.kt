package com.example.homeworkcycleview.adapter

import androidx.recyclerview.widget.DiffUtil
import com.example.homeworkcycleview.network.model.DataModel

class DiffUtil :DiffUtil.ItemCallback<DataModel>(){

    override fun areItemsTheSame(oldItem: DataModel, newItem: DataModel): Boolean = oldItem == newItem
    override fun areContentsTheSame(oldItem: DataModel, newItem: DataModel): Boolean = oldItem.id == newItem.id
}