package ch.ost.mge.testat.coronarecord.activities;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.button.MaterialButton;

import ch.ost.mge.testat.coronarecord.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initEventHandlers();
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
}