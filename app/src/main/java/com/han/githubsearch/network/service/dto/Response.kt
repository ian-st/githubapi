package com.han.githubsearch.network.service.dto

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


/**
 *
 * Copyright ⓒ LOTTESHOPPING Co., LTD. All rights reserved.
 *
 * Created by hlee10(hlee10@lotte.net) on 05, 04, 2021..
 *
 */
data class Response(
    @Expose(serialize = true, deserialize = true) val items: List<ResRepo>
)

data class ResRepo(
    @Expose(serialize = true, deserialize = true) val name: String,
    @Expose(serialize = true, deserialize = true)
    @SerializedName("full_name")
    val fullName: String
)
