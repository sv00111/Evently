package com.example.shreyvalia.evently;

import android.app.DatePickerDialog;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;

import java.util.Calendar;

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

        ImageButton button = (ImageButton)findViewById(R.id.imageButton);
        button.setOnClickListener(new submit());

    }

    public class submit implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            node n = new node("1");
            EditText eventName = (EditText)findViewById(R.id.editText2);
            n.setName(eventName.getText().toString());
            EditText capacity = (EditText)findViewById(R.id.editText3);
            n.setMax(Integer.parseInt(capacity.getText().toString()));

        }
    }







    }
