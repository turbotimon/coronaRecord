package ch.ost.mge.testat.coronarecord;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class PersonSelectActivity extends AppCompatActivity {

    FloatingActionButton fabAddPerson;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_person_select);

        fabAddPerson = findViewById(R.id.personselect_fab_addperson);
        fabAddPerson.setOnClickListener(v -> {
            Intent secondActivityIntent = new Intent(this, PersonAddActivity.class);
            startActivity(secondActivityIntent);
        });
    }
}