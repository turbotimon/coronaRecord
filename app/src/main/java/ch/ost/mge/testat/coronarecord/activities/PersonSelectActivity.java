package ch.ost.mge.testat.coronarecord.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.Objects;

import ch.ost.mge.testat.coronarecord.R;
import ch.ost.mge.testat.coronarecord.adapter.PersonAdapter;
import ch.ost.mge.testat.coronarecord.database.PersonDao;
import ch.ost.mge.testat.coronarecord.database.PersonDatabase;
import ch.ost.mge.testat.coronarecord.interfaces.PersonEditIntent;
import ch.ost.mge.testat.coronarecord.model.Location;
import ch.ost.mge.testat.coronarecord.model.Person;
import ch.ost.mge.testat.coronarecord.model.PersonList;
import ch.ost.mge.testat.coronarecord.model.Report;
import ch.ost.mge.testat.coronarecord.services.LocationService;
import ch.ost.mge.testat.coronarecord.services.PersonService;
import ch.ost.mge.testat.coronarecord.services.ReportService;

public class PersonSelectActivity extends AppCompatActivity implements PersonEditIntent {
    public final static int REQ_CODE_NEW_PERSON = 1;
    public final static int REQ_CODE_EDIT_PERSON = 2;

    TextView locationNameLabel;
    RecyclerView recyclerView;
    PersonAdapter personAdapter;
    FloatingActionButton fabAddPerson;
    FloatingActionButton fabSend;
    Report report;
    Location location;
    PersonList personList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_person_select);

        report = new Report();

        int locationCode = (int) Objects.requireNonNull(getIntent().getExtras()).getInt("code");
        location = LocationService.getByCode(locationCode);
        locationNameLabel = findViewById(R.id.personselect_lbl_locationname);
        locationNameLabel.setText(location.getName());
        report.setLocation(location);

        initPersonList();
        initFabButtons();
    }

    private void initPersonList(){
        Runnable write = () -> {
            personList = new PersonList(new PersonService(this));

            personAdapter = new PersonAdapter(this, this, personList);
            personList.addObserver(personAdapter);

            personList.loadListFromService();

            recyclerView = findViewById(R.id.personselect_rv_persons);
            recyclerView.post(() -> recyclerView.setLayoutManager(new LinearLayoutManager(this)));
            recyclerView.post(() -> recyclerView.setAdapter(personAdapter));
        };

        new Thread(write).start();
    }

    private void initFabButtons(){
        fabAddPerson = findViewById(R.id.personselect_fab_addperson);
        fabAddPerson.setOnClickListener(v -> {
            addPerson();
        });

        fabSend = findViewById(R.id.personselect_fab_send);
        fabSend.setOnClickListener(v -> {
            report.setPersonArrayList(personList.getSelected());
            ReportService.send(report);
            // TODO: finish activity and go back to home screen
        });
    }

    protected void onActivityResult (int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == RESULT_OK){
            Person person = (Person) Objects.requireNonNull(data.getExtras()).getSerializable(Person.OBJECT_KEY);
            switch (requestCode){
                case REQ_CODE_NEW_PERSON:
                    personList.add(person);
                    break;
                case REQ_CODE_EDIT_PERSON:
                    personList.updateReplace(person);
                    break;
            }
        }
    }

    @Override
    public void editPerson(Person person) {
        Intent secondActivityIntent = new Intent(this, PersonActivity.class);
        secondActivityIntent.putExtra(Person.OBJECT_KEY,person);
        startActivityForResult(secondActivityIntent, REQ_CODE_EDIT_PERSON);
    }

    public void addPerson() {
        Intent secondActivityIntent = new Intent(this, PersonActivity.class);
        startActivityForResult(secondActivityIntent, REQ_CODE_NEW_PERSON);
    }
}