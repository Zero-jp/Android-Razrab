package com.igor.android.mooddiary.note_list

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import com.igor.android.mooddiary.database.NoteDatabaseDao
import com.igor.android.mooddiary.database.NoteInfo
import kotlinx.coroutines.*

class NotesListViewModel(
    val dao: NoteDatabaseDao,
    application: Application
) : AndroidViewModel(application)  {

    private var viewModelJob = Job()

    private val uiScope = CoroutineScope(Dispatchers.Main + viewModelJob)

    var notes: LiveData<List<NoteInfo>>

    init {
        notes = dao.getAll()
    }

    fun getNotesList(): LiveData<List<NoteInfo>> {
        uiScope.launch {
            withContext(Dispatchers.IO) {
                notes = dao.getAll()
                // checkData(notes)
            }
        }
        return notes
    }
}