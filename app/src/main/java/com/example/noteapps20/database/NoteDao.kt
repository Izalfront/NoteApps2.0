package com.example.noteapps20.database

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.noteapps20.model.Note

@Dao
interface NoteDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun inserNote(note : Note)

    @Update
    suspend fun updateNote(note: Note)

    @Delete()
    suspend fun deleteNote(note: Note)

    @Query("SELECT * FROM  NOTES ORDER BY id DESC")
    fun getAllNotes(): LiveData<List<Note>>

    @Query("SELECT * FROM NOTES WHERE noteTitle LIKE :query OR noteDesc LIKE :query")
    fun searchNote(query : String?): LiveData<List<Note>>
}