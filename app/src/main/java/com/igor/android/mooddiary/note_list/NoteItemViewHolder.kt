package com.igor.android.mooddiary.note_list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.igor.android.mooddiary.R

class NoteItemViewHolder(itemView: View) :
    RecyclerView.ViewHolder(itemView) {
    // val qualityImage: ImageView = itemView.findViewById(R.id.quality_image)
    val noteDate: TextView = itemView.findViewById(R.id.date_view)
    val noteTimeRange: TextView = itemView.findViewById(R.id.time_range_view)
    val noteBody: TextView = itemView.findViewById(R.id.body_view)
    val noteEmotionImage: ImageView = itemView.findViewById(R.id.image_emo)
    val noteEmotionText: TextView = itemView.findViewById(R.id.text_emo)


    companion object {
        fun from(parent: ViewGroup,): NoteItemViewHolder {
            val layoutInflater = LayoutInflater.from(parent.context)
            val view = layoutInflater
                .inflate(R.layout.fragment_item, parent, false)
            return NoteItemViewHolder(view)
        }
    }
}