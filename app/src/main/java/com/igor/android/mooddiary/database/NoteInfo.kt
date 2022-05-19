package com.igor.android.mooddiary.database

import android.os.Parcel
import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize
import kotlinx.parcelize.Parceler
import java.util.*

@Entity(tableName = "note_table")
@Parcelize
class NoteInfo() : Parcelable{
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var noteId: Long = 0L

    @ColumnInfo(name = "time_range")
    var timeRange: Int = 0

    @ColumnInfo(name = "date")
    var date: String = ""

    @ColumnInfo(name = "emotion_rang")
    var emotionRang: Int = 0

    @ColumnInfo(name = "body")
    var body: String = ""

    @ColumnInfo(name = "status")
    var status: Int = 0

    constructor(parcel: Parcel) : this() {
        timeRange = parcel.readInt()
        date = parcel.readString().toString()
        emotionRang = parcel.readInt()
        body = parcel.readString().toString()
        status = parcel.readInt()
    }

    companion object : Parceler<NoteInfo> {

        override fun NoteInfo.write(parcel: Parcel, flags: Int) {
            parcel.writeInt(timeRange)
            parcel.writeString(date)
            parcel.writeInt(emotionRang)
            parcel.writeString(body)
            parcel.writeInt(status)
        }

        override fun create(parcel: Parcel): NoteInfo {
            return NoteInfo(parcel)
        }
    }
}