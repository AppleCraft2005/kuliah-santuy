package com.android.modul5.data.local.utils

import androidx.room.TypeConverter


class Converter {
    @TypeConverter
    fun ListStrtoStr(value: List<String>): String {
        return value.joinToString(", ")
    }
}