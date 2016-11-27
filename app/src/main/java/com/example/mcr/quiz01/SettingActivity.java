package com.example.mcr.quiz01;

import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RadioButton;

/**
 * Created by MCR on 03.09.2016.
 */
public class SettingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);




    }
    public void onClickSounds(View view) {
        // Is the view now checked?
        boolean checked = ((CheckBox) view).isChecked();

        // Check which checkbox was clicked
        switch(view.getId()) {
            case R.id.soundsCheck:
                if (checked) System.out.print("SOUNDS ON");

                else
                    System.out.print("SOUNDS OFF");
                break;

        }
    }

    public void onClickDifficulty(View view) {
        RadioButton easyRadio = (RadioButton) findViewById(R.id.easy);
        RadioButton mediumRadio = (RadioButton) findViewById(R.id.medium);
        RadioButton hardRadio = (RadioButton) findViewById(R.id.hard);
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.easy:
                if (checked)
                    // easy lvl

                    break;
            case R.id.medium:
                if (checked)
                    // medium lvl

                    break;
            case R.id.hard:
                if (checked)
                    // hard lvl

                    break;
        }
    }


    public void onClickReturn (View v){
        Intent intent = new Intent(getApplicationContext(), QuizActivity.class);
        startActivity(intent);
    };




}
