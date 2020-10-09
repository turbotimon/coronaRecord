package ch.ost.mge.testat.coronarecord.activities;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.button.MaterialButton;

import ch.ost.mge.testat.coronarecord.R;
import ch.ost.mge.testat.coronarecord.model.People;
import ch.ost.mge.testat.coronarecord.model.Person;
import ch.ost.mge.testat.coronarecord.services.FileService;
import ch.ost.mge.testat.coronarecord.services.SaveObjectService;

public class WelcomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }


}