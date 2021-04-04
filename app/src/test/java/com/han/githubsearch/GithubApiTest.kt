package com.han.githubsearch

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.han.githubsearch.mock.RxSchedulerRule
import com.han.githubsearch.network.NetworkModule
import com.han.githubsearch.network.service.GithubSearchApiService
import com.han.githubsearch.network.service.dto.Response
import io.reactivex.schedulers.Schedulers
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import java.util.concurrent.CompletableFuture

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class GithubApiTest {

    @get:Rule
    val rxSchedulerRule = RxSchedulerRule()

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    var networkModule: NetworkModule? = null

    @Before
    fun setUp() {
        networkModule = NetworkModule()
    }

    @Test
    fun searchRepoApiTest() {
        val future = CompletableFuture<String>()
        val futureForResponse = CompletableFuture<Response>()
        networkModule?.let {
            it.getApiService(GithubSearchApiService::class.java)
                .getRepositories("kotlin")
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.computation())
                .subscribe(
                    {
                        println("Success!!")
                        future.complete("success")
                        println(it.items)
                        futureForResponse.complete(it)
                    },{
                        println("Fail!!, ${it.message}")
                        future.complete("error")
                        futureForResponse.complete(null)
                    }
                )
        }
        assertEquals("success", future.get())
        val response = futureForResponse.get()
        assertNotNull(response)
    }

}