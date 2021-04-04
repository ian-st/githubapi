package com.han.githubsearch.network.recyclerview

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.han.githubsearch.network.service.dto.Repository


/**
 *
 * Copyright ⓒ LOTTESHOPPING Co., LTD. All rights reserved.
 *
 * Created by hlee10(hlee10@lotte.net) on 05, 04, 2021..
 *
 */

class RepositoriesAdapter(var repositories: List<Repository>? = null)
    : RecyclerView.Adapter<CommonViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CommonViewHolder {
        return RepositoryViewHolder.Creator().newInstance(parent)
    }

    override fun onBindViewHolder(holder: CommonViewHolder, position: Int) {
        holder.bind(repositories?.getOrNull(position))
    }

    override fun getItemCount(): Int = repositories?.size ?: 0


}