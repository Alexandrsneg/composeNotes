package ru.alexandrsneg.composenotes.feature_note.presentation.add_edit_note

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.graphics.toArgb
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import ru.alexandrsneg.composenotes.feature_note.domain.model.Note
import ru.alexandrsneg.composenotes.feature_note.domain.use_case.NoteUseCases
import ru.alexandrsneg.composenotes.feature_note.presentation.UiEvent
import javax.inject.Inject

@HiltViewModel
class AddEditNoteViewModel @Inject constructor(
    private val noteUseCases: NoteUseCases,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val _noteTitleState = mutableStateOf(NoteTextField(hint = "Type some title"))
    var noteTitleState: State<NoteTextField> = _noteTitleState

    private val _noteContentState = mutableStateOf(NoteTextField(hint = "Type some content"))
    var noteContentState: State<NoteTextField> = _noteContentState

    private val _noteColorState = mutableStateOf(Note.noteColor.random().toArgb())
    var noteColorState: State<Int> = _noteColorState

    private val _eventFlow = MutableSharedFlow<UiEvent>()
    var eventFlow = _eventFlow.asSharedFlow()

    var currentNoteId: Int? = null

    init {
        savedStateHandle.get<Int>("noteId")?.let {
            if (it != -1) {
                viewModelScope.launch(Dispatchers.Main) {
                    val note = withContext(Dispatchers.IO) {
                        noteUseCases.getNoteByIdUseCase.invoke(it)
                    }
                    currentNoteId = note?.id ?: -1
                    _noteTitleState.value = noteTitleState.value.copy(
                        text = note?.title ?: "Something goes wrong",
                        isHintVisible = false
                    )

                    _noteContentState.value = noteContentState.value.copy(
                        text = note?.content ?: "Something goes wrong",
                        isHintVisible = false
                    )
                    _noteColorState.value = note?.color ?: -1
                }
            }
        }
    }

    fun onEvent(event: AddEditNoteEvent) {
        when (event) {
            is AddEditNoteEvent.ChangeColor -> _noteColorState.value = event.color
            is AddEditNoteEvent.EnteredContent -> {
                _noteContentState.value = noteContentState.value.copy(
                    text = event.text
                )
            }
            is AddEditNoteEvent.ChangeContentFocus -> {
                _noteContentState.value = noteContentState.value.copy(
                    isHintVisible = !event.focusState.isFocused &&
                            noteContentState.value.text.isBlank()
                )
            }
            is AddEditNoteEvent.EnteredTitle -> {
                _noteTitleState.value = noteTitleState.value.copy(
                    text = event.text
                )
            }
            is AddEditNoteEvent.ChangeTitleFocus -> {
                _noteTitleState.value = noteTitleState.value.copy(
                    isHintVisible = !event.focusState.isFocused &&
                            noteTitleState.value.text.isBlank()
                )
            }
            AddEditNoteEvent.SaveNote -> {
                viewModelScope.launch {
                    try {
                        noteUseCases.addNoteUseCase.invoke(
                            Note(
                                title = noteTitleState.value.text,
                                content = noteContentState.value.text,
                                color = noteColorState.value,
                                timestamp = System.currentTimeMillis(),
                                id = currentNoteId
                            )
                        )
                        _eventFlow.emit(UiEvent.SavedNote)
                    } catch (e: Exception) {
                        _eventFlow.emit(UiEvent.ShowSnackBar(e.message ?: "Cant save note"))
                    }

                }

            }
        }
    }

}