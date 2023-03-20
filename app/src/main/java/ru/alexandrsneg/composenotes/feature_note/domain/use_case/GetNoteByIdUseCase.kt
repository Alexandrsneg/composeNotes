package ru.alexandrsneg.composenotes.feature_note.domain.use_case

import ru.alexandrsneg.composenotes.feature_note.domain.repository.INoteRepository
import javax.inject.Inject

class GetNoteByIdUseCase @Inject constructor(
    private val noteRepository: INoteRepository
) {
    suspend fun invoke(noteId: Int) = noteRepository.getNoteById(noteId)
}