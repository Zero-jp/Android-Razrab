package com.igor.android.mooddiary.database

import android.content.Context
import com.igor.android.mooddiary.R

enum class TimeRange(private val code: Int) {
    Morning(0),
    Day(1),
    Afternoon(2),
    Night(3),
    HoleDay(4);

    fun getLabel(context: Context): String {
        when (code) {
            0 -> return context.getString(R.string.morning)
            1 -> return context.getString(R.string.day)
            2 -> return context.getString(R.string.afternoon)
            3 -> return context.getString(R.string.night)
            4 -> return context.getString(R.string.hole_day)
        }

        return ""
    }

}


enum class TimeRangeSelect(private val code: Int) {
    Morning(0),
    Day(1),
    Afternoon(2),
    Night(3),
    HoleDay(4),
    NotSelected(5);

    fun getLabel(context: Context): String {
        when (code) {
            0 -> return context.getString(R.string.morning)
            1 -> return context.getString(R.string.day)
            2 -> return context.getString(R.string.afternoon)
            3 -> return context.getString(R.string.night)
            4 -> return context.getString(R.string.hole_day)
            5 -> return ""
        }

        return ""
    }

}
