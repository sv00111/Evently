package com.example.shreyvalia.evently;

import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

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

//        Button button = (==Button)findViewById(R.id.button4);
//        button.setOnClickListener(new submit());
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
    }

        public void submit(View v) {
            Log.d("fisdfufids", "inSUBMIT");

            node n = new node("1");
            EditText eventName = (EditText)findViewById(R.id.editText2);
            n.setName(eventName.getText().toString());
            EditText capacity = (EditText)findViewById(R.id.editText3);
            //handle null values
            n.setMax(Integer.parseInt(capacity.getText().toString()));


            EditText startDate = (EditText)findViewById(R.id.txtdate_start);
            String startDateString = startDate.getText().toString();
            //need to add start time to string
            String startDateAndTime = startDateString +" " ; //add time variable

            EditText endDate = (EditText)findViewById(R.id.txtdate_end);
            String endDateString = endDate.getText().toString();
            //need to add end time to string
            String endDateAndtime = endDateString + " " ;//add time variable


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


//            MainActivity.references.add(n);
            Toast.makeText(getApplicationContext(), "Submit Pressed", Toast.LENGTH_SHORT).show();

        }

}
