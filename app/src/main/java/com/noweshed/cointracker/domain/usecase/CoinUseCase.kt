package com.noweshed.cointracker.domain.usecase

import com.noweshed.cointracker.data.model.JoinQueryModel
import com.noweshed.cointracker.data.model.response.Coin
import com.noweshed.cointracker.data.model.response.CoinList
import com.noweshed.cointracker.data.model.response.USD
import com.noweshed.cointracker.data.util.Resource
import com.noweshed.cointracker.domain.repo.CoinRepo
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

/**
 * Created by noweshedakram on 22/12/22.
 */
class CoinUseCase @Inject constructor(
    private val coinRepo: CoinRepo
) {

    suspend fun getAllCoinList(): Resource<CoinList> {
        return coinRepo.getCoinList()
    }

    suspend fun addCryptoCoin(coin: Coin) {
        coinRepo.addCryptoCoin(coin)
    }

    suspend fun addCryptoUSD(usd: USD) {
        coinRepo.addCryptoUSD(usd)
    }

    fun coinListItems(limit: Int): List<JoinQueryModel> {
        return coinRepo.coinListItems(limit = limit)
    }

}