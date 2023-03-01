package ru.alexandrsneg.composenotes.feature_note.presentation

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import ru.alexandrsneg.composenotes.feature_note.domain.model.Note
import ru.alexandrsneg.composenotes.feature_note.domain.use_case.NoteUseCases
import ru.alexandrsneg.composenotes.feature_note.domain.util.NoteOrder
import ru.alexandrsneg.composenotes.feature_note.domain.util.OrderType
import ru.alexandrsneg.composenotes.feature_note.presentation.notes.NotesEvent
import ru.alexandrsneg.composenotes.feature_note.presentation.notes.NotesState
import javax.inject.Inject

@HiltViewModel
class NotesViewModel @Inject constructor(
    private val notesUseCases: NoteUseCases
): ViewModel() {

    private val _state = mutableStateOf<NotesState>(NotesState())
    val state: State<NotesState> = _state

    private var recentlyDeletedNote: Note? = null

    private var getNotesJob: Job? = null

    init {
        getNotes(NoteOrder.Date(OrderType.DESC))
    }

    fun onEvent(notesEvent: NotesEvent) {
        val exceptionHandler = CoroutineExceptionHandler { _, throwable ->
            Log.d("IVANOV", "onEvent exception: ${throwable.message}" )
        }
        when(notesEvent) {
            is NotesEvent.DeleteNote -> {
                viewModelScope.launch(Dispatchers.IO + exceptionHandler) {
                    notesUseCases.deleteNoteUseCase.invoke(notesEvent.note)
                    recentlyDeletedNote = notesEvent.note
                }
            }
            is NotesEvent.Order -> {
                if (state.value.noteOrder == notesEvent.noteOrder &&
                        state.value.noteOrder.noteOrderType == notesEvent.noteOrder.noteOrderType)
                    return

                getNotes(notesEvent.noteOrder)
            }
            NotesEvent.RestoreNote -> {
                viewModelScope.launch(Dispatchers.IO + exceptionHandler) {
                    notesUseCases.addNoteUseCase.invoke(recentlyDeletedNote ?: return@launch)
                    recentlyDeletedNote = null
                }
            }
            NotesEvent.ToggleOrderSection -> {
                _state.value = state.value.copy(
                    isOrderSectionVisible = !state.value.isOrderSectionVisible
                )
            }
        }
    }

    private fun getNotes(noteOrder: NoteOrder) {
        getNotesJob?.cancel()
        getNotesJob = notesUseCases.getNotesUseCase.invoke(noteOrder)
            .onEach { notes ->
                _state.value = state.value.copy(
                    notes = notes,
                    noteOrder = noteOrder
                )
            }.launchIn(viewModelScope)
    }
}