package ch.ost.mge.testat.coronarecord.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;

import ch.ost.mge.testat.coronarecord.R;
import ch.ost.mge.testat.coronarecord.model.Person;

public class PersonAddActivity extends AppCompatActivity {
    Person person;

    TextInputEditText firstname;
    TextInputEditText lastname;
    TextInputEditText phone;
    TextInputEditText email;

    MaterialButton cancel;
    MaterialButton save;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_person_add);
        linkControls();

        person = new Person();

        save.setOnClickListener(v ->{
            readPersonFromFields();
            Intent resultIntent = new Intent();
            resultIntent.putExtra("PERSON_OBJ", person);
            setResult(RESULT_OK, resultIntent);
            finish();
        });

        cancel.setOnClickListener(v ->{
            setResult(RESULT_CANCELED);
            finish();
        });

    }

    private void linkControls(){
        firstname = findViewById(R.id.personadd_edit_firstname);
        lastname = findViewById(R.id.personadd_edit_lastname);
        phone = findViewById(R.id.personadd_edit_phone);
        email = findViewById(R.id.personadd_edit_email);

        cancel = findViewById(R.id.personadd_btn_cancel);
        save = findViewById(R.id.personadd_btn_save);
    }

    private void readPersonFromFields(){
        person.setFirstName(firstname.getText().toString());
        person.setLastName(lastname.getText().toString());
        person.setPhone(phone.getText().toString());
        person.setEmail(email.getText().toString());
    }



}