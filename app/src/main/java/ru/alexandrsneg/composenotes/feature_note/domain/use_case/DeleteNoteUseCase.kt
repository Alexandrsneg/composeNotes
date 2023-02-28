package ru.alexandrsneg.composenotes.feature_note.domain.use_case

import ru.alexandrsneg.composenotes.feature_note.domain.model.Note
import ru.alexandrsneg.composenotes.feature_note.domain.repository.INoteRepository

class DeleteNoteUseCase(
    private val repository: INoteRepository
) {
    suspend operator fun invoke(note: Note) {
        repository.deleteNote(note)
    }
}