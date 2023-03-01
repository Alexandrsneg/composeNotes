package ru.alexandrsneg.composenotes.feature_note.presentation.notes

import ru.alexandrsneg.composenotes.feature_note.domain.model.Note
import ru.alexandrsneg.composenotes.feature_note.domain.util.NoteOrder
import ru.alexandrsneg.composenotes.feature_note.domain.util.OrderType


data class NotesState(
    val notes: List<Note> = emptyList(),
    val noteOrder: NoteOrder = NoteOrder.Date(OrderType.DESC),
    val isOrderSectionVisible: Boolean = false
) {

}
