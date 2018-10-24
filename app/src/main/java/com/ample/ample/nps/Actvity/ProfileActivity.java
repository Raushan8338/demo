package com.ample.ample.nps.Actvity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TabHost;
import android.widget.TextView;


import com.ample.ample.nps.MainActivity;
import com.ample.ample.nps.Mainpage;
import com.ample.ample.nps.R;
import com.ample.ample.nps.Common;


public class ProfileActivity extends AppCompatActivity {
    TextView user_name,sect,school,std,daob,addres,cg,fname,fmobile,femail,mname,mmobile,memail;
    String name, pass, section, schoolname,studentid,dob,address,classgroup,fathername,fathermobile,fatheremail,mothername,mothermobile,motheremail;
    TabHost tabHost;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        user_name= (TextView) findViewById(R.id.user_name);
        sect= (TextView) findViewById(R.id.section);
        school= (TextView) findViewById(R.id.school);
        std= (TextView) findViewById(R.id.stdid);
        cg= (TextView) findViewById(R.id.cg);
        daob= (TextView) findViewById(R.id.db);
        addres= (TextView) findViewById(R.id.address);
        fname= (TextView) findViewById(R.id.fname);
        fmobile= (TextView) findViewById(R.id.fmobile);
        femail= (TextView) findViewById(R.id.femail);
        mname= (TextView) findViewById(R.id.mname);
        mmobile= (TextView) findViewById(R.id.mmobile);
        memail= (TextView) findViewById(R.id.memail);


        name = Common.getSavedUserData(ProfileActivity.this,"name");
        pass = Common.getSavedUserData(ProfileActivity.this,"pass");
        section = Common.getSavedUserData(ProfileActivity.this,"section");
        schoolname = Common.getSavedUserData(ProfileActivity.this,"schoolname");
        classgroup = Common.getSavedUserData(ProfileActivity.this,"classgroup");
        studentid = Common.getSavedUserData(ProfileActivity.this,"studentid");
        fathername = Common.getSavedUserData(ProfileActivity.this,"fathername");
         dob = Common.getSavedUserData(ProfileActivity.this,"dob");
        address = Common.getSavedUserData(ProfileActivity.this,"address");
        fathermobile = Common.getSavedUserData(ProfileActivity.this,"fathermobile");
        fatheremail = Common.getSavedUserData(ProfileActivity.this,"fatheremail");
        mothername = Common.getSavedUserData(ProfileActivity.this,"mothername");
        mothermobile = Common.getSavedUserData(ProfileActivity.this,"mothermobile");
        motheremail = Common.getSavedUserData(ProfileActivity.this,"motheremail");


        user_name.setText(name);
        sect.setText(section);
        school.setText(schoolname);
        std.setText(studentid);
        cg.setText(classgroup);
        daob.setText(dob);
        addres.setText(address);
        fname.setText(fathername);
        fmobile.setText(fathermobile);
        femail.setText(fatheremail);
        mname.setText(mothername);
        mmobile.setText(mothermobile);
        memail.setText(motheremail);

        TabHost host = (TabHost)findViewById(R.id.tabHost);
        host.setup();

        //Tab 1
        TabHost.TabSpec spec = host.newTabSpec("PERSONAL DETAILS");
        spec.setContent(R.id.tab1);
        spec.setIndicator("PERSONAL DETAILS");
        host.addTab(spec);

        //Tab 2
        spec = host.newTabSpec("PARENT DETAILS");
        spec.setContent(R.id.tab2);
        spec.setIndicator("PARENT DETAILS");
        host.addTab(spec);


    }
    @Override
    public void onBackPressed() {
        Intent i = new Intent(ProfileActivity.this, Mainpage.class);
        i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(i);
        super.onBackPressed();
    }
}
