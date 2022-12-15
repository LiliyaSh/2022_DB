package com.example.todolist;

import android.app.Application;

import androidx.room.Room;

import com.example.todolist.data.AppDatabase;
import com.example.todolist.data.NoteDao;

public class App extends Application {

    private NoteDao noteDao;

    private static App instance;

    public static App getInstance() {
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        instance = this;

        AppDatabase database = Room.databaseBuilder(getApplicationContext(),
                AppDatabase.class, "app-db-name")
                .allowMainThreadQueries()
                .build();

        noteDao = database.noteDao();
    }

    public NoteDao getNoteDao() {
        return noteDao;
    }
}
