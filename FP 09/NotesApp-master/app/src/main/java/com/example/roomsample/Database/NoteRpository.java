package com.example.roomsample.Database;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.example.roomsample.model.Note;
import com.example.roomsample.model.NoteDao;

import java.util.List;

public class NoteRpository {

    private NoteDao noteDao;
    private LiveData<List<Note>> mAllNotes;

    public NoteRpository(Application application) {
        NotesDatabase db = NotesDatabase.getDatabase(application);
        noteDao = db.getNotesDao();
        mAllNotes = noteDao.loadAllNotes();
    }

    public LiveData<List<Note>> getAllNotes() {
        return mAllNotes;
    }

    public void insert(Note note) {
        NotesDatabase.databaseWriteExecutor.execute(() -> {
            noteDao.insertNote(note);
        });
    }

    public void delete(Note note){
        NotesDatabase.databaseWriteExecutor.execute(() -> {
            noteDao.deleteNote(note);
        });
    }
}
