package ch.ost.mge.testat.coronarecord.activities;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Date;

import ch.ost.mge.testat.coronarecord.R;
import ch.ost.mge.testat.coronarecord.fragments.SpinnerFragment;
import ch.ost.mge.testat.coronarecord.model.Location;
import ch.ost.mge.testat.coronarecord.model.ReportItem;
import ch.ost.mge.testat.coronarecord.services.HttpService;
import ch.ost.mge.testat.coronarecord.services.LocationService;
import ch.ost.mge.testat.coronarecord.services.ReportService;

public class WelcomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        showSpinnerFragment();

        // Service initialisation
        LocationService.load();

        //TODO nur zu Demozwecken mit wait
        wait(1000, () -> {
            Intent mainActivity = new Intent(this, MainActivity.class);
            startActivity(mainActivity);
            this.finish(); // Schliesst die Acitivty, somit auch nicht mehr in der Navigation sichtbar
        });

    }

    private void showSpinnerFragment(){
        SpinnerFragment spinnerFragment = SpinnerFragment.create();
        getSupportFragmentManager().beginTransaction().add(R.id.welcome_container_runner, spinnerFragment).commit();
    }

    // TODO nur zu Show Zwecken
    private void wait(int ms, Runnable callback){
        Looper looper = Looper.getMainLooper();
        Handler handler = new Handler(looper);
        handler.postDelayed(callback, ms);
    }

}