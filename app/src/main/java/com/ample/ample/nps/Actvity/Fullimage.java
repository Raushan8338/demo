package com.ample.ample.nps.Actvity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.ample.ample.nps.R;
import com.ample.ample.nps.MainActivity;


public class Fullimage extends AppCompatActivity {

   TextView txtimg1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fullimage);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        txtimg1 = findViewById(R.id.txtimg);
           Bundle bundle=getIntent().getExtras();
           if (bundle!=null)
           {
               int images=bundle.getInt("image");
           }
        //image = getIntent().getStringExtra("image");

        /*txtimg.(image);*/

       /* swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {

            }
        });*/
    }

    @Override
    public void onBackPressed() {
        Intent i = new Intent(Fullimage.this, MainActivity.class);
        i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(i);
        super.onBackPressed();
    }
}
