package com.android.modul5.data.local.utils

import androidx.room.TypeConverter


class Converter {
    @TypeConverter
    fun fromListToStr(value: List<String>): String {
        return value.joinToString(", ")
    }

    @TypeConverter
    fun fromStrToList(value: String): List<String> {
        if (value.isEmpty()) {return emptyList()}
        return value.split(", ").map { it.trim() }
    }
}