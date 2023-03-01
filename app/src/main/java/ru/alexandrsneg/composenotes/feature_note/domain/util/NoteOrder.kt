package ru.alexandrsneg.composenotes.feature_note.domain.util

sealed class NoteOrder(val noteOrderType: OrderType) {
    data class Title(val orderType: OrderType): NoteOrder(orderType)
    data class Date(val orderType: OrderType): NoteOrder(orderType)
    data class Color(val orderType: OrderType): NoteOrder(orderType)
}
