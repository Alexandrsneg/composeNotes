package ru.alexandrsneg.composenotes.feature_note.presentation

sealed class UiEvent {
    data class ShowSnackBar(val text: String): UiEvent()
    object SavedNote: UiEvent()
}
