package com.igor.android.mooddiary.note_list

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.igor.android.mooddiary.database.NoteDatabaseDao
import com.igor.android.mooddiary.database.NoteInfo
import kotlinx.coroutines.*

class MyItemRecyclerViewViewModel(
    val dao: NoteDatabaseDao,
    application: Application
) : AndroidViewModel(application)  {

    private var viewModelJob = Job()

    private val uiScope = CoroutineScope(Dispatchers.Main + viewModelJob)

    private var notes: LiveData<List<NoteInfo>>? = null

    fun getNotesList(): LiveData<List<NoteInfo>>? {
        uiScope.launch {
            withContext(Dispatchers.IO) {
                notes = dao.getAll()
                // checkData(notes)
            }
        }
        return notes
    }

//    private suspend fun checkData(notes: LiveData<List<NoteInfo>>) {
//        withContext(Dispatchers.IO) {
//            проверка входных данных
//        }
//    }
}