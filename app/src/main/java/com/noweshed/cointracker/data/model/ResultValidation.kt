package com.noweshed.cointracker.data.model

/**
 * Created by noweshedakram on 21/12/22.
 */
data class ResultValidation(
    val successful: Boolean,
    val error: String? = null
)
