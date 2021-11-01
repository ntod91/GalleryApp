package com.typeqast.core.utils

import android.content.Context
import android.content.SharedPreferences

object Cashing {
    lateinit var sharedPreferences: SharedPreferences

    fun initialize(context: Context, locationName: String) {
        sharedPreferences = context
            .getSharedPreferences(
                locationName,
                Context.MODE_PRIVATE
            )
    }


    fun store(key: String, value: Any?) {
        when (value) {
            is String? -> sharedPreferences.edit().putString(key, value).apply()
            is Int -> sharedPreferences.edit().putInt(key, value).apply()
            is Boolean -> sharedPreferences.edit().putBoolean(key, value).apply()
            is Float -> sharedPreferences.edit().putFloat(key, value).apply()
            is Long -> sharedPreferences.edit().putLong(key, value).apply()
            else -> throw UnsupportedOperationException("Not yet implemented")
        }
    }

    inline fun <reified T : Any> read(key: String, defaultValue: T? = null): T? {
        return when (T::class) {
            String::class -> sharedPreferences.getString(key, defaultValue as? String) as T?
            Int::class -> sharedPreferences.getInt(key, defaultValue as? Int ?: -1) as T?
            Boolean::class -> sharedPreferences.getBoolean(
                key,
                defaultValue as? Boolean ?: false
            ) as T?
            Float::class -> sharedPreferences.getFloat(key, defaultValue as? Float ?: -1f) as T?
            Long::class -> sharedPreferences.getLong(key, defaultValue as? Long ?: -1) as T?
            else -> throw UnsupportedOperationException("Not implemented")
        }
    }
}