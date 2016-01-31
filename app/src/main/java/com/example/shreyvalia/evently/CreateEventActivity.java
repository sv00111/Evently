package com.example.shreyvalia.evently;

import android.app.AlertDialog;
import android.app.FragmentTransaction;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.ParseObject;

public class CreateEventActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_event);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Evenntly");
        setSupportActionBar(toolbar);

//        getSupportActionBar().setHomeButtonEnabled(true);
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

//

    }

    public void onBackButton(){
        AlertDialog aBox = OptionAsk();
        aBox.show();
    }

    private AlertDialog OptionAsk(){
        AlertDialog leaveBox = new AlertDialog.Builder(this)
                .setTitle("Back")
                .setMessage("Are you sure you want to cancel?")
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int whichButton) {
                        finish();
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                })
                .create();
        return leaveBox;
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
        Log.d("fisdfufids", "inSUBMIT");

        node n = new node("1");
        EditText eventName = (EditText) findViewById(R.id.editText2);
        n.setName(eventName.getText().toString());
        EditText capacity = (EditText) findViewById(R.id.editText3);
        //handle null values
        n.setMax(Integer.parseInt(capacity.getText().toString()));


        EditText startDate = (EditText) findViewById(R.id.txtdate_start);
        String startDateString = startDate.getText().toString();
        EditText startTime = (EditText) findViewById(R.id.txttime_start);
        String startTimeString = startTime.getText().toString();
        String startDateAndTime = startDateString + " " + startTimeString;
        n.setStartDate_Time(startDateAndTime);

        EditText endDate = (EditText) findViewById(R.id.txtdate_end);
        String endDateString = endDate.getText().toString();
        EditText endTime = (EditText) findViewById(R.id.txttime_end);
        String endTimeString = endTime.getText().toString();
        String endDateAndTime = endDateString + " " + endTimeString;
        n.setEndDate_Time(endDateAndTime);


        EditText address = (EditText) findViewById(R.id.editText7);
        n.setAddress(address.getText().toString());
        EditText description = (EditText) findViewById(R.id.editText8);
        n.setDescription(description.getText().toString());
        n.setnAttend(1);
        n.setVisible(true);

        Log.d("Event Name", n.getName());
        Log.d("Description", n.getDescription());
        Log.d("Max capcityy", String.valueOf(n.getMax()));
        Log.d("Address", n.getAddress());
        Log.d("start time", n.getStartDate_Time());
        Log.d("end time", n.getEndDate_Time());

        //Store values in strings
        String eventTitle = n.getName();
        String eventDescription = n.getDescription();
        String eventAddress = n.getAddress();
        String eventDate = n.getStartDate_Time();
        System.out.println("Date here:");
        System.out.println(eventDate);

        //Saving to Parse
        ParseObject eventObject = new ParseObject("TestObject");
        eventObject.put("eventTitle", eventTitle);
        eventObject.put("description", eventDescription);
        eventObject.put("address", eventAddress);
        eventObject.put("voteCount", 0);
        eventObject.put("date", eventDate);
        eventObject.saveInBackground();

        MainActivity.references.add(n);
        Toast.makeText(getApplicationContext(), "Submit Pressed", Toast.LENGTH_SHORT).show();
        this.finish();

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                //Write your logic here
                this.finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}


