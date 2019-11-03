package com.chetan.home.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.chetan.base.ui.ListMarginDecoration
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
        return HomeFragmentBinding.inflate(inflater, container, false).apply {
            val vm by viewModels<HomeViewModel> { factory }

            with(homeRecyclerView) {
                layoutManager = LinearLayoutManager(context)
                adapter = HomeListAdapter(vm)
                addItemDecoration(ListMarginDecoration(resources.getDimensionPixelSize(R.dimen.margin_sixteen)))
            }
            homeSwipeRefresh.setColorSchemeResources(R.color.dark_green_blue)

            vm.navigator.navigateBy(this@HomeFragment)
            viewModel = vm
            viewState = vm.viewState
            vm.loadHomeList()
        }.root


    }
}






