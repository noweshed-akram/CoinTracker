package com.noweshed.cointracker.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.noweshed.cointracker.data.model.JoinQueryModel
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

    @Insert
    suspend fun addCryptoUSD(usd: USD)

    @Query("select * from CryptoCoin as cc inner join USD on cc.id = coinId order by cc.rank asc limit:limit ")
    fun coinListItems(limit: Int): List<JoinQueryModel>

}