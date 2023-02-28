package ru.alexandrsneg.composenotes.feature_note.domain.use_case

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import ru.alexandrsneg.composenotes.feature_note.domain.model.Note
import ru.alexandrsneg.composenotes.feature_note.domain.repository.INoteRepository
import ru.alexandrsneg.composenotes.feature_note.domain.util.NoteOrder
import ru.alexandrsneg.composenotes.feature_note.domain.util.OrderType

class GetNotesUseCase(
    private val noteRepository: INoteRepository
) {
    operator fun invoke(
        noteOrder: NoteOrder = NoteOrder.Date(OrderType.DESC)
    ): Flow<List<Note>> = noteRepository.getNotes().map { notes->
        when (noteOrder.orderType) {
            OrderType.ASC -> {
                when(noteOrder) {
                    is NoteOrder.Title -> notes.sortedBy { it.title.lowercase() }
                    is NoteOrder.Date -> notes.sortedBy { it.timestamp }
                    is NoteOrder.Color -> notes.sortedBy { it.color }
                }
            }
            OrderType.DESC -> {
                when(noteOrder) {
                    is NoteOrder.Title -> notes.sortedByDescending { it.title.lowercase() }
                    is NoteOrder.Date -> notes.sortedByDescending { it.timestamp }
                    is NoteOrder.Color -> notes.sortedByDescending { it.color }
                }
            }
        }

    }
}