package com.igor.android.mooddiary.database


import android.content.Context
import android.content.res.Resources
import com.igor.android.mooddiary.R



enum class EmoStatus(private val code: Int) {
    Happy(0),
    Normal(1),
    Unhappy(2);


    fun getLabel(context: Context): String {
        when (code) {
            0 -> return context.getString(R.string.happy_emotion)
            1 -> return context.getString(R.string.normal_emotion)
            2 -> return context.getString(R.string.unhappy_emotion)
        }

        return ""
    }

}


enum class EmoStatusSelect(private val code: Int) {
    Happy(0),
    Normal(1),
    Unhappy(2),
    NotSelected(3);

    fun getLabel(context: Context): String {
        when (code) {
            0 -> return context.getString(R.string.happy_emotion)
            1 -> return context.getString(R.string.normal_emotion)
            2 -> return context.getString(R.string.unhappy_emotion)
            3 -> return ""
        }

        return ""
    }

}