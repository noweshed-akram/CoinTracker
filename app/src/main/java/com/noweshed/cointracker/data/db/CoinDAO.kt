package com.noweshed.cointracker.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.noweshed.cointracker.data.model.response.Coin
import com.noweshed.cointracker.data.model.response.USD
import kotlinx.coroutines.flow.Flow

/**
 * Created by noweshedakram on 22/12/22.
 */
@Dao
interface CoinDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addCryptoCoin(coin: Coin)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addCryptoUSD(usd: USD)

    @Query("select * from CryptoCoin")
    fun coinListItems(): Flow<List<Coin>>

    @Query("select * from usd")
    fun usdListItems(): Flow<List<USD>>

}