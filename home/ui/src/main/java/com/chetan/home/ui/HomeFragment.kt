package com.chetan.home.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.chetan.base.data.network.NetworkState
import com.chetan.base.data.network.Status
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
                adapter = HomePageListAdapter(vm)
                addItemDecoration(ListMarginDecoration(resources.getDimensionPixelSize(R.dimen.margin_sixteen)))
            }
            refreshButton.setOnClickListener {
                vm.retry()
            }
            homeSwipeRefresh.setColorSchemeResources(R.color.dark_green_blue)
            homeSwipeRefresh.setOnRefreshListener {
                vm.refresh()
            }

            vm.liveDataFactList.observe(this@HomeFragment, Observer {
                vm.loadFactListSucess(it) {
                    (homeRecyclerView.adapter as HomePageListAdapter).submitList(it)
                }

            })
            vm.netWorkState.observe(this@HomeFragment, Observer {
                when (it.status) {
                    Status.FAILED -> vm.loadFactListError(Throwable(it.msg))
                    Status.SUCCESS -> if (vm.liveDataFactList.value?.isEmpty()
                            ?: false
                    ) {
                        vm.noFactFound()
                    }
                }
            })
            vm.title.observe(this@HomeFragment, Observer {
                vm.setPageTitle(it)
            })
            vm.refreshState.observe(this@HomeFragment, Observer {
                homeSwipeRefresh.isRefreshing = it == NetworkState.LOADING
                when (it.status) {
                    Status.FAILED -> vm.loadFactListError(Throwable(it.msg))
                    Status.SUCCESS -> if (vm.liveDataFactList.value?.isEmpty()
                            ?: false
                    ) {
                        vm.noFactFound()
                    }
                }
            })


            vm.navigator.navigateBy(this@HomeFragment)
            viewModel = vm
            viewState = vm.viewState
            vm.loadFactList()
        }.root

    }
}






