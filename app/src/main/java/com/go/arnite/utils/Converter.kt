package com.go.arnite.utils

import com.google.gson.Gson

object Converter {
    inline fun <reified T> toObject(json: String): T =
        Gson().fromJson(json, T::class.java)
}