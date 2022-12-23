package com.noweshed.cointracker.domain.repo

import com.noweshed.cointracker.data.model.response.Coin
import com.noweshed.cointracker.data.model.response.CoinList
import com.noweshed.cointracker.data.model.response.USD
import com.noweshed.cointracker.data.util.Resource
import kotlinx.coroutines.flow.Flow

/**
 * Created by noweshedakram on 22/12/22.
 */
interface CoinRepo {
    suspend fun getCoinList(): Resource<CoinList>
    suspend fun addCryptoCoin(coin: Coin)
    suspend fun addCryptoUSD(usd: USD)

    fun coinListItems(): Flow<List<Coin>>
    fun usdListItems(): Flow<List<USD>>
}