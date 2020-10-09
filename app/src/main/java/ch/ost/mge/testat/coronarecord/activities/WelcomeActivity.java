package ch.ost.mge.testat.coronarecord.activities;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.button.MaterialButton;

import ch.ost.mge.testat.coronarecord.R;
import ch.ost.mge.testat.coronarecord.fragments.SpinnerFragment;
import ch.ost.mge.testat.coronarecord.model.People;
import ch.ost.mge.testat.coronarecord.model.Person;
import ch.ost.mge.testat.coronarecord.services.FileService;
import ch.ost.mge.testat.coronarecord.services.SaveObjectService;

public class WelcomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        showSpinnerFragment();

        //TODO nur zu Demozwecken
        wait(1000, () -> {
            Intent welcomeAcitivty = new Intent(this, WelcomeActivity.class);
            startActivity(welcomeAcitivty);
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