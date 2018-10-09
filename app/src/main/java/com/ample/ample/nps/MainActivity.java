package com.ample.ample.nps;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.ample.ample.nps.Fragment.Attendance;
import com.ample.ample.nps.Fragment.Message;
import com.ample.ample.nps.Fragment.Pay;
import com.ample.ample.nps.Fragment.Announcements;
import com.ample.ample.nps.Fragment.Assignments;
import com.ample.ample.nps.Fragment.Diary;
import com.ample.ample.nps.Fragment.Home;
import com.ample.ample.nps.Fragment.Image;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import cn.pedant.SweetAlert.SweetAlertDialog;
import cz.msebera.android.httpclient.Header;


public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    private static final String URL_PRODUCTS = "https://raushankumar8338.000webhostapp.com/store/Images/Api.php";

    AsyncHttpClient asyncHttpClient = new AsyncHttpClient();
    LinearLayout home,announc,assig,activity,message,diary,pay,attendance,log;
    TextView user_name,sect,school,std;
    String name, section, schoolname,studentid;
    TextView txtuname, txtsection, txtschoolname,txtstudent;
    FragmentManager fm;
    FragmentTransaction ft;
    Fragment fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        home =  findViewById(R.id.home);
        announc =  findViewById(R.id.announcement);
        activity =  findViewById(R.id.activity);
        assig =  findViewById(R.id.assignmnets)  ;
        message =  findViewById(R.id.message);
        diary =  findViewById(R.id.daily_diary);
        pay =  findViewById(R.id.payfee);
        attendance =  findViewById(R.id.attendance);
        log =  findViewById(R.id.logout);

        user_name= (TextView) findViewById(R.id.user_name);
        sect= (TextView) findViewById(R.id.section);
        school= (TextView) findViewById(R.id.school);
        std= (TextView) findViewById(R.id.stdid);

        name = Common.getSavedUserData(MainActivity.this,"name");
        section = Common.getSavedUserData(MainActivity.this,"section");
        schoolname = Common.getSavedUserData(MainActivity.this,"schoolname");
        studentid = Common.getSavedUserData(MainActivity.this,"studentid");


        int intentFragment = getIntent().getExtras().getInt("frgToLoad");
        switch (intentFragment){
            case 0:
                ((RelativeLayout)findViewById(R.id.replace)).removeAllViews();
                FragmentManager fm = getSupportFragmentManager();
                fm.popBackStackImmediate();
                FragmentTransaction ft = fm.beginTransaction();
                Fragment fragment=new Home();
                ft.replace(R.id.replace, fragment);
                ft.commit();
                break;
            case 1:
                ((RelativeLayout)findViewById(R.id.replace)).removeAllViews();
                FragmentManager fm1 = getSupportFragmentManager();
                fm1.popBackStackImmediate();
                FragmentTransaction ft1 = fm1.beginTransaction();
                Fragment fragment1=new Announcements();
                ft1.replace(R.id.replace, fragment1);
                ft1.commit();
                break;
            case 2:
                ((RelativeLayout)findViewById(R.id.replace)).removeAllViews();
                FragmentManager fm2 = getSupportFragmentManager();
                fm2.popBackStackImmediate();
                FragmentTransaction ft2 = fm2.beginTransaction();
                Fragment fragment2=new Image();
                ft2.replace(R.id.replace, fragment2);
                ft2.commit();
                break;
            case 3:
                ((RelativeLayout)findViewById(R.id.replace)).removeAllViews();
                FragmentManager fm3 = getSupportFragmentManager();
                fm3.popBackStackImmediate();
                FragmentTransaction ft3 = fm3.beginTransaction();
                Fragment fragment3=new Assignments();
                ft3.replace(R.id.replace, fragment3);
                ft3.commit();
                break;
            case 4:
                ((RelativeLayout)findViewById(R.id.replace)).removeAllViews();
                FragmentManager fm4 = getSupportFragmentManager();
                fm4.popBackStackImmediate();
                FragmentTransaction ft4 = fm4.beginTransaction();
                Fragment fragment4=new com.ample.ample.nps.Fragment.Message();
                ft4.replace(R.id.replace, fragment4);
                ft4.commit();
                break;
            case 5:
                ((RelativeLayout)findViewById(R.id.replace)).removeAllViews();
                FragmentManager fm5 = getSupportFragmentManager();
                FragmentTransaction ft5 = fm5.beginTransaction();
                Fragment fragment5=new Diary();
                ft5.replace(R.id.replace, fragment5);
                ft5.commit();
                break;
            case 6:
                ((RelativeLayout)findViewById(R.id.replace)).removeAllViews();
                FragmentManager fm6 = getSupportFragmentManager();
                FragmentTransaction ft6 = fm6.beginTransaction();
                Fragment fragment6=new Pay();
                ft6.replace(R.id.replace, fragment6);
                ft6.commit();
                break;
            case 7:
                ((RelativeLayout)findViewById(R.id.replace)).removeAllViews();
                FragmentManager fm7 = getSupportFragmentManager();
                FragmentTransaction ft7 = fm7.beginTransaction();
                Fragment fragment7=new Attendance();
                ft7.replace(R.id.replace, fragment7);
                ft7.commit();
                break;

        }       // user_name.setText(name);
        // sect.setText(section);


        /*name = Common.getSavedUserData(MainActivity.this,"name");
        pass = Common.getSavedUserData(MainActivity.this,"pass");
        sectrion = Common.getSavedUserData(MainActivity.this,"sectrion");
        schoolname = Common.getSavedUserData(MainActivity.this,"schoolname");*/

//        home.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                ((RelativeLayout)findViewById(R.id.replace)).removeAllViews();
//                FragmentManager fm = getSupportFragmentManager();
//                fm.popBackStack(null,FragmentManager.POP_BACK_STACK_INCLUSIVE);
//                FragmentTransaction ft = fm.beginTransaction();
//                Fragment fragment=new Home();
//                ft.replace(R.id.replace, fragment);
//                ft.commit();
//            }
//        });
//        announc.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                ((RelativeLayout)findViewById(R.id.replace)).removeAllViews();
//                FragmentManager fm = getSupportFragmentManager();
//                fm.popBackStack(null,FragmentManager.POP_BACK_STACK_INCLUSIVE);
//                FragmentTransaction ft = fm.beginTransaction();
//                Fragment fragment=new Announcements();
//                ft.replace(R.id.replace, fragment);
//                ft.commit();
//            }
//        });
//        activity.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                ((RelativeLayout)findViewById(R.id.replace)).removeAllViews();
//                FragmentManager fm = getSupportFragmentManager();
//                fm.popBackStack(null,FragmentManager.POP_BACK_STACK_INCLUSIVE);
//                FragmentTransaction ft = fm.beginTransaction();
//                Fragment fragment=new Image();
//                ft.replace(R.id.replace, fragment);
//                ft.commit();
//            }
//        });
//        assig.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                ((RelativeLayout)findViewById(R.id.replace)).removeAllViews();
//                FragmentManager fm = getSupportFragmentManager();
//                fm.popBackStack(null,FragmentManager.POP_BACK_STACK_INCLUSIVE);
//                FragmentTransaction ft = fm.beginTransaction();
//                Fragment fragment=new Assignments();
//                ft.replace(R.id.replace, fragment);
//                ft.commit();
//            }
//        });
//        message.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                ((RelativeLayout)findViewById(R.id.replace)).removeAllViews();
//                FragmentManager fm = getSupportFragmentManager();
//                fm.popBackStackImmediate();
//                FragmentTransaction ft = fm.beginTransaction();
//                Fragment fragment=new Message();
//                ft.replace(R.id.replace, fragment);
//                ft.commit();
//            }
//        });
//        diary.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                ((RelativeLayout)findViewById(R.id.replace)).removeAllViews();
//                FragmentManager fm = getSupportFragmentManager();
//                FragmentTransaction ft = fm.beginTransaction();
//                Fragment fragment=new Diary();
//                ft.replace(R.id.replace, fragment);
//                ft.commit();
//            }
//        });
//        pay.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                ((RelativeLayout)findViewById(R.id.replace)).removeAllViews();
//                FragmentManager fm = getSupportFragmentManager();
//                FragmentTransaction ft = fm.beginTransaction();
//                Fragment fragment=new Pay();
//                ft.replace(R.id.replace, fragment);
//                ft.commit();
//            }
//        });
//        attendance.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                ((RelativeLayout)findViewById(R.id.replace)).removeAllViews();
//                FragmentManager fm = getSupportFragmentManager();
//                FragmentTransaction ft = fm.beginTransaction();
//                Fragment fragment=new Attendance();
//                ft.replace(R.id.replace, fragment);
//                ft.commit();
//            }
//        });
//        log.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                finish();
//                startActivity(new Intent(MainActivity.this,Login.class));
//            }
//        });


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        View hview = ((NavigationView) findViewById(R.id.nav_view)).getHeaderView(0);
        txtuname = (TextView)hview.findViewById(R.id.username);
        txtsection = (TextView)hview.findViewById(R.id.section);
        txtschoolname = (TextView)hview.findViewById(R.id.school);
        txtstudent = (TextView)hview.findViewById(R.id.stdid);


        txtuname.setText(name);
        txtschoolname.setText(schoolname+ " - "+section+" ");
        //txtsection.setText(section);
        //txtschoolname.setText(schoolname);
        txtstudent.setText(studentid);
       // user_name.setText(name+ " ( "+schoolname+" "+section+" )");

    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(this,Mainpage.class));
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            ((RelativeLayout)findViewById(R.id.replace)).removeAllViews();
            FragmentManager fm = getSupportFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            Fragment fragment=new Announcements();
            ft.replace(R.id.replace, fragment);
            ft.commit();
            return true;
        }
        else if (id == R.id.refresh) {
            final SweetAlertDialog pDialog = new SweetAlertDialog(
                    MainActivity.this, SweetAlertDialog.PROGRESS_TYPE);
            pDialog.getProgressHelper().setBarColor(getResources().getColor(R.color.colorPrimary));
            pDialog.setTitleText("Loading...");
            pDialog.setCancelable(false);
            pDialog.show();
            RequestParams requestParams = new RequestParams();

            asyncHttpClient.post(URL_PRODUCTS, requestParams, new AsyncHttpResponseHandler() {
                @Override
                public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {

                    String s = new String(responseBody);
                    pDialog.dismiss();
                }

                @Override
                public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                    pDialog.dismiss();
                    /*Toast.makeText(Login.this, "Something went wrong", Toast.LENGTH_SHORT).show();*/
                }
            });
        }
        else if (id==R.id.search)
        {
            Toast.makeText(MainActivity.this, "currently not available search..you can wait upcoming version", Toast.LENGTH_SHORT).show();
        }
       /* else if (id==R.id.action_logout){
            finish();
            startActivity(new Intent(MainActivity.this,Login.class));

            return true;
        }*/
            return true;

        }
    @Override
    protected void onRestart() {

        // TODO Auto-generated method stub
        super.onRestart();
        Intent i = new Intent(MainActivity.this, MainActivity.class);  //your class
        startActivity(i);
        finish();

    }


    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        if (id == R.id.nav_home) {
            ((RelativeLayout)findViewById(R.id.replace)).removeAllViews();
            FragmentManager fm = getSupportFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            fragment=new Home();
            ft.replace(R.id.replace, fragment);
            ft.commit();

        } else if (id == R.id.nav_assin) {
            ((RelativeLayout)findViewById(R.id.replace)).removeAllViews();
            FragmentManager fm = getSupportFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            fragment=new Assignments();
            ft.replace(R.id.replace, fragment);
            ft.commit();
        }
        else if (id == R.id.nav_announcement) {
            ((RelativeLayout)findViewById(R.id.replace)).removeAllViews();
            FragmentManager fm = getSupportFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            fragment=new Announcements();
            ft.replace(R.id.replace, fragment);
            ft.commit();
        }
        else if (id == R.id.nav_activity) {

            ((RelativeLayout)findViewById(R.id.replace)).removeAllViews();
            FragmentManager fm = getSupportFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            fragment=new Image();
            ft.replace(R.id.replace, fragment);
            ft.commit();
        }
        else if (id == R.id.nav_Message) {
            ((RelativeLayout)findViewById(R.id.replace)).removeAllViews();
            FragmentManager fm = getSupportFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            fragment=new Message();
            ft.replace(R.id.replace, fragment);
            ft.commit();
        }
        else if (id == R.id.nav_diary) {
            ((RelativeLayout)findViewById(R.id.replace)).removeAllViews();
            FragmentManager fm = getSupportFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            fragment=new Diary();
            ft.replace(R.id.replace, fragment);
            ft.commit();
        }
        else if (id == R.id.nav_Pay) {
            ((RelativeLayout)findViewById(R.id.replace)).removeAllViews();
            FragmentManager fm = getSupportFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            fragment=new Pay();
            ft.replace(R.id.replace, fragment);
            ft.commit();
        }
        else if (id == R.id.logout) {
            finish();
            startActivity(new Intent(MainActivity.this,Login.class));

        }
        if (fragment != null) {
            android.support.v4.app.FragmentTransaction ft =getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.replace, fragment);
            ft.commit();

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
