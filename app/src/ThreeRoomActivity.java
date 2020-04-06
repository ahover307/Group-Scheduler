package edu.psu.jbr5410.paramount;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;

public class ThreeRoomActivity extends AppCompatActivity {

    private int day, month, year, dayOfWeek, partyPackage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_three_room);

        Intent intent = getIntent();
        day = intent.getIntExtra("day", -1);
        month = intent.getIntExtra("month", -1);
        year = intent.getIntExtra("year", -1);
        dayOfWeek = intent.getIntExtra("dayOfWeek",-1);
        partyPackage = intent.getIntExtra("package", -1);

        Spinner roomSpinner = findViewById(R.id.spinner_rooms);
        Spinner roomSpinner2 = findViewById(R.id.spinner_rooms2);

        String[] rooms = getResources().getStringArray(R.array.Rooms);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                this, android.R.layout.simple_spinner_item, rooms
        );

        roomSpinner.setAdapter(adapter);
        roomSpinner2.setAdapter(adapter);

        roomSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                changeSpinners();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        roomSpinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                changeSpinnerThree();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }

    public void changeSpinners() {
        Spinner roomSpinner = findViewById(R.id.spinner_rooms);
        String[] rooms = getResources().getStringArray(R.array.Rooms);
        ArrayList<String> rooms2 = new ArrayList<>();
        String room = roomSpinner.getSelectedItem().toString();

        for (String r : rooms) {
            if (!r.equals(room))
                rooms2.add(r);
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                this, android.R.layout.simple_spinner_item, rooms2
        );

        Spinner roomSpinner2 = findViewById(R.id.spinner_rooms2);
        //Spinner roomSpinner3 = findViewById(R.id.spinner_rooms3);
        //roomSpinner3.setAdapter(adapter);
        roomSpinner2.setAdapter(adapter);

    }

    public void changeSpinnerThree() {
        Spinner roomSpinner = findViewById(R.id.spinner_rooms);
        Spinner roomSpinner2 = findViewById(R.id.spinner_rooms2);
        String[] rooms = getResources().getStringArray(R.array.Rooms);
        ArrayList<String> rooms2 = new ArrayList<>();
        String room = roomSpinner.getSelectedItem().toString();
        String room2 = roomSpinner2.getSelectedItem().toString();

        for (String r : rooms) {
            if (!r.equals(room) && !r.equals(room2))
                rooms2.add(r);
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                this, android.R.layout.simple_spinner_item, rooms2
        );

        Spinner roomSpinner3 = findViewById(R.id.spinner_rooms3);
        roomSpinner3.setAdapter(adapter);

    }

    public void submit(View view) {
        Intent intent = new Intent(this, TimeslotActivity.class);

        Spinner roomSpinner = findViewById(R.id.spinner_rooms);
        String room = roomSpinner.getSelectedItem().toString();
        Spinner roomSpinner2 = findViewById(R.id.spinner_rooms2);
        String room2 = roomSpinner2.getSelectedItem().toString();
        Spinner roomSpinner3 = findViewById(R.id.spinner_rooms3);
        String room3 = roomSpinner3.getSelectedItem().toString();

        String[] rooms = {room, room2, room3};

        intent.putExtra("day", day);
        intent.putExtra("month", month);
        intent.putExtra("year", year);
        intent.putExtra("dayOfWeek", dayOfWeek);
        intent.putExtra("package", partyPackage);
        intent.putExtra("rooms", rooms);

        startActivity(intent);
    }
}
