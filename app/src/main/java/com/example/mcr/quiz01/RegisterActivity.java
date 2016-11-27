package com.example.mcr.quiz01;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * Created by MCR on 03.09.2016.
 */
public class RegisterActivity  extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

    }


    public void onClickRegister (View v){
        Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
        startActivity(intent);
    };

    public void onClickReturn (View v){

        Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
        startActivity(intent);
    };



}

