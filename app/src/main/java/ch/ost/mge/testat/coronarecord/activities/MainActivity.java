package ch.ost.mge.testat.coronarecord.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.button.MaterialButton;

import ch.ost.mge.testat.coronarecord.R;

public class MainActivity extends AppCompatActivity {

    private MaterialButton btnEnterCode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initEventHandlers();


    }

    private void initEventHandlers(){

        btnEnterCode = this.findViewById(R.id.main_btn_entercode);
        btnEnterCode.setOnClickListener( v -> {
            Intent locationSelect = new Intent(this, LocationSelectActivity.class);
            startActivity(locationSelect);
        });

    }

}