package com.chetan.home.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.View.inflate
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import dagger.android.support.DaggerFragment
import javax.inject.Inject

class HomeFragment : DaggerFragment() {

    @Inject
    lateinit var factory: ViewModelProvider.Factory

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)

    }
}


//class StoryListFragment : DaggerFragment() {
//
//    @Inject
//    lateinit var factory: ViewModelProvider.Factory
//
//    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
//        return inflate(inflater, container, false)
//            .apply {
//                val vm by viewModels<StoryListViewModel> { factory }
//
//                with(storiesRecyclerView) {
//                    layoutManager = LinearLayoutManager(context)
//                    adapter = StoriesAdapter(vm)
//                    addItemDecoration(ListMarginDecoration(resources.getDimensionPixelSize(R.dimen.margin_sixteen)))
//                }
//                storiesSwipeRefresh.setColorSchemeResources(R.color.dark_green_blue)
//
//                vm.navigator.navigateBy(this@StoryListFragment)
//                viewModel = vm
//                viewState = vm.viewState
//                vm.loadStories()
//            }
//            .root
//    }
//}



