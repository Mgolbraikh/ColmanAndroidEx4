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

public class EditTimeTextView extends EditText {
    private int hour;
    private int minute;

    public EditTimeTextView(Context context) {
        super(context);
        init();
    }

    public EditTimeTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public EditTimeTextView(Context context, AttributeSet attrs, int defStyleAttr) {
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

    public int getHour() {
        return hour;
    }

    public int getMinute() {
        return minute;
    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_DOWN){
            Bundle toPass = new Bundle();
            toPass.putInt("hour",this.hour);
            toPass.putInt("minute",this.minute);
            TimePickerDialogFragment dialog = new TimePickerDialogFragment(toPass);
            dialog.setOnTimeSetListener(new TimePickerDialogFragment.OnTimeSetListener() {

                @Override
                public void onTimeSet(int hourOfDay, int minute) {
                    setTime(hourOfDay,minute);
                }
            });
            dialog.show(((Activity)getContext()).getFragmentManager(),"TAG");
        }
        return true;
    }
}
