package com.noweshed.cointracker.data.db

import androidx.room.ProvidedTypeConverter
import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.noweshed.cointracker.data.model.response.Quotes
import javax.inject.Inject

/**
 * Created by noweshedakram on 23/12/22.
 */
@ProvidedTypeConverter
class Converters @Inject constructor(
    private val gson: Gson
) {
    @TypeConverter
    fun fromQuote(rating: Quotes): String {
        return gson.toJson(rating)
    }

    @TypeConverter
    fun toQuote(json: String): Quotes {
        val type = object : TypeToken<Quotes>() {}.type
        return gson.fromJson(json, type)
    }
}