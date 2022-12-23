package com.noweshed.cointracker.presentation.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.noweshed.cointracker.R
import com.noweshed.cointracker.data.util.Resource
import com.noweshed.cointracker.databinding.FragmentHomeBinding
import com.noweshed.cointracker.databinding.FragmentSplashBinding
import com.noweshed.cointracker.presentation.adapter.CoinAdapter
import com.noweshed.cointracker.presentation.viewmodel.CryptoViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class HomeFragment : Fragment() {

    private lateinit var fragmentHomeBinding: FragmentHomeBinding

    @Inject
    lateinit var coinAdapter: CoinAdapter

    @Inject
    lateinit var cryptoViewModel: CryptoViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        fragmentHomeBinding = FragmentHomeBinding.inflate(layoutInflater)
        return fragmentHomeBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        fragmentHomeBinding = FragmentHomeBinding.bind(view)

        cryptoViewModel.getAllCoins()

        cryptoViewModel.coinList.observe(viewLifecycleOwner) { response ->
            when (response) {
                is Resource.Success -> {
                    coinAdapter.differ.submitList(response.data?.subList(0, 10))
                    fragmentHomeBinding.recyclerView.visibility = View.VISIBLE
                    Log.i("HomeFragment", "${response.data}")
                    fragmentHomeBinding.loadingProgress.loadingProgress.visibility = View.GONE
                }
                is Resource.Loading -> {
                    fragmentHomeBinding.recyclerView.visibility = View.INVISIBLE
                    fragmentHomeBinding.loadingProgress.loadingProgress.visibility =
                        View.VISIBLE
                    Log.i("HomeFragment", "Loading...")
                }
                is Resource.Error -> {
                    Log.i("HomeFragment", "${response.message}")
                    Toast.makeText(context, "${response.message}", Toast.LENGTH_LONG).show()
                    fragmentHomeBinding.loadingProgress.loadingProgress.visibility = View.GONE
                }
            }
        }

        fragmentHomeBinding.swipeRefresh.setOnRefreshListener {
            fragmentHomeBinding.swipeRefresh.isRefreshing = false
            cryptoViewModel.getAllCoins()
        }
        fragmentHomeBinding.recyclerView.adapter = coinAdapter
    }
}