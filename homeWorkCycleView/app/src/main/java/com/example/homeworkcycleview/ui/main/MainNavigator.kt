package com.example.homeworkcycleview.ui.main

import com.example.homeworkcycleview.network.model.DataModel

interface MainNavigator {
    fun getSimpleList()
    fun getSimpleListSuccess(list : MutableList<DataModel>)
    fun getSimpleListFailed(exception : Exception)
}