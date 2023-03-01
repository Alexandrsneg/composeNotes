package ru.alexandrsneg.composenotes.feature_note.domain.use_case

import ru.alexandrsneg.composenotes.feature_note.domain.model.InvalidNoteException
import ru.alexandrsneg.composenotes.feature_note.domain.model.Note
import ru.alexandrsneg.composenotes.feature_note.domain.repository.INoteRepository
import javax.inject.Inject

data class AddNoteUseCase @Inject constructor(
    private val noteRepository: INoteRepository
) {
    @Throws(InvalidNoteException::class)
    suspend fun invoke(note: Note) {
        if (note.title.isBlank())
            throw InvalidNoteException("Title of the note can't be empty")
        if (note.content.isBlank())
            throw InvalidNoteException("Content of the note can't be empty")
        noteRepository.insertNote(note)
    }
}
