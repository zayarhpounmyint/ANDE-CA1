package com.example.helloworld;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;

public class DatePickerActivity extends AppCompatActivity {

    Button btnStartDate, btnEndDate, btnStartTime, btnEndTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.date_picker);

        // Initialize buttons
        btnStartDate = findViewById(R.id.btnStartDatePicker);
        btnEndDate = findViewById(R.id.btnEndDatePicker);
        btnStartTime = findViewById(R.id.btnStartTimePicker);
        btnEndTime = findViewById(R.id.btnEndTimePicker);

        // Set listeners for the date pickers
        setDateListener(btnStartDate);
        setDateListener(btnEndDate);

        // Set listeners for the time pickers
        setTimeListener(btnStartTime);
        setTimeListener(btnEndTime);
    }

    private void setDateListener(final Button button) {
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Calendar c = Calendar.getInstance();
                int year = c.get(Calendar.YEAR);
                int month = c.get(Calendar.MONTH);
                int day = c.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog datePickerDialog = new DatePickerDialog(DatePickerActivity.this,
                        (view, year1, monthOfYear, dayOfMonth) -> {
                            String selectedDate = dayOfMonth + "-" + (monthOfYear + 1) + "-" + year1;
                            button.setText(selectedDate);
                            Log.d("DatePicker", button.getId() == R.id.btnStartDatePicker ? "From Date: " : "To Date: " + selectedDate);
                        }, year, month, day);
                datePickerDialog.show();
            }
        });
    }

    private void setTimeListener(final Button button) {
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Calendar c = Calendar.getInstance();
                int hour = c.get(Calendar.HOUR_OF_DAY);
                int minute = c.get(Calendar.MINUTE);

                TimePickerDialog timePickerDialog = new TimePickerDialog(DatePickerActivity.this,
                        (view, hourOfDay, minute1) -> {
                            String selectedTime = hourOfDay + ":" + minute1;
                            button.setText(selectedTime);
                            Log.d("TimePicker", button.getId() == R.id.btnStartTimePicker ? "From Time: " : "To Time: " + selectedTime);
                        }, hour, minute, false);
                timePickerDialog.show();
            }
        });
    }
}
