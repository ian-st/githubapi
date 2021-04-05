package com.han.githubsearch.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.han.githubsearch.mock.RxSchedulerRule
import com.jraska.livedata.test
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class SearchRepoViewModelTest {

//     mock main thread
    @get:Rule
    val rxSchedulerRule = RxSchedulerRule()

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    private var searchRepoViewModel: SearchRepoViewModel? = null

    @Before
    fun setUp() {
        searchRepoViewModel = SearchRepoViewModel()
    }

    @Test
    fun requestRepositoriesTest() {
        searchRepoViewModel?.requestRepositories("kotlin")
        searchRepoViewModel?.repositoriesLiveData
                ?.test()
                ?.assertValue { repositories ->
                    return@assertValue !repositories.isNullOrEmpty()
                }
    }
}