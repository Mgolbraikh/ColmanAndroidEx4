package com.example.owner.mystudentappfrag;


import android.app.Dialog;
import android.app.DialogFragment;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.widget.TimePicker;

/**
 * Created by Ziv on 20/12/2016.
 */

public class TimePickerDialogFragment extends DialogFragment implements TimePickerDialog.OnTimeSetListener {
    private TimePickerDialogFragment.OnTimeSetListener lisetener;
    private int hour;
    private int minute;

    public TimePickerDialogFragment(Bundle state) {
        this.hour= state.getInt("hour");
        this.minute= state.getInt("minute");
    }

    public void setOnTimeSetListener(TimePickerDialogFragment.OnTimeSetListener listener){
        this.lisetener = listener;
    }
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Dialog dialog = new TimePickerDialog(getActivity(),this,this.hour,this.minute, DateFormat.is24HourFormat(getActivity()));
        return dialog;
    }

    @Override
    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
        this.lisetener.onTimeSet(hourOfDay,minute);
    }


    interface OnTimeSetListener{
        void onTimeSet(int hourOfDay, int minute);
    }
}
