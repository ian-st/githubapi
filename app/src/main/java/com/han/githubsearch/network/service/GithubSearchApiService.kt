package com.han.githubsearch.network.service

import com.han.githubsearch.network.service.dto.Repository
import com.han.githubsearch.network.service.dto.Response
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query


/**
 *
 * Copyright ⓒ LOTTESHOPPING Co., LTD. All rights reserved.
 *
 * Created by hlee10(hlee10@lotte.net) on 05, 04, 2021..
 *
 */

interface GithubSearchApiService {
    @GET("repositories")
    fun getRepositories(@Query("q") query: String): Observable<Response<Repository>>
}