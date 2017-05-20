/**
 * Created by "Pratik Jethva"
 * Owned by "PJET APPS"
 * https://pjetapps.blogspot.in/
 */

package com.phjethva.login.signup.sqlite.database.widget;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.EditText;

import com.phjethva.login.signup.sqlite.database.R;

public class MyEditText extends EditText {

    public MyEditText(Context context) {
        super(context);
        MyETHelper.setStyle(context, this);
    }

    public MyEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        MyETHelper.setStyle(context, this);
    }

    public MyEditText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        MyETHelper.setStyle(context, this);
    }

    private static class MyETHelper {
        private static void setStyle(Context context, EditText editText) {
            Typeface tf = Typeface.createFromAsset(context.getAssets(), "fonts/ic_fnt.ttf");
            editText.setTypeface(tf);
            editText.setBackgroundResource(R.drawable.bg_wdg);
            editText.setTextSize(18);
            editText.setTextColor(Color.BLACK);
            editText.setHintTextColor(context.getResources().getColor(R.color.colorAccent));
            editText.setLines(1);
        }
    }

}