package com.han.githubsearch.network.recyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.han.githubsearch.databinding.ItemViewRepositoryBinding


/**
 *
 * Copyright ⓒ LOTTESHOPPING Co., LTD. All rights reserved.
 *
 * Created by hlee10(hlee10@lotte.net) on 05, 04, 2021..
 *
 */


class RepositoryViewHolder(binging: ItemViewRepositoryBinding) : CommonViewHolder(binging.root) {

    class Creator {
        fun newInstance(parent: ViewGroup): RecyclerView.ViewHolder {
            return RepositoryViewHolder(
                ItemViewRepositoryBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
            )
        }
    }

    override fun bind(data: Any?) {
        TODO("Not yet implemented")
    }

}

abstract class CommonViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    abstract fun bind(data: Any?)
}