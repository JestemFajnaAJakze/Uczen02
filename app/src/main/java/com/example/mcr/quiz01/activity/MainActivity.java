package com.example.mcr.quiz01.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.example.mcr.quiz01.model.Answer;
import com.example.mcr.quiz01.model.SchoolClass;
import com.example.mcr.quiz01.model.Student;
import com.example.mcr.quiz01.R;

import com.example.mcr.quiz01.R;
import com.example.mcr.quiz01.network.RetrofitAPI;
import com.squareup.okhttp.OkHttpClient;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.OkClient;

public class MainActivity extends Activity {

    private TextView txtName;
    private TextView txtEmail;
    private Button btnLogout;
    private Button categoryButton;
    private Button questionButton;
    private Button testButton;

    public Student loggedTeacher;
    private List<Student> loggedTeachers;
    private String studentName, studentEmail, studentClass;
    private int studentId, studentSchoolClassId;


    ;


    static final String API_URL = "http://192.168.1.100/android_login_api2";
    RestAdapter restAdapter2;


    ;


    public void onClickTest(View v) {
        Intent intent = new Intent(getApplicationContext(), TestListActivity.class);
        intent.putExtra("studentId", studentId);
        intent.putExtra("studentSchoolClassId", studentSchoolClassId);
        intent.putExtra("studentName", studentId);
        intent.putExtra("studentClass", studentClass);
        startActivity(intent);
    }

    ;

    public void onClicklogoutUser(View v) {
        Intent intent = new Intent(MainActivity.this, LoginActivity.class);
        startActivity(intent);
        finish();
        //logoutUser();
    }

    ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtName = (TextView) findViewById(R.id.name);
        txtEmail = (TextView) findViewById(R.id.email);
        btnLogout = (Button) findViewById(R.id.btnLogout);

        studentName = getIntent().getStringExtra("studentName");
        studentEmail = getIntent().getStringExtra("studentEmail");
        studentId = getIntent().getIntExtra("studentId", 0);
        studentSchoolClassId = getIntent().getIntExtra("studentSchoolClassId", 0);


        OkHttpClient mOkHttpClient2 = new OkHttpClient();
        mOkHttpClient2.setConnectTimeout(15000, TimeUnit.MILLISECONDS);
        mOkHttpClient2.setReadTimeout(15000, TimeUnit.MILLISECONDS);

        restAdapter2 = new RestAdapter.Builder()
                .setEndpoint(API_URL)
                .setClient(new OkClient(mOkHttpClient2))
                .setLogLevel(RestAdapter.LogLevel.FULL)
                .build();
        RetrofitAPI methods2 = restAdapter2.create(RetrofitAPI.class);


        Callback<List<SchoolClass>> cb2 = new Callback<List<SchoolClass>>() {

            @Override
            public void success(List<SchoolClass> schoolClasses, retrofit.client.Response response) {

                for (SchoolClass s : schoolClasses) {

                    studentClass = s.getName();


                }

            }


            @Override
            public void failure(RetrofitError error) {
                Log.e("QuestionListActivity", error.getMessage() + "\n" + error.getStackTrace());
                error.printStackTrace();
            }
        };
        methods2.getStudentClass(studentSchoolClassId, cb2);

        txtName.setText("Nazwa uzytkownika: " + studentName);
        txtEmail.setText("Email: " + studentEmail);


    }

    @Override
    protected void onRestart() {
        super.onRestart();

        setContentView(R.layout.activity_main);

        txtName = (TextView) findViewById(R.id.name);
        txtEmail = (TextView) findViewById(R.id.email);
        btnLogout = (Button) findViewById(R.id.btnLogout);

        studentName = getIntent().getStringExtra("studentName");
        studentEmail = getIntent().getStringExtra("studentEmail");
        studentId = getIntent().getIntExtra("studentId", 0);
        studentSchoolClassId = getIntent().getIntExtra("studentSchoolClassId", 0);


        OkHttpClient mOkHttpClient2 = new OkHttpClient();
        mOkHttpClient2.setConnectTimeout(15000, TimeUnit.MILLISECONDS);
        mOkHttpClient2.setReadTimeout(15000, TimeUnit.MILLISECONDS);

        restAdapter2 = new RestAdapter.Builder()
                .setEndpoint(API_URL)
                .setClient(new OkClient(mOkHttpClient2))
                .setLogLevel(RestAdapter.LogLevel.FULL)
                .build();
        RetrofitAPI methods2 = restAdapter2.create(RetrofitAPI.class);


        Callback<List<SchoolClass>> cb2 = new Callback<List<SchoolClass>>() {

            @Override
            public void success(List<SchoolClass> schoolClasses, retrofit.client.Response response) {

                for (SchoolClass s : schoolClasses) {

                    studentClass = s.getName();


                }

            }


            @Override
            public void failure(RetrofitError error) {
                Log.e("QuestionListActivity", error.getMessage() + "\n" + error.getStackTrace());
                error.printStackTrace();
            }
        };
        methods2.getStudentClass(studentSchoolClassId, cb2);

        txtName.setText("Nazwa uzytkownika: " + studentName);
        txtEmail.setText("Email: " + studentEmail);

    }


    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        // TODO Auto-generated method stub
        super.onWindowFocusChanged(hasFocus);
        if (hasFocus) {
            TextView className = (TextView) findViewById(R.id.className);
            className.setText("Klasa: " + studentClass);

        }
    }

}