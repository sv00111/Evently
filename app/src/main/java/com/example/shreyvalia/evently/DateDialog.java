package com.example.shreyvalia.evently;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.os.Bundle;
import android.util.Log;
import android.widget.DatePicker;
import android.widget.EditText;

import java.util.Calendar;


/**
 * Created by Jenna on 1/30/2016.
 */
public class DateDialog extends DialogFragment implements DatePickerDialog.OnDateSetListener{

    EditText txtDate;
    public DateDialog (EditText view){
        txtDate=view;
    }

    public Dialog onCreateDialog(Bundle savedInstanceState){
        final Calendar c=Calendar.getInstance();
        int year=c.get(Calendar.YEAR);
        int month=c.get(Calendar.MONTH);
        int day=c.get(Calendar.DAY_OF_MONTH);
        Log.d("datepicker year: ", Integer.toString(year));
        Log.d("datepicker month: ", Integer.toString(month));
        Log.d("datepicker day: ", Integer.toString(day));

        return new DatePickerDialog(getActivity(), this,year,month,day);
    }

    public void onDateSet(DatePicker view, int year, int month, int day){
        String date=(month+1)+"/"+(day)+"/"+year;
        txtDate.setText(date);
    }
}
