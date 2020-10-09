package ch.ost.mge.testat.coronarecord.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.google.android.material.button.MaterialButton;

import ch.ost.mge.testat.coronarecord.R;
import ch.ost.mge.testat.coronarecord.services.FileService;

public class MainActivity extends AppCompatActivity {

    private MaterialButton btnEnterCode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initEventHandlers();
        testFile();
    }

    private void initEventHandlers(){

        btnEnterCode = this.findViewById(R.id.main_btn_entercode);
        btnEnterCode.setOnClickListener( v -> {
            Intent locationSelect = new Intent(this, LocationSelectActivity.class);
            startActivity(locationSelect);
        });

    }

    //TODO clear after test
    private void testFile(){

        FileService fs = new FileService(this,"testFile");
        fs.write(999);
        int in = fs.read();
        Log.v("FileService", Integer.toString(in));
    }

}