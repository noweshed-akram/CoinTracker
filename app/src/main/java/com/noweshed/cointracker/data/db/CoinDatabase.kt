package com.noweshed.cointracker.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.noweshed.cointracker.data.model.response.Coin
import com.noweshed.cointracker.data.model.response.USD

/**
 * Created by noweshedakram on 22/12/22.
 */
@Database(entities = [Coin::class, USD::class], version = 1, exportSchema = false)
@TypeConverters(Converters::class)
abstract class CoinDatabase : RoomDatabase() {

    abstract fun coinDao(): CoinDAO
}