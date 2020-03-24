package edu.psu.jbr5410.paramount;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Spinner;

public class RoomActivity extends AppCompatActivity {

    public String date;
    public String partyPackage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room);

        Intent intent = getIntent();
        date = intent.getStringExtra("date");
        partyPackage = intent.getStringExtra("package");

    }

    public void submit(View view) {
        Intent intent = new Intent(this, FinalDetailsActivity.class);

        Spinner roomSpinner = findViewById(R.id.spinner_rooms);
        String room = roomSpinner.getSelectedItem().toString();
        String[] rooms = {room};

        intent.putExtra("date", date);
        intent.putExtra("package", partyPackage);
        intent.putExtra("rooms", rooms);

        startActivity(intent);
    }


}
