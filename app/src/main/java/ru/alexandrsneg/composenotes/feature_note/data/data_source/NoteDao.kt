package ru.alexandrsneg.composenotes.feature_note.data.data_source

import androidx.room.*
import kotlinx.coroutines.flow.Flow
import ru.alexandrsneg.composenotes.feature_note.domain.model.Note

@Dao
interface NoteDao {

    @Query("SELECT * FROM note")
    fun getNotes(): Flow<List<Note>>

}