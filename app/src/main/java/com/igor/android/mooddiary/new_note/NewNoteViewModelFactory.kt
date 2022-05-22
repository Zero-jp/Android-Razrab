package com.igor.android.mooddiary.new_note

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.igor.android.mooddiary.database.NoteDatabaseDao

class NewNoteViewModelFactory(
    private val dao: NoteDatabaseDao,
    private val application: Application) : ViewModelProvider.Factory {
    @Suppress("unchecked_cast")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(NewNoteViewModel::class.java)) {
            return NewNoteViewModel(dao, application) as T
        }
        throw IllegalAccessException("Unknown ViewModel class")
    }
}