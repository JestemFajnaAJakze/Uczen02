package com.example.mcr.quiz01;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mcr.quiz01.model.Category;

import java.util.ArrayList;

/**
 * Created by MCR on 02.09.2016.
 */
public class CategoryActivity extends AppCompatActivity {

    private SQLiteDatabase db;
    private Cursor cursor;

    //public static final int CHOSEN_CATEGORY = 99;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);

        ArrayList<Category> categoriesList = new ArrayList<Category>();
        categoriesList=getCategoriesList();

        Category category = new Category();
        TextView categorytitle = (TextView) findViewById(R.id.categorytitle);
        categorytitle.setText(Integer.toString(categoriesList.size()));

        /*QuizDatabaseHelper quizDatabaseHelper = new QuizDatabaseHelper(this);
        //quizDatabaseHelper.onUpgrade(db, 1 , 2);



        quizDatabaseHelper.onCreate(db);*/


/*

        category = categoriesList.get(0);
        Button button1 = (Button) findViewById(R.id.button1);
        button1.setText(category.getName());

        category = categoriesList.get(1);
        Button button2 = (Button) findViewById(R.id.button2);
        button2.setText(category.getName());

        category = categoriesList.get(2);
        Button button3 = (Button) findViewById(R.id.button3);
        button3.setText(category.getName());




        category = categoriesList.get(3);
        Button button4 = (Button) findViewById(R.id.button4);
        button4.setText(category.getName());

        category = categoriesList.get(4);
        Button button5 = (Button) findViewById(R.id.button5);
        button5.setText(category.getName());

        category = categoriesList.get(5);
        Button button6 = (Button) findViewById(R.id.button6);
        button6.setText(category.getName());

        category = categoriesList.get(6);
        Button button7 = (Button) findViewById(R.id.button7);
        button7.setText(category.getName());

        category = categoriesList.get(7);
        Button button8 = (Button) findViewById(R.id.button8);
        button8.setText(category.getName());
*/


        //ListView listCategory = getListView();

       /* try {
        SQLiteOpenHelper categoryDatabaseHelper = new QuizDatabaseHelper(this);
        db = categoryDatabaseHelper.getReadableDatabase();
        cursor = db.query("CATEGORY", new String[]{"_id", "NAME"},null, null, null, null, null);
        SimpleCursorAdapter adapter = new SimpleCursorAdapter(this,
                android.R.layout.simple_list_item_1,
                cursor,
                new String[]{"NAME"},
                new int[]{android.R.id.text1},
                0);

        if (cursor.moveToFirst()) {
            String nameCategory = cursor.getString(1);
            TextView categorytitle = (TextView) findViewById(R.id.categorytitle);
            categorytitle.setText(nameCategory);
        }
        //listCategory.setAdapter(listAdapter);
    }
    catch (SQLiteException e){
        Toast toast = Toast.makeText(this, "Baza danych jest niedostepna", Toast.LENGTH_SHORT);
        toast.show();
    }*/
}

    @Override
    public void onDestroy(){
        super.onDestroy();
        cursor.close();
        db.close();
    }

    //TextView categorytitle = (TextView) findViewById(R.id.categorytitle);

    public void onClickHistory (View v){


            Intent intent = new Intent(getApplicationContext(), CurrentQuestionActivity.class);
        intent.putExtra("chosenCategory", 7);
            startActivity(intent);



    };

    public void onClickPolish (View v){

        Intent intent = new Intent(getApplicationContext(), CurrentQuestionActivity.class);
        intent.putExtra("chosenCategory", 5);
        startActivity(intent);
    };

    public void onClickChemistry (View v){

        Intent intent = new Intent(getApplicationContext(), CurrentQuestionActivity.class);
        intent.putExtra("chosenCategory", 4);
        startActivity(intent);
    };

    public void onClickMath (View v){
        Intent intent = new Intent(getApplicationContext(), CurrentQuestionActivity.class);
        intent.putExtra("chosenCategory", 3);
        startActivity(intent);
    };
    public void onClickPhysics (View v){
        Intent intent = new Intent(getApplicationContext(), CurrentQuestionActivity.class);
        intent.putExtra("chosenCategory", 8);
        startActivity(intent);
    };
    public void onClickWos (View v){
        Intent intent = new Intent(getApplicationContext(), CurrentQuestionActivity.class);
        intent.putExtra("chosenCategory", 6);
        startActivity(intent);
    };
    public void onClickGeography (View v){
        //Intent intent = new Intent(getApplicationContext(), QuestionActivity.class);

        Intent intent = new Intent(getApplicationContext(), QuestionActivity.class);
        //intent.putExtra("chosenCategory", 1);
        startActivity(intent);

        //startActivity(intent);
    };
    public void onClickBiology (View v){
        Intent intent = new Intent(getApplicationContext(), CurrentQuestionActivity.class);

        //int chosenCategory;
        intent.putExtra("chosenCategory", 2);
        startActivity(intent);
    };

    public void onClickReturn (View v){
        Intent intent = new Intent(getApplicationContext(), QuizActivity.class);
        startActivity(intent);
    };

    public ArrayList<Category> getCategoriesList(){
        String categoryName;
        int imageResourceId;
        ArrayList<Category> categoriesList = new ArrayList<Category>();
        try {
            SQLiteOpenHelper quizDatabaseHelper = new QuizDatabaseHelper(this);
            SQLiteDatabase db = quizDatabaseHelper.getReadableDatabase();
            Cursor cursor = db.query("CATEGORY", new String[]{"NAME", "IMAGE_RESOURCE_ID"}, null, null, null, null, null);
            if(cursor.moveToFirst()){
                categoryName = cursor.getString(0);
                imageResourceId = cursor.getInt(1);
                Category category = new Category();
                category.setName(categoryName);
                category.setImageResourceId(imageResourceId);
                categoriesList.add(category);
            }
            while(cursor.moveToNext()){
                categoryName = cursor.getString(0);
                imageResourceId = cursor.getInt(1);
                Category category = new Category();
                category.setName(categoryName);
                category.setImageResourceId(imageResourceId);
                categoriesList.add(category);
            }
            cursor.close();
            db.close();

        }
        catch(SQLiteException e){
            Toast toast = Toast.makeText(this, "Baza danych jest niedostepna", Toast.LENGTH_SHORT);
            toast.show();
        }

        return categoriesList;
    }



}

