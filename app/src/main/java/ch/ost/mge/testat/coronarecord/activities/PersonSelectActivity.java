package ch.ost.mge.testat.coronarecord.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.Objects;

import ch.ost.mge.testat.coronarecord.R;
import ch.ost.mge.testat.coronarecord.adapter.PersonAdapter;
import ch.ost.mge.testat.coronarecord.database.PersonDao;
import ch.ost.mge.testat.coronarecord.database.PersonDatabase;
import ch.ost.mge.testat.coronarecord.model.Location;
import ch.ost.mge.testat.coronarecord.model.Person;
import ch.ost.mge.testat.coronarecord.model.Report;
import ch.ost.mge.testat.coronarecord.services.LocationService;
import ch.ost.mge.testat.coronarecord.services.PersonService;
import ch.ost.mge.testat.coronarecord.services.ReportService;

public class PersonSelectActivity extends AppCompatActivity {
    public final static int REQ_CODE_NEW_PERSON = 1;

    TextView locationNameLabel;
    RecyclerView recyclerView;
    PersonAdapter personAdapter;
    FloatingActionButton fabAddPerson;
    FloatingActionButton fabSend;
    Report report;
    Location location;
    PersonDatabase db;
    PersonDao personDao;

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
            db = Room.databaseBuilder(this, PersonDatabase.class, "room.db").build();
            personDao = db.personDao();
            recyclerView = findViewById(R.id.personselect_rv_persons);
            personAdapter = new PersonAdapter(this, new PersonService(personDao));

            recyclerView.post(() -> recyclerView.setLayoutManager(new LinearLayoutManager(this)));
            recyclerView.post(() -> recyclerView.setAdapter(personAdapter));
        };

        new Thread(write).start();
    }

    private void initFabButtons(){
        fabAddPerson = findViewById(R.id.personselect_fab_addperson);
        fabAddPerson.setOnClickListener(v -> {
            Intent secondActivityIntent = new Intent(this, PersonAddActivity.class);
            startActivityForResult(secondActivityIntent, REQ_CODE_NEW_PERSON);
        });

        fabSend = findViewById(R.id.personselect_fab_send);
        fabSend.setOnClickListener(v -> {
            report.setPersonArrayList(personAdapter.getSelectedPerson());
            ReportService.send(report);
            // TODO: finish activity and go back to home screen
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