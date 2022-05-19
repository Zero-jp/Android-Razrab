package com.igor.android.mooddiary.new_note

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import androidx.room.ColumnInfo
import com.igor.android.mooddiary.database.NoteDatabaseDao
import com.igor.android.mooddiary.database.NoteInfo
import com.igor.android.mooddiary.databinding.FragmentNewNoteBinding

class NewNoteViewModel(val dao: NoteDatabaseDao,
                        application: Application): AndroidViewModel(application) {
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