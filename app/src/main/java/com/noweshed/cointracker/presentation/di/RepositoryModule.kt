package com.noweshed.cointracker.presentation.di

import com.noweshed.cointracker.data.repo.RepositoryImpl
import com.noweshed.cointracker.data.repo.datasource.RemoteDataSource
import com.noweshed.cointracker.domain.repo.CoinRepo
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
class RepositoryModule {

    @Provides
    @Singleton
    fun providesRepository(
        remoteDataSource: RemoteDataSource
    ): CoinRepo {
        return RepositoryImpl(
            remoteDataSource = remoteDataSource
        )
    }

}