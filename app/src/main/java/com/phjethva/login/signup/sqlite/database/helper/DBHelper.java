/**
 * Created by "Pratik Jethva"
 * Owned by "PJET APPS"
 * https://pjetapps.blogspot.in/
 */

package com.phjethva.login.signup.sqlite.database.helper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

import com.phjethva.login.signup.sqlite.database.models.User;

import java.util.ArrayList;
import java.util.List;

public class DBHelper extends SQLiteOpenHelper {

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

    public void addUser(User user) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(KEY_USER_NAME, user.getUn());
        cv.put(KEY_EMAIL_ID, user.getEi());
        cv.put(KEY_PASSWORD, user.getPw());
        db.insert(DB_TABLE, null, cv);
        db.close();
    }

    public User getUser(String un, String pw) {
        SQLiteDatabase db = this.getReadableDatabase();
        User user = null;
        Cursor c = db.query(DB_TABLE,
                new String[]{KEY_ID, KEY_USER_NAME, KEY_EMAIL_ID, KEY_PASSWORD},
                KEY_USER_NAME + "=?",
                new String[]{un},
                null,
                null,
                null,
                null);
        if (c != null) {
            c.moveToFirst();
        }
        if (c.getString(3).equals(pw)){
            user = new User(Integer.parseInt(c.getString(0)), c.getString(1), c.getString(2), c.getString(3));
        }else {
            user = null;
        }
        return user;
    }

    public List<User> getAllUser() {
        List<User> users = new ArrayList<User>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM " + DB_TABLE, null);
        if (c.moveToFirst()) {
            do {
                User user = new User();
                user.setId(Integer.parseInt(c.getString(0)));
                user.setUn(c.getString(1));
                user.setEi(c.getString(2));
                user.setPw(c.getString(3));
                users.add(user);
            } while (c.moveToNext());
        }
        return users;
    }
}