/**
 * Created by "Pratik Jethva"
 * Owned by "PJET APPS"
 * https://pjetapps.blogspot.in/
 */

package com.phjethva.login.signup.sqlite.database.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.view.View;

import com.phjethva.login.signup.sqlite.database.R;
import com.phjethva.login.signup.sqlite.database.widget.MyButton;
import com.phjethva.login.signup.sqlite.database.widget.MyTextView;

public class ActivityMain extends ActivityBase implements View.OnClickListener{

    private Toolbar toolbar;
    private MyTextView tvTB, tvUN, tvEI, tvPW;
    private String strUN, strEI, strPW;
    private MyButton btOut, btExt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setUpView();

        tvTB.setText(R.string.min);

        Bundle bundle = getIntent().getExtras();
        strUN = "Username:<br/><font color=#ff4081>"+bundle.getString("un")+"</font>";
        strEI = "Email Id:<br/><font color=#ff4081>"+bundle.getString("ei")+"</font>";
        strPW = "Password:<br/><font color=#ff4081>"+bundle.getString("pw")+"</font>";
        tvUN.setText(Html.fromHtml(strUN));
        tvEI.setText(Html.fromHtml(strEI));
        tvPW.setText(Html.fromHtml(strPW));

        btOut.setOnClickListener(this);
        btExt.setOnClickListener(this);
    }

    private void setUpView() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        tvTB = (MyTextView) toolbar.findViewById(R.id.tv_tb_ttl);
        tvUN = (MyTextView) findViewById(R.id.tv_un);
        tvEI = (MyTextView) findViewById(R.id.tv_ei);
        tvPW = (MyTextView) findViewById(R.id.tv_pw);
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