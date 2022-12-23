package com.noweshed.cointracker.presentation.di

import com.noweshed.cointracker.data.api.ApiService
import com.noweshed.cointracker.data.db.CoinDAO
import com.noweshed.cointracker.data.repo.datasource.LocalDataSource
import com.noweshed.cointracker.data.repo.datasource.RemoteDataSource
import com.noweshed.cointracker.data.repo.implementdatasource.LocalDataSourceImpl
import com.noweshed.cointracker.data.repo.implementdatasource.RemoteDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 * Created by noweshedakram on 3/12/22.
 */

@Module
@InstallIn(SingletonComponent::class)
class DataSourceModule {

    @Provides
    @Singleton
    fun providesRemoteDataSource(apiService: ApiService): RemoteDataSource {
        return RemoteDataSourceImpl(apiService = apiService)
    }

    @Singleton
    @Provides
    fun providesLocalDataSource(coinDAO: CoinDAO): LocalDataSource {
        return LocalDataSourceImpl(coinDAO = coinDAO)
    }
}