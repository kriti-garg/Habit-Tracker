package com.example.kriti.habittrackerapp;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.kriti.habittrackerapp.data.HabitContract;
import com.example.kriti.habittrackerapp.data.HabitDbHelper;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        HabitDbHelper habitDbHelper = new HabitDbHelper(this);
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
        String dateString = formatter.format(date);

        habitDbHelper.insertHabit(dateString, "Programming", "I love programming");
        habitDbHelper.insertHabit(dateString, "Singing", "I love singing songs");
        Cursor cursor = habitDbHelper.readHabits();
        while (cursor.moveToNext()) {
            Log.v(TAG, "habit: " + cursor.getInt(0) + " " + cursor.getString(1) +
                    " " + cursor.getString(2) + " " + cursor.getString(3));
        }
    }

}
