package com.example.testapp.githubbrowsersampleclone.db

import androidx.room.TypeConverter
import timber.log.Timber
import java.lang.NumberFormatException

object GithubTypeConverters {
    @TypeConverter
    @JvmStatic
    fun stringtoIntList(data: String?): List<Int>? {// StringをList<Int>に変換する関数。
        return data?.let {
            it.split(",").map {
                try {
                    it.toInt()
                }
                catch (ex: NumberFormatException) {
                    Timber.e(ex, "Cannot convert $it to number")
                    null
                }
            }
        }?.filterNotNull()
    }

    @TypeConverter
    @JvmStatic
    fun intListToString(ints: List<Int>?): String? {// List<Int>をStringに変換する関数。
        return ints?.joinToString (",")
    }
}