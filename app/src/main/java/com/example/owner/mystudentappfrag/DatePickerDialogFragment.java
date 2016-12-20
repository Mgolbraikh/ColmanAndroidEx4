package com.example.owner.mystudentappfrag;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.os.Bundle;
import android.widget.DatePicker;

/**
 * Created by Ziv on 20/12/2016.
 */

public class DatePickerDialogFragment extends DialogFragment implements DatePickerDialog.OnDateSetListener{

    private OnDateSetListener lisetener;
    private int year;
    private int month;
    private int day;

    public DatePickerDialogFragment(Bundle state) {
        this.year= state.getInt("year");
        this.month= state.getInt("month");
        this.day = state.getInt("day");
    }

    public void setOnDateSetListener(OnDateSetListener listener){
        this.lisetener = listener;
    }
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Dialog dialog = new DatePickerDialog(getActivity(),this,this.year,this.month,this.day);
        return dialog;
    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        this.lisetener.onDateSet(year,month,dayOfMonth);
    }

    interface OnDateSetListener{
        void onDateSet(int year, int monthOfYear, int dayOfMonth);
    }
}
