package com.example.mcr.quiz01;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.mcr.quiz01.model.User;


/**
 * Created by MCR on 03.09.2016.
 */
public class LoginActivity extends AppCompatActivity {

    String emailValue;
    String passwordValue;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        /*EditText email = (EditText) findViewById(R.id.email);
        EditText password = (EditText) findViewById(R.id.password);
        emailValue = email.getText().toString();
        passwordValue = password.getText().toString();*/


    }


    public void onClickLogin (View v){
        logIn();

    };

    public void onClickRegister (View v){

        Intent intent = new Intent(getApplicationContext(), RegisterActivity.class);
        startActivity(intent);
    };

    public void logIn(){
        try{

            Boolean correctLogin = false;
            EditText email = (EditText) findViewById(R.id.email);
            EditText password = (EditText) findViewById(R.id.password);

            emailValue = email.getText().toString();
            passwordValue = password.getText().toString();
            User userCurrent = new User();
            userCurrent.setEmail("test@test.pl");
            userCurrent.setPassword("test");
            userCurrent.setName("TEST");

           // userCurrent = getCurrentUser(emailValue, passwordValue);
            //zmienic na pobieranie z bazy!!!!!!



            //correctLogin=true;
            correctLogin = (emailValue.equals(userCurrent.getEmail()) && passwordValue.equals(userCurrent.getPassword()));
            correctLogin=true;
            if(correctLogin){
                Toast toast = Toast.makeText(this, "Witaj "+userCurrent.getName()+"!", Toast.LENGTH_SHORT);
                toast.show();
                //and finally...
                Intent intent = new Intent(getApplicationContext(), QuizActivity.class);
                startActivity(intent);

                //email.setText();

            }else{
                Toast toast = Toast.makeText(this, "Wprowadzono błędne dane", Toast.LENGTH_SHORT);
                toast.show();

            }

/*
            if(!(email.toString().equals(emailValue))  && !(password.toString().equals(passwordValue))){


                emailValue = email.getText().toString();
                passwordValue = password.getText().toString();
                User userCurrent = new User();
                userCurrent = getCurrentUser(emailValue, passwordValue);
                //zmienic na pobieranie z bazy!!!!!!
                //correctLogin=true;
                correctLogin = isCorrectUser(userCurrent);
                if(correctLogin){
                    Toast toast = Toast.makeText(this, "Witaj!", Toast.LENGTH_SHORT);
                    toast.show();
                    //and finally...
                    Intent intent = new Intent(getApplicationContext(), QuizActivity.class);
                    startActivity(intent);
                }else{
                    Toast toast = Toast.makeText(this, "Wprowadzono błędne dane", Toast.LENGTH_SHORT);
                    toast.show();

                }


            }else{
                Toast toast = Toast.makeText(this, "Wprowadź dane do logowania", Toast.LENGTH_SHORT);
                toast.show();
            }*/

           /* TextView button2 = (TextView) findViewById(R.id.button2);
            button2.setText(category.getName());*/




        }catch(Exception e){

        }
    }

    public User getCurrentUser(String email, String password){
        User user = new User();
        try {
            SQLiteOpenHelper quizDatabaseHelper = new QuizDatabaseHelper(this);
            SQLiteDatabase db = quizDatabaseHelper.getReadableDatabase();
            Cursor cursor = db.query ("USER", new String[] {"_id, NAME, EMAIL, PASSWORD"}, "EMAIL = ? AND PASSWORD = ?", new String[] {email, password}, null, null, null);

            if(cursor.moveToFirst()){
                user.setId(cursor.getInt(0));
                user.setName(cursor.getString(1));
                user.setEmail(cursor.getString(2));
                user.setPassword(cursor.getString(3));


            }
            cursor.close();
            db.close();

        }
        catch(SQLiteException e){
            Toast toast = Toast.makeText(this, "Baza danych jest niedostepna", Toast.LENGTH_SHORT);
            toast.show();
        }
        return user;
    }

    /*public boolean isCorrectUser(User user){
        Boolean isCorrectUser = false;
        if(user.equals(null)){
            Toast toast = Toast.makeText(this, "Wprowadzono błędne dane", Toast.LENGTH_SHORT);
            toast.show();

        }else{
            isCorrectUser=true;
        }

        return isCorrectUser;
    }*/



}
