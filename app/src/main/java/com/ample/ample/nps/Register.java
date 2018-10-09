package com.ample.ample.nps;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

public class Register extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    EditText ET_NAME;
    EditText ET_USER;
    EditText ET_PASS;
    Spinner ET_SPINER;
    String name,username,pass,spiner;
    @SuppressLint("CutPasteId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        Spinner spinner = findViewById(R.id.spiner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.numbers, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);
        ET_NAME = (EditText)findViewById(R.id.name);
        ET_USER = (EditText)findViewById(R.id.username);
        ET_SPINER=(Spinner)findViewById(R.id.spiner);
        ET_PASS = (EditText)findViewById(R.id.pass);
    }
    public  void userreg(View view){

        name = ET_NAME.getText().toString();
        if (name.isEmpty()){
            ET_NAME.setError("Please Enter Your Name");
            ET_NAME.requestFocus();
            return;
        }
        username = ET_USER.getText().toString();
        if (username.isEmpty()){
            ET_USER.setError("Please Enter Unique ID");
            ET_USER.requestFocus();
            return;
        }
        if (username.length() < 6) {
            ET_USER.setError("Minimum lenght of Unique ID should be 6");
            ET_USER.requestFocus();
            return;
        }
        pass = ET_PASS.getText().toString();
        if (pass.isEmpty()) {
            ET_PASS.setError("Password is required");
            ET_PASS.requestFocus();
            return;
        }

        if (pass.length() < 6) {
           ET_PASS.setError("Minimum lenght of password should be 6");
            ET_PASS.requestFocus();
            return;
        }

        String method = "register";
        BackgroundTask backgroundTask = new BackgroundTask(this);
        backgroundTask.execute(method,name,username,pass);
        finish();

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String text = parent.getItemAtPosition(position).toString();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}