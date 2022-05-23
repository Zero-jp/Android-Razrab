package com.igor.android.mooddiary.note_list

import android.content.Context
import android.net.Uri
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.igor.android.mooddiary.R
import com.igor.android.mooddiary.database.NoteInfo

class NotesAdapter : RecyclerView.Adapter<NoteItemViewHolder>() {
    var data = listOf<NoteInfo>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    lateinit var context: Context

    lateinit var onNoteClick: (NoteInfo) -> Unit

    override fun getItemCount() = data.size

    override fun onBindViewHolder(holder: NoteItemViewHolder, position: Int) {
        val item = data[position]

        holder.noteDate.text = item.date

        when (item.timeRange) {
            0 -> holder.noteTimeRange.text = context.getString(R.string.morning)
            1 -> holder.noteTimeRange.text = context.getString(R.string.day)
            2 -> holder.noteTimeRange.text = context.getString(R.string.afternoon)
            3 -> holder.noteTimeRange.text = context.getString(R.string.night)
            4 -> holder.noteTimeRange.text = context.getString(R.string.hole_day)
        }

        holder.noteBody.text = item.body

        when (item.emotionRang) {
            0 -> {
                holder.noteEmotionImage.setImageResource(R.drawable.happy)
                holder.noteEmotionText.text = context.getString(R.string.happy_emotion)
            }
            1 -> {
                holder.noteEmotionImage.setImageResource(R.drawable.normal)
                holder.noteEmotionText.text = context.getString(R.string.normal_emotion)
            }
            2 -> {
                holder.noteEmotionImage.setImageResource(R.drawable.unhappy)
                holder.noteEmotionText.text = context.getString(R.string.unhappy_emotion)
            }
        }

//        holder.deleteButton.setOnClickListener {
//            onDeleteBookClick(item)
//        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteItemViewHolder {
        return NoteItemViewHolder.from(parent)
    }
}