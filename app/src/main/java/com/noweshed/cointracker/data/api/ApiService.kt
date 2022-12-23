package com.noweshed.cointracker.data.api

import com.noweshed.cointracker.data.model.response.CoinList
import retrofit2.Response
import retrofit2.http.GET

/**
 * Created by noweshedakram on 22/12/22.
 */
interface ApiService {

    @GET("tickers")
    suspend fun getCoinList(): Response<CoinList>

}