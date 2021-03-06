/**
 * Created by "Pratik Jethva"
 * Owned by "PJET APPS"
 * https://pjetapps.blogspot.in/
 */

package com.phjethva.login.signup.sqlite.database.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.phjethva.login.signup.sqlite.database.R;
import com.phjethva.login.signup.sqlite.database.helper.DBHelper;
import com.phjethva.login.signup.sqlite.database.models.User;
import com.phjethva.login.signup.sqlite.database.widget.MyButton;
import com.phjethva.login.signup.sqlite.database.widget.MyEditText;
import com.phjethva.login.signup.sqlite.database.widget.MyTextView;

public class ActivityRegister extends ActivityBase implements View.OnClickListener {

    private Toolbar toolbar;
    private MyTextView tvTB;
    private MyEditText etUN, etEI, etPW;
    private MyButton btReg, btLog, btExt;
    private String strUN, strEI, strPW;
    private DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        setUpView();

        dbHelper = new DBHelper(this);

        tvTB.setText(R.string.reg);

        btReg.setOnClickListener(this);
        btLog.setOnClickListener(this);
        btExt.setOnClickListener(this);

    }

    private void setUpView() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        tvTB = (MyTextView) toolbar.findViewById(R.id.tv_tb_ttl);
        etUN = (MyEditText) findViewById(R.id.et_un);
        etEI = (MyEditText) findViewById(R.id.et_ei);
        etPW = (MyEditText) findViewById(R.id.et_pw);
        btReg = (MyButton) findViewById(R.id.bt_reg);
        btLog = (MyButton) findViewById(R.id.bt_log);
        btExt = (MyButton) findViewById(R.id.bt_ext);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.bt_reg:
                strUN = etUN.getText().toString().trim();
                strEI = etEI.getText().toString().trim();
                strPW = etPW.getText().toString().trim();
                if (!strUN.equals("") && !strEI.equals("") && !strPW.equals("")) {
                    dbHelper.addUser(new User(strUN, strEI, strPW));
                    Intent iMin = new Intent(getApplicationContext(), ActivityMain.class);
                    startActivity(iMin);
                    finish();
                } else if (strUN.equals("") && strEI.equals("") && strPW.equals("")) {
                    showToast("Enter All Fields");
                } else if (strUN.equals("")) {
                    showToast("Enter Username");
                } else if (strEI.equals("")) {
                    showToast("Enter Email Id");
                } else if (strPW.equals("")) {
                    showToast("Enter Password");
                }
                break;
            case R.id.bt_log:
                Intent iLog = new Intent(getApplicationContext(), ActivityLogin.class);
                startActivity(iLog);
                finish();
                break;
            case R.id.bt_ext:
                finish();
        }
    }
}