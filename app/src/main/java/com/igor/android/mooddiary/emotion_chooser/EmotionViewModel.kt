package com.igor.android.mooddiary.emotion_chooser

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.igor.android.mooddiary.database.NoteDatabaseDao
import com.igor.android.mooddiary.database.NoteInfo
import kotlinx.coroutines.*

class EmotionViewModel(
    val dao: NoteDatabaseDao,
    application: Application
) : AndroidViewModel(application) {

    private var viewModelJob = Job()

    private val uiScope = CoroutineScope(Dispatchers.Main + viewModelJob)

    fun onSaveNote(emoRange: Int) {
        uiScope.launch {
            withContext(Dispatchers.IO) {
                val note = dao.getLastNote()
                note.emotionRang = emoRange
                update(note)
            }
        }
    }

    private suspend fun update(note: NoteInfo) {
        withContext(Dispatchers.IO) {
            dao.update(note)
        }
    }
}