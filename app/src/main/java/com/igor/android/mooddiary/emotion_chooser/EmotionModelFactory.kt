package com.igor.android.mooddiary.emotion_chooser

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.igor.android.mooddiary.database.NoteDatabaseDao
import com.igor.android.mooddiary.emotion_chooser.EmotionViewModel

class EmotionModelFactory(
        private val dao: NoteDatabaseDao,
        private val application: Application
    ) : ViewModelProvider.Factory {
        @Suppress("unchecked_cast")
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(EmotionViewModel::class.java)) {
                return EmotionViewModel(dao, application) as T
            }
            throw IllegalAccessException("Unknown ViewModel class")
        }
    }