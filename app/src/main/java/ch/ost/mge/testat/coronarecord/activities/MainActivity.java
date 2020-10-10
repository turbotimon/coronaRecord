package ch.ost.mge.testat.coronarecord.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.google.android.material.button.MaterialButton;

import ch.ost.mge.testat.coronarecord.R;
import ch.ost.mge.testat.coronarecord.model.People;
import ch.ost.mge.testat.coronarecord.model.Person;
import ch.ost.mge.testat.coronarecord.services.FileService;
import ch.ost.mge.testat.coronarecord.services.SaveObjectService;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initEventHandlers();
        testFile();
        testSave();
    }

    private void initEventHandlers(){

        MaterialButton btnEnterCode = this.findViewById(R.id.main_btn_entercode);
        btnEnterCode.setOnClickListener( v -> {
            Intent locationSelect = new Intent(this, LocationSelectActivity.class);
            startActivity(locationSelect);
        });

        MaterialButton scanQr = this.findViewById(R.id.main_btn_scanqr);
        scanQr.setOnClickListener( v -> {
            Intent qrScanner = new Intent(this, QrScannerActivity.class);
            startActivity(qrScanner);
        });

    }

    //TODO clear after test
    private void testFile(){

        FileService fs = new FileService(this,"testFile");
        fs.write(111);
        int in = fs.read();
        Log.v("coronaRecord", Integer.toString(in));
    }

    //TODO clear after test
    private void testSave(){

        Person p = new Person("timon", "erhart", "12345", "t@e.ch");
        People plist = new People();
        plist.add(p);

        SaveObjectService.save(this, "testObject", plist);
        People plist2 = (People) SaveObjectService.load(this, "testObject");

        Log.v("coronaRecord", "Size: " + Integer.toString(plist2.size()));
        for (Person p2 : plist2){
            Log.v("coronaRecord", p2.getName());
        }


    }

}