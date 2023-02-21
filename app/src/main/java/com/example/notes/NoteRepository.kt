package com.example.notes

import androidx.lifecycle.LiveData
import androidx.room.Dao

class NoteRepository(private val dao:NoteDao) {

    val allNotes : LiveData<List<Note>> = dao.getAllNotes()

    suspend fun insert(note:Note){

        dao.insert(note)
    }
    suspend fun delete(note:Note){

        dao.delete(note)
    }
}