package com.ample.ample.nps.Actvity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.ample.ample.nps.MainActivity;
import com.ample.ample.nps.R;


public class AttendanceActivity extends AppCompatActivity {
    String allday;
    TextView alld;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attendance);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        alld = findViewById(R.id.all);

        allday = getIntent().getStringExtra("allday");

        alld.setText(allday);

        /*swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {

            }
        });*/
    }

    @Override
    public void onBackPressed() {
        Intent i = new Intent(AttendanceActivity.this, MainActivity.class);
        i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(i);
        super.onBackPressed();
    }
}
