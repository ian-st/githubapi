package com.han.githubsearch.recyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.han.githubsearch.databinding.ItemViewRepositoryBinding
import com.han.githubsearch.network.service.dto.Repository


class RepositoryViewHolder(val binding: ItemViewRepositoryBinding) : CommonViewHolder(binding.root) {

    class Creator {
        fun newInstance(parent: ViewGroup): CommonViewHolder {
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
        if (data == null || data !is Repository) return
        binding.name.text = data.name
        binding.fullName.text = data.fullName
        binding.url.text = data.url
        binding.score.text = data.score.toString()
        binding.update.text = data.updateDate
    }

}

abstract class CommonViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    abstract fun bind(data: Any?)
}