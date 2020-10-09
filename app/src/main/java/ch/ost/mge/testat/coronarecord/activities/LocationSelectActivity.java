package ch.ost.mge.testat.coronarecord.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.button.MaterialButton;

import ch.ost.mge.testat.coronarecord.R;

public class LocationSelectActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location_select);

        initEventHandlers();

    }

    private void initEventHandlers(){
        MaterialButton btnCheck;
        btnCheck = this.findViewById(R.id.locationselect_btn_check);
        btnCheck.setOnClickListener( v -> {
            Intent locationSelect = new Intent(this, PersonSelectActivity.class);
            startActivity(locationSelect);
        });

    }

}