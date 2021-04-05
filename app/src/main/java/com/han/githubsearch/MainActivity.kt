package com.han.githubsearch

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.han.githubsearch.databinding.ActivityMainBinding
import com.han.githubsearch.recyclerview.RepositoriesAdapter
import com.han.githubsearch.network.service.dto.Repository
import com.han.githubsearch.viewmodel.SearchRepoViewModel

class MainActivity : AppCompatActivity() {

    var activityMainBinding: ActivityMainBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        activityMainBinding = ActivityMainBinding.inflate(layoutInflater)
        val searchRepoViewModel = SearchRepoViewModel()
        searchRepoViewModel.repositoriesLiveData.observe(this) {
            setRepositories(it)
        }
        activityMainBinding?.let { binding ->
            setContentView(binding.root)

            binding.search.setOnClickListener {
                val keyword = binding.keyword.text.toString()
                Log.d(javaClass.simpleName, "keyword = $keyword")
                searchRepoViewModel.requestRepositories(keyword)
            }
            binding.searchList.adapter = RepositoriesAdapter()
        }
    }

    fun setRepositories(repositories: List<Repository>) {
        (activityMainBinding?.searchList?.adapter as? RepositoriesAdapter)?.let {
            it.repositories = repositories
            it.notifyDataSetChanged()
        }
    }
}