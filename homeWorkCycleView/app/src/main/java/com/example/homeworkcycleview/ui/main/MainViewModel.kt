package com.example.homeworkcycleview.ui.main

import android.R.attr.data
import com.example.homeworkcycleview.impl.RepositoryImpl
import com.example.homeworkcycleview.network.Portal
import com.example.homeworkcycleview.network.model.ResultWrapper
import com.example.homeworkcycleview.network.servies.UrlYoutube
import com.example.homeworkcycleview.ui.base.BaseViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext


class MainViewModel : BaseViewModel<MainNavigator>(),CoroutineScope {
    private val job: Job by lazy { SupervisorJob() }
    override val coroutineContext: CoroutineContext
        get() = Dispatchers.Main + job

    override fun tag(): String = MainActivity::class.java.simpleName
    private var repositoryImpl : RepositoryImpl
    private val navigator: MainNavigator? by lazy { getNavigator()?.get() }

    init {
        val youtubeApiService = Portal.createPortal(UrlYoutube::class.java)
        repositoryImpl = RepositoryImpl(youtubeApiService)
    }

    fun getSimpleList() {
        launch {
            when (val result = repositoryImpl.getSimpleList()) {
                is ResultWrapper.Success -> {
                    val data = result.value
                    if (!data.success) {
                        navigator?.getSimpleListFailed(Exception("Error failed"))
                        return@launch
                    }
                    val datalist = data.data
                    datalist?.let { dataYoutubeList ->
                        navigator?.getSimpleListSuccess(dataYoutubeList)
                    } ?: run {
                        navigator?.getSimpleListFailed(Exception("Data null"))
                    }
                }

                is ResultWrapper.GenericError -> {
//                    navigator?.hideLoading()
                    val exception = result.exception ?: Exception("ERRR")
                    navigator?.getSimpleListFailed(exception)
                }

                is ResultWrapper.NetworkError -> {
//                    navigator?.hideLoading()
                    val exception = result.exception ?: Exception("ERRR")
                    navigator?.getSimpleListFailed(exception)
                }
            }
        }
    }
}