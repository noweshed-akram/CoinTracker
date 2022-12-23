package com.noweshed.cointracker.presentation.di

import android.app.Application
import androidx.room.Room
import com.google.gson.Gson
import com.noweshed.cointracker.data.db.CoinDAO
import com.noweshed.cointracker.data.db.CoinDatabase
import com.noweshed.cointracker.data.db.Converters
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 * Created by noweshedakram on 23/12/22.
 */
@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {

    @Singleton
    @Provides
    fun providesCryptoDatabase(app: Application, gson: Gson): CoinDatabase {
        return Room.databaseBuilder(app, CoinDatabase::class.java, "crypto_database")
            .fallbackToDestructiveMigration()
            .addTypeConverter(Converters(gson))
            .build()
    }

    @Singleton
    @Provides
    fun providesFlyBuyDAO(database: CoinDatabase): CoinDAO {
        return database.coinDao()
    }

}