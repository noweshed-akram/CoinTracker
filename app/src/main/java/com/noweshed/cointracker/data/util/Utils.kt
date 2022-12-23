package com.noweshed.cointracker.data.util

/**
 * Created by noweshedakram on 23/12/22.
 */
object Utils {

    fun formatPrice(price: Double?): String {
        return String.format("%.2f", price).toDouble().toString()
    }
}