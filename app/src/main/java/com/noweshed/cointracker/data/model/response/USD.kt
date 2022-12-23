package com.noweshed.cointracker.data.model.response

import androidx.annotation.NonNull
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

/**
 * Created by noweshedakram on 22/12/22.
 */
@Entity(tableName = "USD")
data class USD(
    @PrimaryKey(autoGenerate = false)
    @NonNull
    @SerializedName("id")
    var id: String,
    @SerializedName("price")
    var price: Double? = null,
    @SerializedName("volume_24h")
    var volume24h: Double? = null,
    @SerializedName("volume_24h_change_24h")
    var volume24hChange24h: Double? = null,
    @SerializedName("market_cap")
    var marketCap: Long? = null,
    @SerializedName("market_cap_change_24h")
    var marketCapChange24h: Double? = null,
    @SerializedName("percent_change_15m")
    var percentChange15m: Double? = null,
    @SerializedName("percent_change_30m")
    var percentChange30m: Double? = null,
    @SerializedName("percent_change_1h")
    var percentChange1h: Double? = null,
    @SerializedName("percent_change_6h")
    var percentChange6h: Double? = null,
    @SerializedName("percent_change_12h")
    var percentChange12h: Double? = null,
    @SerializedName("percent_change_24h")
    var percentChange24h: Double? = null,
    @SerializedName("percent_change_7d")
    var percentChange7d: Double? = null,
    @SerializedName("percent_change_30d")
    var percentChange30d: Double? = null,
    @SerializedName("percent_change_1y")
    var percentChange1y: Double? = null,
    @SerializedName("ath_price")
    var athPrice: Double? = null,
    @SerializedName("ath_date")
    var athDate: String? = null,
    @SerializedName("percent_from_price_ath")
    var percentFromPriceAth: Double? = null
)
