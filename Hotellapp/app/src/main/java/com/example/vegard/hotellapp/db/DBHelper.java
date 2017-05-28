package com.example.vegard.hotellapp.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.vegard.hotellapp.User;

// Kilder: https://developer.android.com/training/basics/data-storage/databases.html
// https://developer.android.com/reference/android/database/sqlite/SQLiteOpenHelper.html
public class DBHelper extends SQLiteOpenHelper {
    private static String CREATE_TABLE = "CREATE TABLE " + DBSchema.TABLE_USERS +
            "(id INTEGER PRIMARY KEY," +
            DBSchema.COLUMN_USERNAME + " TEXT," +
            DBSchema.COLUMN_PASSWORD + " TEXT," +
            DBSchema.COLUMN_BONUSPOINTS + " INTEGER)";

    private static String DROP_TABLE = "DROP TABLE IF EXISTS " + DBSchema.TABLE_USERS;

    public DBHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE);

        ContentValues values = new ContentValues();
        values.put(DBSchema.COLUMN_USERNAME, "test");
        values.put(DBSchema.COLUMN_PASSWORD, "test");
        values.put(DBSchema.COLUMN_BONUSPOINTS, 20000);
        db.insert(DBSchema.TABLE_USERS, null, values);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(DROP_TABLE);
        onCreate(db);
    }

    public User getUser(String username) {
        SQLiteDatabase db = getReadableDatabase();
        String[] projection = {
                DBSchema.COLUMN_USERNAME,
                DBSchema.COLUMN_PASSWORD,
                DBSchema.COLUMN_BONUSPOINTS
        };

        String selection = DBSchema.COLUMN_USERNAME + " = ?";
        String[] selectionArgs = { username };

        Cursor cursor = db.query(DBSchema.TABLE_USERS, projection, selection, selectionArgs, null, null, null);
        if (cursor.getCount() == 0) {
            return null;
        }

        cursor.moveToFirst();
        User user = new User(cursor.getString(cursor.getColumnIndex(DBSchema.COLUMN_USERNAME)),
                            cursor.getString(cursor.getColumnIndex(DBSchema.COLUMN_PASSWORD)),
                            cursor.getInt(cursor.getColumnIndex(DBSchema.COLUMN_BONUSPOINTS)));

        return user;
    }

    public void updatePoints(String username, int points) {
        SQLiteDatabase db = this.getReadableDatabase();

        ContentValues values = new ContentValues();
        values.put(DBSchema.COLUMN_BONUSPOINTS, points);

        // Which row to update, based on the title
        String selection = DBSchema.COLUMN_USERNAME+ " LIKE ?";
        String[] selectionArgs = { username };

        int count = db.update(
                DBSchema.TABLE_USERS,
                values,
                selection,
                selectionArgs);

    }
}
