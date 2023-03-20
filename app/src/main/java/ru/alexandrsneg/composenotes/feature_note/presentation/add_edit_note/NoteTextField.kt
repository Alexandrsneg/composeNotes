package ru.alexandrsneg.composenotes.feature_note.presentation.add_edit_note

data class NoteTextField(
    val text: String = "",
    val hint: String = "",
    val isHintVisible: Boolean = false
) {
}