package com.noweshed.cointracker.data.model.response

import com.google.gson.annotations.SerializedName

/**
 * Created by noweshedakram on 22/12/22.
 */
data class Quotes(
    @SerializedName("USD" ) var USD : USD? = USD()
)
