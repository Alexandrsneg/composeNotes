package ru.alexandrsneg.composenotes.feature_note.presentation.add_edit_note.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusState
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import ru.alexandrsneg.composenotes.ui.theme.ComposeNotesTheme

@Composable
fun TransparentHintTextField(
    text: String,
    hint: String,
    modifier: Modifier = Modifier,
    onValueChange: (String) -> Unit,
    textStyle: TextStyle = TextStyle.Default,
    singleLine: Boolean = false,
    isHintVisible: Boolean = false,
    onFocusChange: (FocusState) -> Unit
) {
    Box(
        modifier = modifier
    ) {
        BasicTextField(
            value = text,
            onValueChange = onValueChange,
            singleLine = singleLine,
            textStyle = textStyle,
            modifier = Modifier
                .fillMaxWidth()
                .onFocusChanged {
                    onFocusChange(it)
                }
        )
        if (isHintVisible)
            Text(text = hint, style = textStyle, color = Color.DarkGray)
    }

}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposeNotesTheme {
        TransparentHintTextField(
            text = "text",
            hint = "sssss",
            onValueChange = {

            },
            onFocusChange = {

            },
            isHintVisible = false
        )
    }
}