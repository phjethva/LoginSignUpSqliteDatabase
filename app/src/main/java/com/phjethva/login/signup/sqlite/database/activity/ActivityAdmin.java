/**
 * Created by "Pratik Jethva"
 * Owned by "PJET APPS"
 * https://pjetapps.blogspot.in/
 */

package com.phjethva.login.signup.sqlite.database.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

import com.phjethva.login.signup.sqlite.database.R;
import com.phjethva.login.signup.sqlite.database.adapter.AdapterUser;
import com.phjethva.login.signup.sqlite.database.helper.DBHelper;
import com.phjethva.login.signup.sqlite.database.models.User;
import com.phjethva.login.signup.sqlite.database.widget.MyButton;
import com.phjethva.login.signup.sqlite.database.widget.MyTextView;

import java.util.ArrayList;
import java.util.List;

public class ActivityAdmin extends ActivityBase implements View.OnClickListener {

    private Toolbar toolbar;
    private MyTextView tvTB;
    private MyButton btOut, btExt;
    private DBHelper dbHelper;

    private RecyclerView rvAdm;
    private ArrayList<User> arrayUser;
    private AdapterUser adapterUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);

        setUpView();
        dbHelper = new DBHelper(this);

        tvTB.setText(R.string.adm);

        btOut.setOnClickListener(this);
        btExt.setOnClickListener(this);

        rvAdm.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        rvAdm.setLayoutManager(layoutManager);
        arrayUser = new ArrayList<>();
        adapterUser = new AdapterUser(arrayUser);
        final List<User> users = dbHelper.getAllUser();
        for (User un : users) {
            String strLog = "Id: " + un.getId() + ", "
                    + "Username : " + un.getUn() + ", "
                    + "Email Id : " + un.getEi() + ", "
                    + "Password : " + un.getPw();
            Log.d("strLog", strLog);
            arrayUser.add(un);
        }
        rvAdm.setAdapter(adapterUser);
        rvAdm.addOnItemTouchListener(new RecyclerView.OnItemTouchListener() {
            GestureDetector gestureDetector = new GestureDetector(getApplicationContext(), new GestureDetector.SimpleOnGestureListener(){
                @Override
                public boolean onSingleTapUp(MotionEvent e) {
                    return true;
                }
            });
            @Override
            public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {
                View child = rv.findChildViewUnder(e.getX(), e.getY());
                if(child != null && gestureDetector.onTouchEvent(e)) {
                    int position = rv.getChildAdapterPosition(child);
                    Toast.makeText(getApplicationContext(), ""
                            +"Id: "+arrayUser.get(position).getId()+"\n"
                            +"Username: "+arrayUser.get(position).getUn()+"\n"
                            +"Email Id: "+arrayUser.get(position).getEi()+"\n"
                            +"Password: "+arrayUser.get(position).getPw(), Toast.LENGTH_SHORT).show();
                }
                return false;
            }
            @Override
            public void onTouchEvent(RecyclerView rv, MotionEvent e) {
            }
            @Override
            public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {
            }
        });
    }

    private void setUpView() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        tvTB = (MyTextView) toolbar.findViewById(R.id.tv_tb_ttl);
        rvAdm = (RecyclerView) findViewById(R.id.rv_adm);
        btOut = (MyButton) findViewById(R.id.bt_out);
        btExt = (MyButton) findViewById(R.id.bt_ext);
        rvAdm = (RecyclerView) findViewById(R.id.rv_adm);
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