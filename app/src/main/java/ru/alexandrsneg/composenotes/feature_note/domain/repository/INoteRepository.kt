package ru.alexandrsneg.composenotes.feature_note.domain.repository

import kotlinx.coroutines.flow.Flow
import ru.alexandrsneg.composenotes.feature_note.domain.model.Note

interface INoteRepository {
    fun getNotes(): Flow<List<Note>>
    suspend fun getNoteById(id: Int): Note?
    suspend fun insertNote(note: Note)
    suspend fun deleteNote(note: Note)
}