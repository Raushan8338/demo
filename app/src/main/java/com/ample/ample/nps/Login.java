package com.ample.ample.nps;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;

import cn.pedant.SweetAlert.SweetAlertDialog;
import cz.msebera.android.httpclient.Header;

public class Login extends AppCompatActivity {
    EditText name, pass;
    Button login;
    AsyncHttpClient asyncHttpClient = new AsyncHttpClient();
    SharedPreferences pref;
    SharedPreferences.Editor editor;
    public static String Loginurl = "http://www.amplesoftech.co.in/app/LoginBack.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        name = (EditText) findViewById(R.id.username);
        pass = (EditText)findViewById(R.id.pass);
        login = (Button) findViewById(R.id.login);

      // final File file = new File("data/data/com.ample.ample.nps/shared_prefs/admin.xml");
        /*if (file.exists()) {
            Intent intent = new Intent(Login.this, Mainpage.class);
            startActivity(intent);
            finish();
        }*/
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final SweetAlertDialog pDialog = new SweetAlertDialog(Login.this, SweetAlertDialog.PROGRESS_TYPE);
                pDialog.getProgressHelper().setBarColor(getResources().getColor(R.color.colorPrimary));
                pDialog.setTitleText("Loading...");
                pDialog.setCancelable(false);
                pDialog.show();

                String username = name.getText().toString();
                String userpass = pass.getText().toString();

                Log.e("username",username);
                Log.e("userpass",userpass);

                    RequestParams requestParams = new RequestParams();
                    requestParams.put("name",username);
                    requestParams.put("pass",userpass);

                    asyncHttpClient.post(Loginurl, requestParams, new AsyncHttpResponseHandler() {
                        @Override
                        public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {

                            String s = new String(responseBody);
                            pDialog.dismiss();
                            try {
                                JSONObject jsonObject = new JSONObject(s);
                                if (jsonObject.getString("success").equalsIgnoreCase("1")){
                                    pDialog.dismiss();
                                    Toast.makeText(Login.this, "Login Successfully", Toast.LENGTH_SHORT).show();

                                    pref = getSharedPreferences("admin", Context.MODE_PRIVATE);
                                    editor = pref.edit();
                                    editor.putString("AdminLogin","AdminLoginSuccesssful");
                                    editor.commit();

                                    String id = jsonObject.getString("id");
                                    String name = jsonObject.getString("name");
                                    String pass = jsonObject.getString("pass");
                                    String section = jsonObject.getString("section");
                                    String schoolname = jsonObject.getString("schoolname");
                                    String studentid = jsonObject.getString("studentid");
                                    String dob = jsonObject.getString("dob");
                                    String address = jsonObject.getString("address");
                                    String classgroup = jsonObject.getString("classgroup");
                                    String fathername = jsonObject.getString("fathername");
                                    String fathermobile = jsonObject.getString("fathermobile");
                                    String fatheremail = jsonObject.getString("fatheremail");
                                    String mothername = jsonObject.getString("mothername");
                                    String mothermobile = jsonObject.getString("mothermobile");
                                    String motheremail = jsonObject.getString("motheremail");
                                    String image = jsonObject.getString("image");



                                    Common.saveUserData(Login.this,"id",id);
                                    Common.saveUserData(Login.this,"name",name);
                                    Common.saveUserData(Login.this,"pass",pass);
                                    Common.saveUserData(Login.this,"section",section);
                                    Common.saveUserData(Login.this,"schoolname",schoolname);
                                    Common.saveUserData(Login.this,"studentid",studentid);
                                    Common.saveUserData(Login.this,"classgroup",classgroup);
                                    Common.saveUserData(Login.this,"dob",dob);
                                    Common.saveUserData(Login.this,"address",address);
                                    Common.saveUserData(Login.this,"fathername",fathername);
                                    Common.saveUserData(Login.this,"fathermobile",fathermobile);
                                    Common.saveUserData(Login.this,"fatheremail",fatheremail);
                                    Common.saveUserData(Login.this,"mothername",mothername);
                                    Common.saveUserData(Login.this,"mothermobile",mothermobile);
                                    Common.saveUserData(Login.this,"motheremail",motheremail);
                                    Common.saveUserData(Login.this,"image",image);

                                    Intent intent = new Intent(Login.this, Mainpage.class);
                                    startActivity(intent);
                                    finishAffinity();

                                   /* if (section.equals("sec A")) {
                                        Intent intent = new Intent(Login.this, Mainpage.class);
                                        startActivity(intent);
                                       // finishAffinity();
                                    }else if (section.equals("sec B")){
                                        Intent intent = new Intent(Login.this, Mainpage.class);
                                        startActivity(intent);
                                        //finishAffinity();
                                    }*/

                                }else if (jsonObject.getString("success").equalsIgnoreCase("0")){
                                    pDialog.dismiss();
                                    Toast.makeText(Login.this, ""+jsonObject.getString("message"), Toast.LENGTH_SHORT).show();
                                }
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }

                        @Override
                        public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                            pDialog.dismiss();
                            Toast.makeText(Login.this, "Something went wrong", Toast.LENGTH_SHORT).show();
                        }
                    });

                }
        });
    }

    /*public void  userlogin(View view){
        login_name = name.getText().toString();
        if(TextUtils.isEmpty(login_name)) {
            name.setError("Fields cannot be empty");
            name.requestFocus();
            return;
        }
        login_pass = pass.getText().toString();
        if (login_pass.isEmpty()) {
            pass.setError("Password is required");
            pass.requestFocus();
            return;
        }

        if (login_pass.length() < 6) {
            pass.setError("Minimum lenght of password should be 6");
            pass.requestFocus();
            return;
        }
        String method = "login";
        BackgroundTask backgroundTask = new BackgroundTask(this);
        backgroundTask.execute(method,login_name,login_pass);

    }*/
  /*  public void userreg(View view)
    {

        startActivity(new Intent(this,Register.class));
    }*/


}
