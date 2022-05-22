package com.igor.android.mooddiary.new_note

import android.app.Application
import android.provider.ContactsContract
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.room.ColumnInfo
import com.igor.android.mooddiary.database.NoteDatabaseDao
import com.igor.android.mooddiary.database.NoteInfo
import com.igor.android.mooddiary.databinding.FragmentNewNoteBinding
import kotlinx.coroutines.*
import java.time.LocalDate
import java.util.*

class NewNoteViewModel(
    val dao: NoteDatabaseDao,
    application: Application): AndroidViewModel(application) {

    private var viewModelJob = Job()

    private val uiScope = CoroutineScope(Dispatchers.Main + viewModelJob)

//    private val notes = dao.getAll()

    // private var newNote = MutableLiveData<NoteInfo?>()

//    private fun initNewNote() {
//        uiScope.launch {
//            newNote.value = getNoteFromDao()
//        }
//    }

//    private suspend fun getNoteFromDao(): NoteInfo? {
//        return withContext(Dispatchers.IO) {
//            var note = dao.getNote()
//            return@withContext note
//        }
//    }
//
//    override fun onCleared() {
//        super.onCleared()
//        viewModelJob.cancel()
//    }

    fun onEmotionChooser(note: NoteInfo) {
        uiScope.launch {
            insert(note)
        }
    }

    private suspend fun insert(note: NoteInfo) {
        withContext(Dispatchers.IO) {
            dao.insert(note)
        }
    }
//
//    private lateinit var binding: FragmentNewNoteBinding
//
//    // private val noteInfo = NoteInfo.create()
//
//    private val dateField = ""
//
//    private val timeRangeField = ""
//
//    private val bodyField = ""
//
//    private val emotionField = ""
//
////    init {
////        saveData(noteInfo: NoteInfo)
////    }
//
//    fun validateBookInfo(noteInfo: NoteInfo): Boolean {
//
//        if (noteInfo.date.isEmpty())
//            return false
//
//        if (noteInfo.timeRange > 2 || noteInfo.timeRange < 0)
//            return false
//
//        return true
//    }
//
//    fun saveData(noteInfo: NoteInfo) {
//        binding.apply {
//            noteInfo.date = editTextDate.toString()
//            noteInfo.timeRange = spinnerTimeRange.selectedItemId.toInt()
//            noteInfo.body = editTextMultiLineNoteBody.toString()
//        }
//    }
}