package com.noweshed.cointracker.data.repo

import com.noweshed.cointracker.data.model.response.Coin
import com.noweshed.cointracker.data.model.response.CoinList
import com.noweshed.cointracker.data.model.response.USD
import com.noweshed.cointracker.data.repo.datasource.LocalDataSource
import com.noweshed.cointracker.data.repo.datasource.RemoteDataSource
import com.noweshed.cointracker.data.util.Resource
import com.noweshed.cointracker.domain.repo.CoinRepo
import kotlinx.coroutines.flow.Flow
import retrofit2.Response
import javax.inject.Inject

/**
 * Created by noweshedakram on 21/12/22.
 */
class RepositoryImpl @Inject constructor(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource
) : CoinRepo {

    override suspend fun getCoinList(): Resource<CoinList> {
        return responseToCoinList(remoteDataSource.getCoinList())
    }

    private fun responseToCoinList(response: Response<CoinList>): Resource<CoinList> {
        if (response.isSuccessful) {
            response.body()?.let { result ->
                return Resource.Success(result)
            }
        }
        return Resource.Error(message = "${response.errorBody()?.string()}")
    }

    override suspend fun addCryptoCoin(coin: Coin) {
        return localDataSource.addCryptoCoin(coin)
    }

    override suspend fun addCryptoUSD(usd: USD) {
        return localDataSource.addCryptoUSD(usd)
    }

    override fun coinListItems(): Flow<List<Coin>> {
        return localDataSource.coinListItems()
    }

    override fun usdListItems(): Flow<List<USD>> {
        return localDataSource.usdListItems()
    }

}