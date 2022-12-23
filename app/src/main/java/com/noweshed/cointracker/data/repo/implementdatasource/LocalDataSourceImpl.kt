package com.noweshed.cointracker.data.repo.implementdatasource

import com.noweshed.cointracker.data.db.CoinDAO
import com.noweshed.cointracker.data.model.response.Coin
import com.noweshed.cointracker.data.model.response.USD
import com.noweshed.cointracker.data.repo.datasource.LocalDataSource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

/**
 * Created by noweshedakram on 23/12/22.
 */
class LocalDataSourceImpl @Inject constructor(
    private val coinDAO: CoinDAO
) : LocalDataSource {

    override suspend fun addCryptoCoin(coin: Coin) {
        return coinDAO.addCryptoCoin(coin)
    }

    override suspend fun addCryptoUSD(usd: USD) {
        return coinDAO.addCryptoUSD(usd)
    }

    override fun coinListItems(): Flow<List<Coin>> {
        return coinDAO.coinListItems()
    }

    override fun usdListItems(): Flow<List<USD>> {
        return coinDAO.usdListItems()
    }

}