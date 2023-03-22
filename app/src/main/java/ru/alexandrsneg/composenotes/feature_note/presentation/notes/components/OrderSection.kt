package ru.alexandrsneg.composenotes.feature_note.presentation.notes.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import ru.alexandrsneg.composenotes.feature_note.domain.util.NoteOrder
import ru.alexandrsneg.composenotes.feature_note.domain.util.OrderType
import ru.alexandrsneg.composenotes.ui.theme.ComposeNotesTheme

@Composable
fun OrderSection(
    modifier: Modifier = Modifier,
    noteOrder: NoteOrder = NoteOrder.Date(OrderType.DESC),
    onOrderChange: (NoteOrder) -> Unit
) {
    Column(modifier = modifier) {
        Row() {
            DefaultRadioButton(
                text = "Title",
                selected = noteOrder is NoteOrder.Title,
                onSelect = {
                    onOrderChange(NoteOrder.Title(noteOrder.noteOrderType))
                },
                modifier = Modifier.wrapContentSize()
            )
            DefaultRadioButton(
                text = "Date",
                selected = noteOrder is NoteOrder.Date,
                onSelect = {
                    onOrderChange(NoteOrder.Date(noteOrder.noteOrderType))
                },
                modifier = Modifier.wrapContentSize()
            )
            DefaultRadioButton(
                text = "Color",
                selected = noteOrder is NoteOrder.Color,
                onSelect = {
                    onOrderChange(NoteOrder.Color(noteOrder.noteOrderType))
                },
                modifier = Modifier.wrapContentSize()
            )
        }

        Row() {
            DefaultRadioButton(
                text = "Ascending",
                selected = noteOrder.noteOrderType == OrderType.ASC,
                onSelect = {
                    onOrderChange(noteOrder.clone(OrderType.ASC))
                },
                modifier = Modifier.wrapContentSize()
            )
            DefaultRadioButton(
                text = "Descending",
                selected = noteOrder.noteOrderType == OrderType.DESC,
                onSelect = {
                    onOrderChange(noteOrder.clone(OrderType.DESC))
                },
                modifier = Modifier.wrapContentSize()
            )
        }
    }


}

@Preview(showBackground = true)
@Composable
fun PreviewOrderSection() {
    ComposeNotesTheme() {
        OrderSection(
            modifier = Modifier.wrapContentSize(),
            onOrderChange = {

            }
        )

    }
}
