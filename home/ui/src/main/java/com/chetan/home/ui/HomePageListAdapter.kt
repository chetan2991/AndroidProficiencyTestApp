package com.chetan.home.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.chetan.home.domain.model.Fact

class HomePageListAdapter(private val viewModel: HomeViewModel) :
    PagedListAdapter<Fact, HomePageListAdapter.ViewHolder>(ITEM_COMPARATOR) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return HomePageListAdapter.ViewHolder(parent)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position)
        if (item != null) {
            holder.bind(item, viewModel)
        }
    }

    class ViewHolder(
        private val binding: HomeListItemBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        companion object {
            operator fun invoke(parent: ViewGroup): ViewHolder {
                val binding =
                    HomeListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
                return ViewHolder(binding)
            }
        }

        fun bind(viewState: Fact, viewModel: HomeViewModel) {
            binding.viewState = viewState
            binding.viewModel = viewModel
            binding.executePendingBindings()
        }
    }

    companion object {
        private val ITEM_COMPARATOR = object : DiffUtil.ItemCallback<Fact>() {
            override fun areItemsTheSame(oldItem: Fact, newItem: Fact): Boolean =
                oldItem.title == newItem.title

            override fun areContentsTheSame(oldItem: Fact, newItem: Fact): Boolean =
                oldItem == newItem
        }
    }
}


