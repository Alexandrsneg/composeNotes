package ru.alexandrsneg.composenotes.feature_note.presentation.notes.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ru.alexandrsneg.composenotes.ui.theme.ComposeNotesTheme

@Composable
fun DefaultRadioButton(
    text: String,
    selected: Boolean,
    onSelect: () -> Unit,
    modifier: Modifier
) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.Start,
        verticalAlignment = Alignment.CenterVertically
    ) {
        RadioButton(
            selected = selected,
            onClick = onSelect,
            colors = RadioButtonDefaults.colors(
                selectedColor = MaterialTheme.colors.primary,
                unselectedColor = MaterialTheme.colors.onBackground
            )
        )
        Text(
            text = text,
            modifier = Modifier.padding(end = 4.dp),
            style = MaterialTheme.typography.body1
        )
    }

}

@Preview(showBackground = true)
@Composable
fun PreviewDefaultButton() {
    ComposeNotesTheme() {
        DefaultRadioButton(
            text = "Button text",
            selected = true,
            onSelect = {

            },
            modifier = Modifier.wrapContentSize()
        )

    }
}