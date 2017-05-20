/**
 * Created by "Pratik Jethva"
 * Owned by "PJET APPS"
 * https://pjetapps.blogspot.in/
 */

package com.phjethva.login.signup.sqlite.database.helper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper{

    private static final int DB_VERSION = 1;
    private static final String DB_NAME = "LoginSignupSqliteDatabase";
    private static final String DB_TABLE = "user";
    private static final String KEY_ID = "id";
    private static final String KEY_USER_NAME = "un";
    private static final String KEY_EMAIL_ID = "ei";
    private static final String KEY_PASSWORD = "pw";

    public DBHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE "
                + DB_TABLE
                + "("
                + KEY_ID + " INTEGER PRIMARY KEY,"
                + KEY_USER_NAME + " TEXT, "
                + KEY_EMAIL_ID + " TEXT,"
                + KEY_PASSWORD + " TEXT"
                + ")");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXIST " + DB_TABLE);
        onCreate(db);
    }
}