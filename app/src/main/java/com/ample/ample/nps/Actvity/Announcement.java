package com.ample.ample.nps.Actvity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.ample.ample.nps.R;
import com.ample.ample.nps.MainActivity;

public class Announcement extends AppCompatActivity {
    String message;
    TextView txtm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_announcement);
        //getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        txtm = findViewById(R.id.txtmess);

        message = getIntent().getStringExtra("message");

        txtm.setText(message);

        /*swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {

            }
        });*/
    }

    @Override
    public void onBackPressed() {
        Intent i = new Intent(Announcement.this, MainActivity.class);
        i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(i);
        super.onBackPressed();
    }
}
