package ch.ost.mge.testat.coronarecord.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

import ch.ost.mge.testat.coronarecord.R;
import ch.ost.mge.testat.coronarecord.adapter.PersonAdapter;
import ch.ost.mge.testat.coronarecord.model.Person;
import ch.ost.mge.testat.coronarecord.services.PersonService;

public class PersonSelectActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    PersonAdapter personAdapter;
    FloatingActionButton fabAddPerson;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_person_select);

        recyclerView = findViewById(R.id.personselect_rv_persons);
        personAdapter = new PersonAdapter(this, PersonService.getInstance());

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(personAdapter);

        fabAddPerson = findViewById(R.id.personselect_fab_addperson);
        fabAddPerson.setOnClickListener(v -> {
            Intent secondActivityIntent = new Intent(this, PersonAddActivity.class);
            startActivity(secondActivityIntent);
        });
    }
}