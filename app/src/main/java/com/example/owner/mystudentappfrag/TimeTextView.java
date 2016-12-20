package com.example.owner.mystudentappfrag;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;

import java.util.Calendar;

/**
 * Created by Ziv on 20/12/2016.
 */

public class TimeTextView extends TextView {
    private int hour;
    private int minute;

    public TimeTextView(Context context) {
        super(context);
        init();
    }

    public TimeTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public TimeTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init(){
        setInputType(0);

        // Setting current date
        Calendar currDate = Calendar.getInstance();
        this.setTime(currDate.get(Calendar.HOUR_OF_DAY),currDate.get(Calendar.MINUTE));
    }

    /*
     * Setting date and text
     */
    public void setTime(int hour, int minute){
        setText(Utils.getTimeFormat(hour,minute));
        this.hour = hour;
        this.minute = minute;
    }
}
