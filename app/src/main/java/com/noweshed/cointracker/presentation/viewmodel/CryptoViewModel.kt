package com.noweshed.cointracker.presentation.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.noweshed.cointracker.data.model.response.Coin
import com.noweshed.cointracker.data.model.response.CoinList
import com.noweshed.cointracker.data.model.response.USD
import com.noweshed.cointracker.data.util.Network.isNetworkAvailable
import com.noweshed.cointracker.data.util.Resource
import com.noweshed.cointracker.domain.usecase.CoinUseCase
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * Created by noweshedakram on 22/12/22.
 */
class CryptoViewModel @Inject constructor(
    private val app: Application,
    private val coinUseCase: CoinUseCase
) : AndroidViewModel(app) {

    val coinList: MutableLiveData<Resource<CoinList>> = MutableLiveData()

    fun getAllCoins() = viewModelScope.launch(IO) {
        coinList.postValue(Resource.Loading())
        try {
            if (isNetworkAvailable(app)) {
                val apiResult = coinUseCase.getAllCoinList()
                coinList.postValue(apiResult)
            } else {
                coinList.postValue(Resource.Error(message = "Internet isn't Available"))
            }
        } catch (e: Exception) {
            coinList.postValue(Resource.Error(message = e.localizedMessage ?: "Unknown Error"))
        }
    }

    suspend fun addCryptoCoin(coin: Coin) {
        coinUseCase.addCryptoCoin(coin)
    }

    suspend fun addCryptoUSD(usd: USD) {
        coinUseCase.addCryptoUSD(usd)
    }

    fun coinListItems(): Flow<List<Coin>> {
        return coinUseCase.coinListItems()
    }

    fun usdListItems(): Flow<List<USD>> {
        return coinUseCase.usdListItems()
    }

}