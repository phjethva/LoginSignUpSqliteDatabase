/**
 * Created by "Pratik Jethva"
 * Owned by "PJET APPS"
 * https://pjetapps.blogspot.in/
 */

package com.phjethva.login.signup.sqlite.database.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.phjethva.login.signup.sqlite.database.R;
import com.phjethva.login.signup.sqlite.database.widget.MyButton;
import com.phjethva.login.signup.sqlite.database.widget.MyTextView;

public class ActivityAdmin extends ActivityBase implements View.OnClickListener{

    private Toolbar toolbar;
    private MyTextView tvTB;
    private RecyclerView rvAdm;
    private MyButton btOut, btExt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);

        setUpView();

        tvTB.setText(R.string.adm);

        btOut.setOnClickListener(this);
        btExt.setOnClickListener(this);

    }

    private void setUpView() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        tvTB = (MyTextView) toolbar.findViewById(R.id.tv_tb_ttl);
        rvAdm = (RecyclerView) findViewById(R.id.rv_adm);
        btOut = (MyButton) findViewById(R.id.bt_out);
        btExt = (MyButton) findViewById(R.id.bt_ext);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.bt_out:
                Intent iLog = new Intent(getApplicationContext(), ActivityLogin.class);
                startActivity(iLog);
                finish();
                break;
            case R.id.bt_ext:
                finish();
                break;
        }
    }
}