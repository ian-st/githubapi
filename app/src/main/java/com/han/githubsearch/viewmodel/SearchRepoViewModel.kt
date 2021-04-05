package com.han.githubsearch.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.han.githubsearch.network.NetworkModule
import com.han.githubsearch.network.service.GithubSearchApiService
import com.han.githubsearch.network.service.dto.Repository
import io.reactivex.schedulers.Schedulers


class SearchRepoViewModel : ViewModel() {
    val repositoriesLiveData: MutableLiveData<List<Repository>> = MutableLiveData()
    private val githubSearchApiService: GithubSearchApiService by lazy {
        NetworkModule().getApiService(GithubSearchApiService::class.java)
    }

    fun requestRepositories(keyword: String?) = keyword?.run keyword@{
        githubSearchApiService.getRepositories(this@keyword)
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.computation())
                .subscribe(
                        {
                            println("Success!!")
                            repositoriesLiveData.postValue(it.items)
                        },
                        {
                            println("Fail!!, ${it.message}")
                        }
                )
    }

    override fun onCleared() {
        super.onCleared()
        repositoriesLiveData.value = null
    }
}