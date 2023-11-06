package com.example.homeworkcycleview.network.servies

import com.example.homeworkcycleview.network.BaseUrl
import com.example.homeworkcycleview.network.model.BaseApi
import com.example.homeworkcycleview.network.model.DataModel
import retrofit2.http.GET

interface UrlYoutube  {
    @GET("/youtubelist")
    suspend fun getSimpleList(): BaseApi<MutableList<DataModel>>
}