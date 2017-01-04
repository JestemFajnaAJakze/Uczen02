package com.example.mcr.quiz01.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.mcr.quiz01.R;
import com.example.mcr.quiz01.model.Student;
import com.example.mcr.quiz01.model.Student;
import com.example.mcr.quiz01.network.RetrofitAPI;
import com.squareup.okhttp.OkHttpClient;

import java.util.List;
import java.util.concurrent.TimeUnit;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.OkClient;
import retrofit.client.Response;

/**
 * Created by MCR on 24.10.2016.
 */

public class LoginActivity extends Activity {

    private EditText inputEmail;
    private EditText inputPassword;

    private List<Student> loggedTeachers;
    Boolean isUserCorrect = false;
    static final String API_URL = "http://192.168.1.100/android_login_api2";
    RestAdapter restAdapter;
    private Student loggedStudent;

    public void onClickLogin(View v) {

        /*String email = inputEmail.getText().toString().trim();
        String password = inputPassword.getText().toString().trim();*/


        String email = "Mikolaj@wat.pl";
        String password = "Mikolaj123";
        // Check for empty data in the form
        if (!email.isEmpty() && !password.isEmpty()) {
            // login user

            OkHttpClient mOkHttpClient = new OkHttpClient();
            mOkHttpClient.setConnectTimeout(15000, TimeUnit.MILLISECONDS);
            mOkHttpClient.setReadTimeout(15000, TimeUnit.MILLISECONDS);

            restAdapter = new RestAdapter.Builder()
                    .setEndpoint(API_URL)
                    .setClient(new OkClient(mOkHttpClient))
                    .setLogLevel(RestAdapter.LogLevel.FULL)
                    .build();
            RetrofitAPI methods = restAdapter.create(RetrofitAPI.class);


            Callback<List<Student>> cb = new Callback<List<Student>>() {

                @Override
                public void success(List<Student> teachers, Response response) {

                    try{
                        for (Student t : teachers) {


                            loggedStudent.setName(t.getName());
                            loggedStudent.setPassword(t.getPassword());
                            loggedStudent.setEmail(t.getEmail());
                            loggedStudent.setSchoolClass_id(t.getSchoolClass_id());
                            loggedStudent.setStudent_id(t.getStudent_id());

                            if (loggedStudent.getEmail().equals(null)) {
                                Toast.makeText(getApplicationContext(),
                                        "Bledne dane do logowania!", Toast.LENGTH_SHORT)
                                        .show();
                            } else {
                                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                                intent.putExtra("studentName", loggedStudent.getName());
                                intent.putExtra("studentEmail", loggedStudent.getEmail());
                                intent.putExtra("studentId", loggedStudent.getStudent_id());
                                intent.putExtra("studentSchoolClassId", loggedStudent.getSchoolClass_id());
                                startActivity(intent);
                                Toast.makeText(getApplicationContext(),
                                        "Witaj " + loggedStudent.getName() + "!", Toast.LENGTH_LONG)
                                        .show();


                            }


                        }
                    }
                    catch (Exception e){

                    }




                }


                @Override
                public void failure(RetrofitError error) {
                    Log.e("CategoryListActivity", error.getMessage() + "\n" + error.getStackTrace());
                    error.printStackTrace();
                    Toast.makeText(getApplicationContext(),
                            "Bledne dane do logowania!", Toast.LENGTH_SHORT)
                            .show();
                }
            };
            methods.checkStudent(email, password, cb);

        } else {
            Toast.makeText(getApplicationContext(),
                    "Prosze uzupelnic dane do logowania!", Toast.LENGTH_LONG)
                    .show();
        }

    }






    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        inputEmail = (EditText) findViewById(R.id.email);
        inputPassword = (EditText) findViewById(R.id.password);
        loggedStudent = new Student();



    }


}