package com.example.owner.mystudentappfrag;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;

import java.util.Calendar;

/**
 * Created by Ziv on 20/12/2016.
 */

public class DateTextView extends TextView {
    private int year;
    private int month;
    private int day;

    public DateTextView(Context context) {
        super(context);
        init();
    }

    public DateTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public DateTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init(){
        setInputType(0);

        // Setting current date
        Calendar currDate = Calendar.getInstance();
        this.setDate(currDate.get(Calendar.YEAR),currDate.get(Calendar.MONTH),currDate.get(Calendar.DAY_OF_MONTH));
    }

    /*
     * Setting date and text
     */
    public void setDate(int year, int monthOfYear, int dayOfMonth){
        setText(Utils.getDateFormat(year,monthOfYear,dayOfMonth));
        this.day = dayOfMonth;
        this.month = monthOfYear;
        this.year = year;
    }
}
