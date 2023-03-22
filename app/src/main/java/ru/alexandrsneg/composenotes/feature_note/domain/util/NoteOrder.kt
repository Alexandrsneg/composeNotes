package ru.alexandrsneg.composenotes.feature_note.domain.util

sealed class NoteOrder(val noteOrderType: OrderType) {
    data class Title(val orderType: OrderType): NoteOrder(orderType)
    data class Date(val orderType: OrderType): NoteOrder(orderType)
    data class Color(val orderType: OrderType): NoteOrder(orderType)

    fun clone(noteOrderType: OrderType): NoteOrder =
        when (this) {
            is Color -> Color(noteOrderType)
            is Date -> Date(noteOrderType)
            is Title -> Title(noteOrderType)
        }
}
