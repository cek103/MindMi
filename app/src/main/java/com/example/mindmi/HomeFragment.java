package com.example.mindmi;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CalendarView;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {

    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_home, container, false);
        // calendar
        CalendarView calendarView = (CalendarView) view.findViewById(R.id.calendarView);
        TextView selectedDay = (TextView) view.findViewById(R.id.selectedDay);

        // when change date
        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView calendarView, int y, int m, int d) {
                // convert int month to string name
                Calendar calendar = Calendar.getInstance();
                calendar.set(Calendar.MONTH, m);
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MMM");
                simpleDateFormat.setCalendar(calendar);
                String monthName = simpleDateFormat.format(calendar.getTime());

                // display date under calendar
                String display = monthName + " " + String.valueOf(d);
                selectedDay.setText(display);
            }
        });

        // Inflate the layout for this fragment
        return view;
    }
}