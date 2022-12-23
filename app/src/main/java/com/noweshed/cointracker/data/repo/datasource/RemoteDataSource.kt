package com.noweshed.cointracker.data.repo.datasource

import com.noweshed.cointracker.data.model.response.CoinList
import retrofit2.Response

/**
 * Created by noweshedakram on 22/12/22.
 */
interface RemoteDataSource {

    suspend fun getCoinList(): Response<CoinList>

}