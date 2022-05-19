package com.igor.android.mooddiary.database

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface NoteDatabaseDao {
    @Insert
    fun insert(note: NoteInfo)

    @Update
    fun update(note: NoteInfo)

    @Delete
    fun delete(note: NoteInfo)

    @Query("SELECT * From note_table WHERE id = :key")
    fun get(key:Long): NoteInfo?

    @Query("SELECT * FROM note_table ORDER BY id DESC")
    fun getAll(): LiveData<List<NoteInfo>>
//
//    @Query("SELECT * FROM note_table WHERE status = :book_status")
//    fun getFilteredByStatus(book_status: Int): LiveData<List<NoteInfo>>
//
//    @Query("SELECT * FROM note_table WHERE author LIKE '%'||:book_author||'%'")
//    fun getFilteredByAuthor(book_author: String): LiveData<List<NoteInfo>>
//
//    @Query("SELECT * FROM note_table WHERE status = :book_status AND author LIKE '%'||:book_author||'%'")
//    fun getFilteredByAuthorAndStatus(
//        book_author: String,
//        book_status: Int
//    ): LiveData<List<NoteInfo>>
}