package com.chetan.home.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.chetan.base.ui.binding.BindableAdapter
import com.chetan.base.ui.diffCallback

class HomeListAdapter( private val viewModel : HomeViewModel ): RecyclerView.Adapter<HomeListAdapter.ViewHolder>() , BindableAdapter<HomeListItemViewState>{

    override var items: List<HomeListItemViewState> by diffCallback(emptyList()) { o, n ->
                o.homeListItem.title == n.homeListItem.title
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getItemCount(): Int {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    class ViewHolder(
        private val binding : HomeListItemBinding
    ): RecyclerView.ViewHolder(binding.root){
        companion object{
            operator fun invoke(parent: ViewGroup) : ViewHolder{
                val binding = HomeListItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
                return ViewHolder(binding)
            }
        }
        fun bind(viewState:HomeListItemViewState, viewModel: HomeViewModel){
            binding.viewState = viewState
            binding.viewModel = viewModel
            binding.executePendingBindings()
        }
    }

}
