package com.example.owner.mystudentappfrag;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.EditText;

import java.util.Calendar;

/**
 * Created by Ziv on 20/12/2016.
 */

public class EditDateTextView extends EditText {
    private int year;
    private int month;
    private int day;

    public EditDateTextView(Context context) {
        super(context);
        init();
    }

    public EditDateTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public EditDateTextView(Context context, AttributeSet attrs, int defStyleAttr) {
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

    public int getYear() {
        return year;
    }

    public int getMonth() {
        return month;
    }

    public int getDay() {
        return day;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_DOWN){
            Bundle toPass = new Bundle();
            toPass.putInt("year",this.year);
            toPass.putInt("month",this.month);
            toPass.putInt("day",this.day);
            DatePickerDialogFragment dialog = new DatePickerDialogFragment(toPass);
            dialog.setOnDateSetListener(new DatePickerDialogFragment.OnDateSetListener() {
                @Override
                public void onDateSet(int year, int monthOfYear, int dayOfMonth) {
                    EditDateTextView.this.setDate(year,monthOfYear,dayOfMonth);
                }
            });
            dialog.show(((Activity)getContext()).getFragmentManager(),"TAG");
        }
        return true;
    }
}

