package com.han.githubsearch.network.service.dto

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName



data class Response<T>(
    @Expose(serialize = true, deserialize = true) val items: List<T>
)

data class Repository(
    @Expose(serialize = true, deserialize = true)
    val name: String,
    @Expose(serialize = true, deserialize = true)
    @SerializedName("full_name")
    val fullName: String,
    @Expose(serialize = true, deserialize = true)
    val owner: Owner,
    @Expose(serialize = true, deserialize = true)
    @SerializedName("html_url")
    val url: String,
    @Expose(serialize = true, deserialize = true)
    val score: Double,
    @Expose(serialize = true, deserialize = true)
    @SerializedName("created_at")
    val createDate: String,
    @Expose(serialize = true, deserialize = true)
    @SerializedName("updated_at")
    val updateDate: String
)

data class Owner(
    @Expose(serialize = true, deserialize = true)
    val login: String
)
