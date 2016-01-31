package com.example.shreyvalia.evently;


import android.app.Dialog;
import android.app.DialogFragment;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.TimePicker;

import java.util.Calendar;

/**
 * Created by Jenna on 1/30/2016.
 */
public class TimeDialog extends DialogFragment implements TimePickerDialog.OnTimeSetListener {
    EditText txtTime;

    public TimeDialog(EditText view) {
        txtTime = view;
    }

    public Dialog onCreateDialog(Bundle savedInstanceState) {
        final Calendar c = Calendar.getInstance();
        int hour = c.get(Calendar.HOUR);
        int minute = c.get(Calendar.MINUTE);
        int am_pm = c.get(Calendar.AM_PM);


//        if(c.get(Calendar.AM_PM) == Calendar.AM)
//            am_pm = "AM";
//        else if (c.get(Calendar.AM_PM) == Calendar.PM)
//            am_pm = "PM";
        Log.d("timepicker hour: ", Integer.toString(hour));
        Log.d("timepicker month: ", Integer.toString(minute));
        Log.d("timepicker day: ", Integer.toString(am_pm));

        return new TimePickerDialog(getActivity(), this, hour, minute, false);
    }

//    //    @Override
//    public void onTimeSet(TimePicker view, int hour, int minute, int am_pm) {
//        String time = (hour) + ":" + (minute) + " " + am_pm;
//        txtTime.setText(time);
//    }

    @Override
    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
        int hour = 0;
        boolean am = false;
        boolean pm = false;
        if (hourOfDay >= 13) {
            hour = hourOfDay - 12;
            pm = true;
        } else {
            hour = hourOfDay;
            am = true;
        }
        String time = null;
        if (am == true) {
            time = (hour) + ":" + (minute) + " AM";
        }
        else {
            time =  (hour) + ":" + (minute) + " PM";
        }

        txtTime.setText(time);
    }
}