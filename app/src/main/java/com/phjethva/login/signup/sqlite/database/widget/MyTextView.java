/**
 * Created by "Pratik Jethva"
 * Owned by "PJET APPS"
 * https://pjetapps.blogspot.in/
 */

package com.phjethva.login.signup.sqlite.database.widget;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;

public class MyTextView extends TextView {
    public MyTextView(Context context) {
        super(context);
        MyTVHelper.setStyle(context, this);
    }

    public MyTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        MyTVHelper.setStyle(context, this);
    }

    public MyTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        MyTVHelper.setStyle(context, this);
    }

    private static class MyTVHelper {
        private static void setStyle(Context context, TextView textView) {
            Typeface tf = Typeface.createFromAsset(context.getAssets(), "fonts/ic_fnt.ttf");
            textView.setTypeface(tf);
            textView.setTextSize(18);
        }
    }

}