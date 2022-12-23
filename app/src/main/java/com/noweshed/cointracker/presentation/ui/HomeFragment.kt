package com.noweshed.cointracker.presentation.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.noweshed.cointracker.data.model.response.Coin
import com.noweshed.cointracker.data.model.response.CoinList
import com.noweshed.cointracker.data.model.response.USD
import com.noweshed.cointracker.data.util.Constants.COINS_LIMIT
import com.noweshed.cointracker.data.util.Resource
import com.noweshed.cointracker.databinding.FragmentHomeBinding
import com.noweshed.cointracker.presentation.adapter.CoinAdapter
import com.noweshed.cointracker.presentation.viewmodel.CryptoViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
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
                    coinAdapter.differ.submitList(response.data?.subList(0, COINS_LIMIT))
                    fragmentHomeBinding.recyclerView.visibility = View.VISIBLE
                    Log.i("HomeFragment", "${response.data}")
                    lifecycleScope.launch() {
                        storeDataLocally(response.data)
                    }
                    fragmentHomeBinding.loadingProgress.loadingProgress.visibility = View.GONE
//                    showLocalData()
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
//            cryptoViewModel.coinListItems(COINS_LIMIT)
        }
        fragmentHomeBinding.recyclerView.adapter = coinAdapter
    }

//    private fun showLocalData() {
//        CoroutineScope(IO).launch {
//            Log.i("showLocalData: ", cryptoViewModel.coinListItems(10).toString())
//            coinAdapter.differ.submitList(cryptoViewModel.coinListItems(10))
//        }
//    }

    private suspend fun storeDataLocally(data: CoinList?) {

        if (data != null) {
            for (item in data) {
                cryptoViewModel.addCryptoCoin(
                    Coin(
                        item.id,
                        item.name,
                        item.symbol,
                        item.rank,
                        item.circulatingSupply,
                        item.totalSupply,
                        item.maxSupply,
                        item.betaValue,
                        item.firstDataAt,
                        item.lastUpdated,
                    )
                )

                cryptoViewModel.addCryptoUSD(
                    USD(
                        0,
                        item.id,
                        item.quotes?.USD?.price,
                        item.quotes?.USD?.volume24h,
                        item.quotes?.USD?.volume24hChange24h,
                        item.quotes?.USD?.marketCap,
                        item.quotes?.USD?.marketCapChange24h,
                        item.quotes?.USD?.percentChange15m,
                        item.quotes?.USD?.percentChange30m,
                        item.quotes?.USD?.percentChange1h,
                        item.quotes?.USD?.percentChange6h,
                        item.quotes?.USD?.percentChange12h,
                        item.quotes?.USD?.percentChange24h,
                        item.quotes?.USD?.percentChange7d,
                        item.quotes?.USD?.percentChange30d,
                        item.quotes?.USD?.percentChange1y,
                        item.quotes?.USD?.athPrice,
                        item.quotes?.USD?.athDate,
                        item.quotes?.USD?.percentFromPriceAth,
                    )
                )
            }
        }
    }
}