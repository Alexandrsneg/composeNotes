package ru.alexandrsneg.composenotes.di

import android.app.Application
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ru.alexandrsneg.composenotes.feature_note.data.data_source.NoteDao
import ru.alexandrsneg.composenotes.feature_note.data.data_source.NoteDatabase
import ru.alexandrsneg.composenotes.feature_note.data.repository.NoteRepository
import ru.alexandrsneg.composenotes.feature_note.domain.repository.INoteRepository
import ru.alexandrsneg.composenotes.feature_note.domain.use_case.*
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideRNoteDB(app: Application): NoteDatabase =
        Room.databaseBuilder(
            app,
            NoteDatabase::class.java,
            NoteDatabase.DATABASE_NAME
        ).build()


    @Provides
    @Singleton
    fun provideNoteRepository(noteDb: NoteDatabase): INoteRepository =
        NoteRepository(noteDb.noteDao)


    @Provides
    @Singleton
    fun provideNoteUseCases(noteRepository: INoteRepository): NoteUseCases =
        NoteUseCases(
            getNotesUseCase = GetNotesUseCase(noteRepository),
            deleteNoteUseCase = DeleteNoteUseCase(noteRepository),
            addNoteUseCase = AddNoteUseCase(noteRepository),
            getNoteByIdUseCase = GetNoteByIdUseCase(noteRepository)
        )

}