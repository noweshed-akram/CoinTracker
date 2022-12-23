package com.noweshed.cointracker.presentation.di

import android.app.Application
import com.noweshed.cointracker.domain.usecase.CoinUseCase
import com.noweshed.cointracker.presentation.viewmodel.CryptoViewModel
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
class ViewModelModule {

    @Singleton
    @Provides
    fun providesProductViewModel(
        app: Application,
        coinUseCase: CoinUseCase
    ): CryptoViewModel {
        return CryptoViewModel(app, coinUseCase)
    }

}