package com.example.homeworkcycleview.network.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class BaseApi<T> {
    @SerializedName("success")
    @Expose
    internal val success: Boolean = false

    @SerializedName("data")
    @Expose
    internal var data : T? = null

    @SerializedName("massage")
    @Expose
    internal val message: String = ""
}
