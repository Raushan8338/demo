package com.ample.ample.nps;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.ample.ample.nps.Actvity.ProfileActivity;

public class Mainpage extends AppCompatActivity {

    LinearLayout home,announc,assig,activity,message,diary,pay,attendance,log;

    TextView user_name,sect,school;
    ImageView fram;
    String name, pass, section, schoolname,image;
    Fragment fr;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainpage);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        home =  findViewById(R.id.home);
        announc =  findViewById(R.id.announcement);
        activity =  findViewById(R.id.activity);
        assig =  findViewById(R.id.assignmnets)  ;
        message =  findViewById(R.id.message);
        diary =  findViewById(R.id.daily_diary);
        pay =  findViewById(R.id.payfee);
        attendance =  findViewById(R.id.attendance);
        log =  findViewById(R.id.logout);


        ImageView imageView2=findViewById(R.id.frame);
        imageView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Mainpage.this,ProfileActivity.class);
                startActivity(intent);
            }
        });

        user_name= (TextView) findViewById(R.id.user_name);
        sect= (TextView) findViewById(R.id.section);
        school= (TextView) findViewById(R.id.school);
        fram=(ImageView)findViewById(R.id.frame);



        name = Common.getSavedUserData(Mainpage.this,"name");
        pass = Common.getSavedUserData(Mainpage.this,"pass");
        section = Common.getSavedUserData(Mainpage.this,"section");
        schoolname = Common.getSavedUserData(Mainpage.this,"schoolname");
        image = Common.getSavedUserData(Mainpage.this,"image");




        user_name.setText(name+ " ( "+schoolname+"-"+section+" )");
        //sect.setText("("+section);
        //school.setText(schoolname);



        home.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent i = new Intent(Mainpage.this, MainActivity.class);
                i.putExtra("frgToLoad", 0);
                startActivity(i);
            }
        });
        announc.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent i = new Intent(Mainpage.this, MainActivity.class);
                i.putExtra("frgToLoad",1);
                startActivity(i);
            }
        });
        activity.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent i = new Intent(Mainpage.this, MainActivity.class);
                i.putExtra("frgToLoad",2);
                startActivity(i);
            }
        });
        assig.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent i = new Intent(Mainpage.this, MainActivity.class);
                i.putExtra("frgToLoad",3);
                startActivity(i);
            }
        });
        message.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent i = new Intent(Mainpage.this, MainActivity.class);
                i.putExtra("frgToLoad",4);
                startActivity(i);
            }
        });
        diary.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent i = new Intent(Mainpage.this, MainActivity.class);
                i.putExtra("frgToLoad",5);
                startActivity(i);
            }
        });
        pay.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent i = new Intent(Mainpage.this, MainActivity.class);
                i.putExtra("frgToLoad",6);
                startActivity(i);
            }
        });
        attendance.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent i = new Intent(Mainpage.this, MainActivity.class);
                i.putExtra("frgToLoad",7);
                startActivity(i);
            }
        });
        log.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                startActivity(new Intent(Mainpage.this,Login.class));
            }
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.front, menu);
        return true;

    }

    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_lock) {
            finish();
            startActivity(new Intent(Mainpage.this,Login.class));
            finishAffinity();


        } else if (id == R.id.action_addcontact) {
            //Toast.makeText(Mainpage.this, "Currently you have not registered any child", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(Mainpage.this,Login.class));
            finishAffinity();
        }

        return super.onOptionsItemSelected(item);
    }
}