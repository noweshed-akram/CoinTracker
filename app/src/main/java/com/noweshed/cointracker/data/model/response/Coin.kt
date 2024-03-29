package com.noweshed.cointracker.data.model.response

import androidx.annotation.NonNull
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

/**
 * Created by noweshedakram on 21/12/22.
 */
@Entity(tableName = "CryptoCoin", indices = [Index(value = ["id"], unique = true)])
data class Coin(
    @PrimaryKey(autoGenerate = false)
    @NonNull
    @SerializedName("id")
    var id: String,
    @SerializedName("name")
    var name: String? = null,
    @SerializedName("symbol")
    var symbol: String? = null,
    @SerializedName("rank")
    var rank: Int? = null,
    @SerializedName("circulating_supply")
    var circulatingSupply: Long? = null,
    @SerializedName("total_supply")
    var totalSupply: Long? = null,
    @SerializedName("max_supply")
    var maxSupply: Long? = null,
    @SerializedName("beta_value")
    var betaValue: Double? = null,
    @SerializedName("first_data_at")
    var firstDataAt: String? = null,
    @SerializedName("last_updated")
    var lastUpdated: String? = null,
    @SerializedName("quotes")
    var quotes: Quotes? = Quotes()
)
