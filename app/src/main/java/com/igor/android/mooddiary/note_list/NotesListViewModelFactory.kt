package com.igor.android.mooddiary.note_list

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.igor.android.mooddiary.database.NoteDatabaseDao

class NotesListViewModelFactory(
    private val dao: NoteDatabaseDao,
    private val application: Application
) : ViewModelProvider.Factory {
    @Suppress("unchecked_cast")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(NotesListViewModel::class.java)) {
            return NotesListViewModel(dao, application) as T
        }
        throw IllegalAccessException("Unknown ViewModel class")
    }
}
