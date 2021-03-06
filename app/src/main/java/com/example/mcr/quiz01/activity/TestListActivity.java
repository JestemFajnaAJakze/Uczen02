package com.example.mcr.quiz01.activity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mcr.quiz01.R;

import com.example.mcr.quiz01.model.Category;
import com.example.mcr.quiz01.model.Question;
import com.example.mcr.quiz01.model.Test;
import com.example.mcr.quiz01.network.RetrofitAPI;
import com.squareup.okhttp.OkHttpClient;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.OkClient;

/**
 * Created by MCR on 24.11.2016.
 */
public class TestListActivity extends Activity implements AdapterView.OnItemClickListener, AdapterView.OnItemSelectedListener {

    static final String API_URL = "http://192.168.1.100/android_login_api2";
    ListView test_listview;
    RestAdapter restAdapter;
    List<HashMap<String,Object>> testMapList;
    HashMap<String, Object> testMap;
    private ArrayList<Test> testsFinalList;
    private ArrayList<String>testsFinalListNames;
    private ArrayList<Integer>testsFinalListIds;
    private Test test;
    private String studentName, studentEmail, studentClass;
    private int studentId, studentSchoolClassId;
    private Spinner spinner;
    private ArrayList<String> questionsNameList, categoryNameList;
    private ArrayList<Integer> questionsIdsList, categoryIdList;
    private int choosenCategoryId;
    private ListView choosenQuestionList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_list);

        studentClass = getIntent().getStringExtra("studentClass");
        studentId = getIntent().getIntExtra("studentId", 0);
        studentSchoolClassId = getIntent().getIntExtra("studentSchoolClassId", 0);

        TextView title = (TextView)findViewById(R.id.titleTest);
        title.setText("Dostepne testy dla klasy: "+studentClass);

        spinner = (Spinner) findViewById(R.id.spinner);
        spinner.setOnItemSelectedListener(this);

        test_listview = (ListView) findViewById(R.id.test_listview);
        test_listview.setOnItemClickListener(this);

        OkHttpClient mOkHttpClient = new OkHttpClient();
        mOkHttpClient.setConnectTimeout(15000, TimeUnit.MILLISECONDS);
        mOkHttpClient.setReadTimeout(15000, TimeUnit.MILLISECONDS);

        restAdapter = new RestAdapter.Builder()
                .setEndpoint(API_URL)
                .setClient(new OkClient(mOkHttpClient))
                .setLogLevel(RestAdapter.LogLevel.FULL)
                .build();
        RetrofitAPI methods = restAdapter.create(RetrofitAPI.class);


        Callback<List<Test>> cb = new Callback<List<Test>>() {

            @Override
            public void success(List<Test> tests, retrofit.client.Response response) {

                testsFinalListNames = new ArrayList<>();
                testsFinalListIds = new ArrayList<>();

                for(Test t: tests){

                    try {



                        testsFinalListNames.add(t.getName());
                        testsFinalListIds.add(t.getTest_id());

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                ArrayAdapter<String> adapter = new ArrayAdapter<String>(getApplication(), android.R.layout.simple_list_item_1, testsFinalListNames);
                test_listview.setAdapter(adapter);
            }



            @Override
            public void failure(RetrofitError error) {
                Log.e("TestListActivity", error.getMessage() +"\n"+ error.getStackTrace());
                error.printStackTrace();
            }
        };
        methods.getTestsListByClassId(studentSchoolClassId, cb);

        OkHttpClient mOkHttpClient2 = new OkHttpClient();
        mOkHttpClient2.setConnectTimeout(15000, TimeUnit.MILLISECONDS);
        mOkHttpClient2.setReadTimeout(15000, TimeUnit.MILLISECONDS);

        restAdapter = new RestAdapter.Builder()
                .setEndpoint(API_URL)
                .setClient(new OkClient(mOkHttpClient2))
                .setLogLevel(RestAdapter.LogLevel.FULL)
                .build();
        RetrofitAPI methods2 = restAdapter.create(RetrofitAPI.class);


        Callback<List<Category>> cb2 = new Callback<List<Category>>() {

            @Override
            public void success(List<Category> categories, retrofit.client.Response response) {

                categoryIdList = new ArrayList<>();
                categoryNameList = new ArrayList<>();
                for (Category c : categories) {

                    categoryIdList.add(c.getCategory_id());
                    categoryNameList.add(c.getName());

                }
                ArrayAdapter<String> adapter = new ArrayAdapter<String>(getApplication(), android.R.layout.simple_list_item_1, categoryNameList);

                spinner.setAdapter(adapter);
            }


            @Override
            public void failure(RetrofitError error) {
                Log.e("AddQuestionListActivity", error.getMessage() + "\n" + error.getStackTrace());
                error.printStackTrace();



            }
        };
        methods2.getCategoryList(cb2);


    }

    @Override
    protected void onRestart() {
        super.onRestart();
        setContentView(R.layout.activity_test_list);

        test_listview = (ListView) findViewById(R.id.test_listview);
        test_listview.setOnItemClickListener(this);

        OkHttpClient mOkHttpClient = new OkHttpClient();
        mOkHttpClient.setConnectTimeout(15000, TimeUnit.MILLISECONDS);
        mOkHttpClient.setReadTimeout(15000, TimeUnit.MILLISECONDS);

        restAdapter = new RestAdapter.Builder()
                .setEndpoint(API_URL)
                .setClient(new OkClient(mOkHttpClient))
                .setLogLevel(RestAdapter.LogLevel.FULL)
                .build();
        RetrofitAPI methods = restAdapter.create(RetrofitAPI.class);


        Callback<List<Test>> cb = new Callback<List<Test>>() {

            @Override
            public void success(List<Test> tests, retrofit.client.Response response) {

                testsFinalListNames = new ArrayList<>();
                testsFinalListIds = new ArrayList<>();

                for(Test t: tests){

                    try {



                        testsFinalListNames.add(t.getName());
                        testsFinalListIds.add(t.getTest_id());

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                ArrayAdapter<String> adapter = new ArrayAdapter<String>(getApplication(), android.R.layout.simple_list_item_1, testsFinalListNames);

                test_listview.setAdapter(adapter);
            }



            @Override
            public void failure(RetrofitError error) {
                Log.e("TestListActivity", error.getMessage() +"\n"+ error.getStackTrace());
                error.printStackTrace();
            }
        };
        methods.getTestsListByClassId(studentSchoolClassId, cb);



    }


    public void onClickAddTestActivity(View v){
        Intent intent = new Intent(getApplicationContext(), TestAddActivity.class);
        startActivity(intent);
    }

    public void onClickBackButton(View v){
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        intent.putExtra("studentId", studentId);
        intent.putExtra("studentSchoolClassId", studentSchoolClassId);
        intent.putExtra("studentName", studentId);
        intent.putExtra("studentClass", studentClass);
        startActivity(intent);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        /*Toast.makeText(getApplicationContext(),
                "Element: "+position, Toast.LENGTH_LONG)
                .show();*/
        int choosenTestId = 0;
        choosenTestId = testsFinalListIds.get(position);
        //choosenTestId = position+1;
        Toast.makeText(getApplicationContext(),
                "Name: "+testsFinalListNames.get(position), Toast.LENGTH_SHORT)
                .show();
        Intent intent = new Intent(getApplicationContext(), TestActivity.class);
        intent.putExtra("position", testsFinalListIds.get(position));
        intent.putExtra("testName", testsFinalListNames.get(position));


        startActivity(intent);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        //zapisujemy id kategorii pytania
        choosenCategoryId = categoryIdList.get(position);

        choosenQuestionList = (ListView) findViewById(R.id.choosenQuestionList);


        OkHttpClient mOkHttpClient = new OkHttpClient();
        mOkHttpClient.setConnectTimeout(15000, TimeUnit.MILLISECONDS);
        mOkHttpClient.setReadTimeout(15000, TimeUnit.MILLISECONDS);

        restAdapter = new RestAdapter.Builder()
                .setEndpoint(API_URL)
                .setClient(new OkClient(mOkHttpClient))
                .setLogLevel(RestAdapter.LogLevel.FULL)
                .build();
        RetrofitAPI methods = restAdapter.create(RetrofitAPI.class);


        questionsNameList = new ArrayList<>();
        questionsIdsList = new ArrayList<>();
        Callback<List<Question>> cb = new Callback<List<Question>>() {


            @Override
            public void success(List<Question> questions, retrofit.client.Response response) {

                for (Question q : questions) {

                    questionsIdsList.add(q.getQuestion_id());
                    questionsNameList.add(q.getName());

                    ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(getApplication(), android.R.layout.simple_list_item_1, questionsNameList);
                    choosenQuestionList.setAdapter(adapter2);


                }

            }

            @Override
            public void failure(RetrofitError error) {
                Log.e("TestAddActivity", error.getMessage() + "\n" + error.getStackTrace());
                error.printStackTrace();
                questionsNameList.add("Dla wybranej kategorii nie ma zadnych pytan.");
                ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(getApplication(), android.R.layout.simple_list_item_1, questionsNameList);
                choosenQuestionList.setAdapter(adapter2);
            }
        };
        methods.getQuestionListByCategory(choosenCategoryId, cb);

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}