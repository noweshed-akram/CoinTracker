package com.noweshed.cointracker.data.repo.datasource

import com.noweshed.cointracker.data.model.JoinQueryModel
import com.noweshed.cointracker.data.model.response.Coin
import com.noweshed.cointracker.data.model.response.USD
import kotlinx.coroutines.flow.Flow

/**
 * Created by noweshedakram on 23/12/22.
 */
interface LocalDataSource {
    suspend fun addCryptoCoin(coin: Coin)
    suspend fun addCryptoUSD(usd: USD)

    fun coinListItems(limit: Int): List<JoinQueryModel>
}