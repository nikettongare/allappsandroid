package com.example.allapps;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHandler extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "BMI_CALCULATOR";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_NAME = "bmi_history";

    private static final String KEY_ID = "id";
    private static final String KEY_HEIGHT = "height";
    private static final String KEY_WEIGHT = "weight";
    private static final String KEY_BMI = "bmi";
    private static final String KEY_DATE = "date";
    public DatabaseHandler(Context context)
    {
        super(context,DATABASE_NAME,null,DATABASE_VERSION);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTable = "CREATE TABLE " + TABLE_NAME + " (" +
                KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                KEY_HEIGHT + " DOUBLE NOT NULL," +
                KEY_WEIGHT + " DOUBLE NOT NULL," +
                KEY_BMI + " DOUBLE NOT NULL," +
                KEY_DATE + " TEXT NOT NULL" + ")";
        db.execSQL(createTable);
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    // Adding new record
    public void addRecord(double height, double weight, double bmi, String date) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(KEY_HEIGHT, height);
        values.put(KEY_WEIGHT, weight);
        values.put(KEY_BMI, bmi);
        values.put(KEY_DATE, date);

        db.insert(TABLE_NAME, null, values);
        db.close();
    }

    // Retrieve all rows from the database
    public List<String> getAllData() {
        List<String> data = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_NAME, null);
        if (cursor.moveToFirst()) {
            do {
                data.add("ID:" + cursor.getString(0) +
                        ", HEIGHT:" + cursor.getString(1) +
                        ", WEIGHT:" + cursor.getString(2) +
                        ", BMI:" + cursor.getString(3) +
                        ", DATE:" + cursor.getString(4)
                        );
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return data;
    }

    // Delete a row from the database
    public int deleteData(String id) {
        SQLiteDatabase db = this.getWritableDatabase();
        int result = db.delete(TABLE_NAME, KEY_ID + "=?", new String[]{id});
        db.close();
        return result;
    }
}

