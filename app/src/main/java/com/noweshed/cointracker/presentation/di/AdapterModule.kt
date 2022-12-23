package com.noweshed.cointracker.presentation.di

import com.noweshed.cointracker.presentation.adapter.CoinAdapter
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
class AdapterModule {
    @Singleton
    @Provides
    fun providesHomeAdapter() : CoinAdapter {
        return CoinAdapter()
    }
}