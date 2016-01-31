package com.example.shreyvalia.evently;

import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CreateEventActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_event);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Evenntly");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
    }


    public void onStart() {
        super.onStart();
        EditText txtDate = (EditText) findViewById(R.id.txtdate_start);
        txtDate.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    DateDialog dialog = new DateDialog((EditText) v.findViewById(R.id.txtdate_start));
                    FragmentTransaction ft = getFragmentManager().beginTransaction();
                    dialog.show(ft, "DatePicker");
                }
            }
        });

        txtDate = (EditText) findViewById(R.id.txtdate_end);
        txtDate.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    DateDialog dialog = new DateDialog((EditText) v.findViewById(R.id.txtdate_end));
                    FragmentTransaction ft = getFragmentManager().beginTransaction();
                    dialog.show(ft, "DatePicker");
                }
            }
        });

        EditText txtTime = (EditText) findViewById(R.id.txttime_start);
        txtTime.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    TimeDialog dialog = new TimeDialog((EditText) v.findViewById(R.id.txttime_start));
                    FragmentTransaction ft = getFragmentManager().beginTransaction();
                    dialog.show(ft, "TimePicker");
                }
            }
        });

        txtTime = (EditText) findViewById(R.id.txttime_end);
        txtTime.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    TimeDialog dialog = new TimeDialog((EditText) v.findViewById(R.id.txttime_end));
                    FragmentTransaction ft = getFragmentManager().beginTransaction();
                    dialog.show(ft, "TimePicker");
                }
            }
        });
    }






        public void submit(View v) {
            node n = new node("1");
            EditText eventName = (EditText)findViewById(R.id.editText2);
            n.setName(eventName.getText().toString());
            EditText capacity = (EditText)findViewById(R.id.editText3);
            //handle null values
            n.setMax(Integer.parseInt(capacity.getText().toString()));


            EditText startDate = (EditText)findViewById(R.id.txtdate_start);
            String startDateString = startDate.getText().toString();
            EditText startTime = (EditText)findViewById(R.id.txttime_start);
            String startTimeString = startTime.getText().toString();
            String startDateAndTime = startDateString +" " + startTimeString;
            n.setStartDate(startDateAndTime);

            EditText endDate = (EditText)findViewById(R.id.txtdate_end);
            String endDateString = endDate.getText().toString();
            EditText endTime = (EditText) findViewById(R.id.txttime_end);
            String endTimeString = endTime.getText().toString();
            String endDateAndtime = endDateString + " " + endTimeString;
            n.setEndDate_Time(endDateAndtime);


            EditText address = (EditText)findViewById(R.id.editText7);
            n.setAddress(address.getText().toString());
            EditText description = (EditText)findViewById(R.id.editText8);
            n.setDescription(description.getText().toString());
            n.setnAttend(1);
            n.setVisible(true);

            Log.d("Event Name", n.getName());
            Log.d("Description", n.getDescription());
            Log.d("Max capcityy", String.valueOf(n.getMax()));
            Log.d("Address", n.getAddress());
            Log.d("start time", n.getStartDate_Time());
            Log.d("end time", n.getEndDate_Time());


            DateFormat dateFormatter = new SimpleDateFormat("yyyyMMdd hhmmss");
            dateFormatter.setLenient(false);
            Date today = new Date();
            String s = dateFormatter.format(today);
            s = s.replaceAll("\\s+","");

            String eventID = MainActivity.android_id + s;
            n.setEventID(eventID);
            Log.d("Create  currrent time: ", eventID);

            MainActivity.references.add(n);
            for(int i = 0;  i < MainActivity.references.size(); i++)
            {
                Log.d("testing " + i + ": ", MainActivity.references.get(i).getName());
            }
            Toast.makeText(getApplicationContext(), "Submit Pressed", Toast.LENGTH_SHORT).show();
            this.finish();
        }

    }


