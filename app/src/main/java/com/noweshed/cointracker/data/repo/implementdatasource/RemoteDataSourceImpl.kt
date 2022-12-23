package com.noweshed.cointracker.data.repo.implementdatasource

import com.noweshed.cointracker.data.api.ApiService
import com.noweshed.cointracker.data.model.response.CoinList
import com.noweshed.cointracker.data.repo.datasource.RemoteDataSource
import retrofit2.Response
import javax.inject.Inject

/**
 * Created by noweshedakram on 22/12/22.
 */
class RemoteDataSourceImpl @Inject constructor(
    private val apiService: ApiService
) : RemoteDataSource {

    override suspend fun getCoinList(): Response<CoinList> {
        return apiService.getCoinList()
    }
}