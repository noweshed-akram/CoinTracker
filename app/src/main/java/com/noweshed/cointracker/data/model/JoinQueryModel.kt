package com.noweshed.cointracker.data.model

import androidx.room.Embedded
import com.noweshed.cointracker.data.model.response.Coin
import com.noweshed.cointracker.data.model.response.USD

/**
 * Created by noweshedakram on 23/12/22.
 */
class JoinQueryModel {

    @Embedded
    var coin: Coin? = null

    @Embedded
    var usd: USD? = null
}