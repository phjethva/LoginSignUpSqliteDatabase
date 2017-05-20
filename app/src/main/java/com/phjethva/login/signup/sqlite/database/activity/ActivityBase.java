/**
 * Created by Pratik Jethva
 * Owned by "PJET APPS"
 * https://pjetapps.blogspot.in/
 */

package com.phjethva.login.signup.sqlite.database.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.phjethva.login.signup.sqlite.database.helper.DBHelper;

public class ActivityBase extends AppCompatActivity {

    private DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        dbHelper = new DBHelper(this);
    }

    public void showToast(String str){
        Toast.makeText(getApplicationContext(), str, Toast.LENGTH_SHORT).show();
    }

    public void alertDialog(String ttl, String msg){

    }

}