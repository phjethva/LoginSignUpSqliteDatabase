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
import android.widget.Button;

import com.phjethva.login.signup.sqlite.database.R;

public class MyButton extends Button {

    public MyButton(Context context) {
        super(context);
        MyBTHelper.setStyle(context, this);
    }

    public MyButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        MyBTHelper.setStyle(context, this);
    }

    public MyButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        MyBTHelper.setStyle(context, this);
    }

    private static class MyBTHelper {
        private static void setStyle(Context context, Button button) {
            Typeface tf = Typeface.createFromAsset(context.getAssets(), "fonts/ic_fnt.ttf");
            button.setTypeface(tf);
            button.setBackgroundResource(R.drawable.bg_wdg);
            button.setTextSize(18);
            button.setTextColor(Color.BLACK);
            if (Build.VERSION.SDK_INT >= 14) {
                button.setAllCaps(true);
            }
        }
    }

}