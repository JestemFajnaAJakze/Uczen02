package com.example.mcr.quiz01;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
import android.view.View;
import android.widget.Button;


import android.widget.TextView;

public class QuizActivity extends AppCompatActivity {

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_quiz);




        }


        public void onClickPlay (View v){
            Intent intent = new Intent(getApplicationContext(), CategoryActivity.class);
            startActivity(intent);
        };

        public void onClickStats (View v){
            Intent intent = new Intent(getApplicationContext(), StatActivity.class);
            startActivity(intent);
        };
        public void onClickSettings (View v){
            Intent intent = new Intent(getApplicationContext(), SettingActivity.class);
            startActivity(intent);
        };
        public void onClickReturn (View v){
            Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
            startActivity(intent);
        };




}
