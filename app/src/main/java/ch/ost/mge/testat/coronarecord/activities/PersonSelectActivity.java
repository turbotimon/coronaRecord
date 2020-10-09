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

public class PersonSelectActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    PersonAdapter personAdapter;
    FloatingActionButton fabAddPerson;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_person_select);


        recyclerView = findViewById(R.id.personselect_rv_persons);
        personAdapter = new PersonAdapter(this, getDummyData());

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(personAdapter);

        fabAddPerson = findViewById(R.id.personselect_fab_addperson);
        fabAddPerson.setOnClickListener(v -> {
            Intent secondActivityIntent = new Intent(this, PersonAddActivity.class);
            startActivity(secondActivityIntent);
        });
    }

    private ArrayList<Person> getDummyData(){
        ArrayList<Person> personArrayList = new ArrayList<>();
        personArrayList.add(new Person("Max", "Muster", "079 891 27 63", "max@muster.ch"));
        personArrayList.add(new Person("Tom", "Hunter", "079 212 32 21", "tom@gmail.com"));
        personArrayList.add(new Person("Mia", "Hustler", "079 234 12 42", "mia.hustler@gmx.to"));
        return personArrayList;
    }
}