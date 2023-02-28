package ru.alexandrsneg.composenotes.feature_note.data.repository

import kotlinx.coroutines.flow.Flow
import ru.alexandrsneg.composenotes.feature_note.data.data_source.NoteDao
import ru.alexandrsneg.composenotes.feature_note.domain.model.Note
import ru.alexandrsneg.composenotes.feature_note.domain.repository.INoteRepository

class NoteRepository(
    private val noteDao: NoteDao
): INoteRepository {
    override fun getNotes(): Flow<List<Note>> = noteDao.getNotes()

    override suspend fun getNoteById(id: Int): Note? = noteDao.getNoteById(id)

    override suspend fun insertNote(note: Note) {
        noteDao.insertNote(note)
    }

    override suspend fun deleteNote(note: Note) {
        noteDao.deleteNote(note)
    }
}