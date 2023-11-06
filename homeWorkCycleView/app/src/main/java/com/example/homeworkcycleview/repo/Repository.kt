package com.example.homeworkcycleview.repo

import com.example.homeworkcycleview.network.model.BaseApi
import com.example.homeworkcycleview.network.model.DataModel
import com.example.homeworkcycleview.network.model.ResultWrapper

interface Repository {
    suspend fun getSimpleList():ResultWrapper<BaseApi<MutableList<DataModel>>>
}