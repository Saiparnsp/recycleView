package com.example.homeworkcycleview.impl

import com.example.homeworkcycleview.network.model.BaseApi
import com.example.homeworkcycleview.network.model.DataModel
import com.example.homeworkcycleview.network.model.ResultWrapper
import com.example.homeworkcycleview.network.model.callApiPortal
import com.example.homeworkcycleview.network.servies.UrlYoutube
import com.example.homeworkcycleview.repo.Repository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

class RepositoryImpl(
    private val urlYoutube: UrlYoutube,
    private val coroutineContext:CoroutineDispatcher=Dispatchers.IO
):Repository {
    override suspend fun getSimpleList(): ResultWrapper<BaseApi<MutableList<DataModel>>> =
        callApiPortal(coroutineContext){
            urlYoutube.getSimpleList()
        }
}