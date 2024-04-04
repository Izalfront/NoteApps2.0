package com.example.noteapps20.repository

import com.example.noteapps20.database.NoteDatabase
import com.example.noteapps20.model.Note

class NoteRepository(private val db: NoteDatabase) {
    suspend fun inserNote(note : Note) = db.getNoteDao().inserNote(note)
    suspend fun updateNote(note: Note) = db.getNoteDao().updateNote(note)
    suspend fun deleteNote(note: Note) = db.getNoteDao().deleteNote(note)

    fun getAllNotes() = db.getNoteDao().getAllNotes()
    fun searchNote(query : String?) = db.getNoteDao().searchNote(query)
}