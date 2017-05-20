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
import com.phjethva.login.signup.sqlite.database.widget.MyButton;
import com.phjethva.login.signup.sqlite.database.widget.MyEditText;
import com.phjethva.login.signup.sqlite.database.widget.MyTextView;

public class ActivityLogin extends ActivityBase implements View.OnClickListener {

    private Toolbar toolbar;
    private MyTextView tvTB;
    private MyEditText etUN, etPW;
    private MyButton btLog, btReg, btAdm;
    private String strUN, strPW;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        setUpView();

        tvTB.setText(R.string.log);

        btLog.setOnClickListener(this);
        btReg.setOnClickListener(this);
        btAdm.setOnClickListener(this);

    }

    private void setUpView() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        tvTB = (MyTextView) toolbar.findViewById(R.id.tv_tb_ttl);
        etUN = (MyEditText) findViewById(R.id.et_un);
        etPW = (MyEditText) findViewById(R.id.et_pw);
        btLog = (MyButton) findViewById(R.id.bt_log);
        btReg = (MyButton) findViewById(R.id.bt_reg);
        btAdm = (MyButton) findViewById(R.id.bt_adm);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.bt_log:
                Intent iLog = new Intent(getApplicationContext(), ActivityMain.class);
                startActivity(iLog);
                finish();
                break;
            case R.id.bt_reg:
                Intent iReg = new Intent(getApplicationContext(), ActivityRegister.class);
                startActivity(iReg);
                finish();
                break;
            case R.id.bt_adm:
                strUN = etUN.getText().toString().trim();
                strPW = etPW.getText().toString().trim();
                if (strUN.equals("admin") && strPW.equals("admin")) {
                    Intent iAdm = new Intent(getApplicationContext(), ActivityAdmin.class);
                    startActivity(iAdm);
                    finish();
                } else if (strUN.equals("") && strPW.equals("")) {
                    showToast("Enter All Fields");
                } else if (strUN.equals("")) {
                    showToast("Enter Username");
                } else if (strPW.equals("")) {
                    showToast("Enter Password");
                } else if (!strUN.equals("admin") || !strPW.equals("admin")) {
                    showToast("Incorrect Login");
                }
                break;
        }
    }

}