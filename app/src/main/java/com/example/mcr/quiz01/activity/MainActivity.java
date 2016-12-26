package com.example.mcr.quiz01.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.mcr.quiz01.model.Student;
import com.example.mcr.quiz01.R;

import com.example.mcr.quiz01.R;
import java.util.LinkedList;
import java.util.List;

import retrofit.RestAdapter;

public class MainActivity extends Activity {

    private TextView txtName;
    private TextView txtEmail;
    private Button btnLogout;
    private Button categoryButton;
    private Button questionButton;
    private Button testButton;

    public Student loggedTeacher;
    private List<Student> loggedTeachers;
    private String studentName, studentEmail;
    private int studentId, studentSchoolClassId;




    ;




    ;


    public void onClickTest(View v) {
        Intent intent = new Intent(getApplicationContext(), TestListActivity.class);
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



        txtName.setText("Nazwa uzytkownika: "+studentName);
        txtEmail.setText("Email: "+studentEmail);


    }

}