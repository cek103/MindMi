package com.example.mindmi;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.CalendarView;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        CalendarView calendarView = findViewById(R.id.calendarView);
        TextView selectedDay = findViewById(R.id.selectedDay);

        // String months = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December".};

        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView calendarView, int y, int m, int d) {
                // convert int month to string name
                Calendar calendar = Calendar.getInstance();
                calendar.set(Calendar.MONTH, m);
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MMM");
                simpleDateFormat.setCalendar(calendar);
                String monthName = simpleDateFormat.format(calendar.getTime());

                selectedDay.setText(monthName + " " + String.valueOf(d));
            }
        });
    }
}