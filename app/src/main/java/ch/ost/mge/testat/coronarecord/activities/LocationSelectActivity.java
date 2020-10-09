package ch.ost.mge.testat.coronarecord.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;

import ch.ost.mge.testat.coronarecord.R;
import ch.ost.mge.testat.coronarecord.model.Location;
import ch.ost.mge.testat.coronarecord.services.LocationService;

public class LocationSelectActivity extends AppCompatActivity {

    private MaterialButton btnCheck;
    private TextInputEditText editCode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location_select);

        initResources();
        initEventHandlers();

    }

    private void initResources(){

        btnCheck = this.findViewById(R.id.locationselect_btn_check);
        editCode = this.findViewById(R.id.locationselect_edit_code);

        if (btnCheck == null || editCode == null) throw new NullPointerException("Resources not found");

    }

    private void initEventHandlers(){
        btnCheck.setOnClickListener( v -> {

            int code = getEditCodeValue();

            //TODO check if code is valid
            if (!isCodeValid(code)){
                editCode.setError(getString(R.string.locationselect_invalid_code));
                return;
            }

            Intent locationSelect = new Intent(this, PersonSelectActivity.class);
            locationSelect.putExtra("code", code);
            startActivity(locationSelect);

        });

        editCode.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (s.length() != Location.CODE_LENGTH) {
                    editCode.setError(getString(R.string.locationselect_invalid_code_length));
                    btnCheck.setEnabled(false);
                } else {
                    editCode.setError(null);
                    btnCheck.setEnabled(true);
                }
            }
        });

    }


    public boolean isCodeValid(int code){
        return LocationService.containsCode(code);
    }

    public int getEditCodeValue(){
            return Integer.parseInt(editCode.getText().toString());
    }


}