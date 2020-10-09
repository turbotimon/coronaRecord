package ch.ost.mge.testat.coronarecord.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.Objects;

import ch.ost.mge.testat.coronarecord.R;
import ch.ost.mge.testat.coronarecord.adapter.PersonAdapter;
import ch.ost.mge.testat.coronarecord.model.Person;
import ch.ost.mge.testat.coronarecord.model.Report;
import ch.ost.mge.testat.coronarecord.services.PersonService;

public class PersonSelectActivity extends AppCompatActivity {
    public final static int REQ_CODE_NEW_PERSON = 1;

    RecyclerView recyclerView;
    PersonAdapter personAdapter;
    FloatingActionButton fabAddPerson;
    Report report;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_person_select);

        report = new Report();

        recyclerView = findViewById(R.id.personselect_rv_persons);
        personAdapter = new PersonAdapter(this, new PersonService());

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(personAdapter);

        fabAddPerson = findViewById(R.id.personselect_fab_addperson);
        fabAddPerson.setOnClickListener(v -> {
            Intent secondActivityIntent = new Intent(this, PersonAddActivity.class);
            startActivityForResult(secondActivityIntent, REQ_CODE_NEW_PERSON);
        });

    }

    protected void onActivityResult (int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQ_CODE_NEW_PERSON && resultCode == RESULT_OK) {
            Person person = (Person) Objects.requireNonNull(data.getExtras()).getSerializable("PERSON_OBJ");
            personAdapter.add(person);
        }
    }
}