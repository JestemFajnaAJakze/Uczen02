package com.example.mcr.quiz01;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mcr.quiz01.model.Answer;
import com.example.mcr.quiz01.model.Question;
import com.example.mcr.quiz01.model.Test;

import java.util.ArrayList;

/**
 * Created by MCR on 02.09.2016.
 */
public class CurrentQuestionActivity extends AppCompatActivity {

    private static final int PROGRESS = 0x1;
    public static final int CHOSEN_CATEGORY = -1;

    private TextView question;
    private ProgressBar mProgress;
    private int mProgressStatus = 0;

    private Handler mHandler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_current);

        Test currentTest = new Test();
        currentTest.setName("Historia 1");
        ArrayList<Question> questionArrayList = new ArrayList<Question>();


        //PYTANIE 1
        Question question1 = new Question();
        question1.setName("Kogo pokonały wojska Rzeczypospolitej w bitwie pod Kircholmem");
        Answer answerA = new Answer("");
        answerA.setName("Szwedów");
        answerA.setIsCorrect(1);
        Answer answerB = new Answer("");
        answerB.setName("Turków");
        answerB.setIsCorrect(0);
        Answer answerC = new Answer("");
        answerC.setName("Tatarów");
        answerC.setIsCorrect(0);
        Answer answerD = new Answer("");
        answerD.setName("Kozaków");
        answerD.setIsCorrect(0);

        ArrayList<Answer> answerArrayList1 = new ArrayList<Answer>();
        answerArrayList1.add(answerA);
        answerArrayList1.add(answerB);
        answerArrayList1.add(answerC);
        answerArrayList1.add(answerD);
        question1.setAnswerList(answerArrayList1);
        questionArrayList.add(question1);

        /*//PYTANIE 2
       // Question question1 = new Question();
        question1.setName("Co oznaczał kryptonim 'Godzina W'?");
        //Answer answerA = new Answer("");
        answerA.setName("Wybuch powstania listopadowego");
        answerA.setIsCorrect(0);
       // Answer answerB = new Answer("");
        answerB.setName("Zamach na Hitlera w Wilczym Szańcu");
        answerB.setIsCorrect(0);
       // Answer answerC = new Answer("");
        answerC.setName("Atak III Rzeszy na Polske");
        answerC.setIsCorrect(0);
       // Answer answerD = new Answer("");
        answerD.setName("Wybuch powstania warszawskiego");
        answerD.setIsCorrect(1);

        //ArrayList<Answer> answerArrayList2 = new ArrayList<Answer>();
        answerArrayList1.add(answerA);
        answerArrayList1.add(answerB);
        answerArrayList1.add(answerC);
        answerArrayList1.add(answerD);
        question1.setAnswerList(answerArrayList1);
        questionArrayList.add(question1);*/

        TextView question = (TextView) findViewById(R.id.question);
        Button answer1 = (Button) findViewById(R.id.answerA);
        Button answer2 = (Button) findViewById(R.id.answerB);
        Button answer3 = (Button) findViewById(R.id.answerC);
        Button answer4 = (Button) findViewById(R.id.answerD);


        int sizeOfTest = 0;
        sizeOfTest = questionArrayList.size();
        Boolean empty = currentTest.getQuestionList().isEmpty();
        //answer1.setText("Czy pusta?: "+Boolean.toString(empty));
        //question.setText(currentTest.getQuestionList().get(0).getName());
        currentTest.getQuestionList();

    }
        //Button newExpenseButton = (Button) findViewById(R.id.add_expense);
        /*Intent intent = getIntent();
        //int choosenCategory = intent.getIntExtra(CHOSEN_CATEGORY);
        int chosenCategory = -1;
        ArrayList<Question>listOfQuestions = new ArrayList<Question>();
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            chosenCategory = extras.getInt("chosenCategory");


            //The key argument here must match that used in the other activity
        }


        TextView question = (TextView) findViewById(R.id.question);
        Button answerA = (Button) findViewById(R.id.answerA);
        Button answerB = (Button) findViewById(R.id.answerB);
        Button answerC = (Button) findViewById(R.id.answerC);
        Button answerD = (Button) findViewById(R.id.answerD);
        question.setText("Wybrana kategoria: "+chosenCategory);

        switch (chosenCategory){
            case 0:
                ArrayList<Question> questionsList = new ArrayList<Question>();
                questionsList = prepareQuestions(chosenCategory, 1);
                Question currentQuestion = new Question();

                ArrayList<Answer>answersList = new ArrayList<Answer>();
                answersList.get(0);
                Answer currentAnswerA = new Answer("");
                Answer currentAnswerB = new Answer("");
                Answer currentAnswerC = new Answer("");
                Answer currentAnswerD = new Answer("");
                currentAnswerA = answersList.get(0);
                currentAnswerB = answersList.get(1);
                currentAnswerC = answersList.get(2);
                currentAnswerD = answersList.get(3);

                *//*question.setText(currentQuestion.getName());
                answerA.setText(currentAnswerA.getName());
                answerB.setText(currentAnswerB.getName());
                answerC.setText(currentAnswerC.getName());
                answerD.setText(currentAnswerD.getName());
*//*

                break;
            case 1:
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
            case 5:
                break;
            case 6:
                break;
            case 7:
                break;
            default:
        }

        mProgress = (ProgressBar) findViewById(R.id.questionTimer);

        // Start lengthy operation in a background thread
        mProgressStatus =0;
        //question.setText(0);
        new Thread(new Runnable() {
            public void run() {
                while (mProgressStatus < 100) {
                    ++mProgressStatus;


                    // Update the progress bar
                    mHandler.post(new Runnable() {
                        public void run() {
                            mProgress.setProgress(mProgressStatus);
                        }
                    });
                    try{
                        Thread.sleep(1000);

                    }
                    catch (InterruptedException e){
                        e.printStackTrace();

                    }
                }
            }
        }).start();
    }

*/



    public void onClickA (View v){
        TextView question = (TextView) findViewById(R.id.question);
        question.setText("Wybralem A");
        System.out.print("Wybralem A");
    };

    public void onClickB (View v){

        TextView question = (TextView) findViewById(R.id.question);
        question.setText("Wybralem B");System.out.print("Wybralem B");
    };

    public void onClickC (View v){

        TextView question = (TextView) findViewById(R.id.question);
        question.setText("Wybralem C");System.out.print("Wybralem C");
    };

    public void onClickD (View v){
        TextView question = (TextView) findViewById(R.id.question);
        question.setText("Wybralem D");
        System.out.print("Wybralem D");
    };

    public ArrayList<Answer> getAnswerList(int questionId){
        String answerName;
        int isCorrect;
        ArrayList<Answer> answerList = new ArrayList<Answer>();
        try {
            SQLiteOpenHelper quizDatabaseHelper = new QuizDatabaseHelper(this);
            SQLiteDatabase db = quizDatabaseHelper.getReadableDatabase();
            //TO POWINNO zwrocic 4 rekordy
            Cursor cursor = db.query ("ANSWER", new String[] {"NAME", "IS_CORRECT"}, "QUESTION_ID = ? ", new String[] {Integer.toString(questionId)}, null, null, null);
            if(cursor.moveToFirst()){
                answerName = cursor.getString(0);
                isCorrect = cursor.getInt(1);
                Answer answer = new Answer("");
                answer.setName(answerName);
                answer.setIsCorrect(isCorrect);
                answerList.add(answer);
            }
            while(cursor.moveToNext()){
                answerName = cursor.getString(0);
                isCorrect = cursor.getInt(1);
                Answer answer = new Answer("");
                answer.setName(answerName);
                answer.setIsCorrect(isCorrect);
                answerList.add(answer);
            }
            cursor.close();
            db.close();

        }
        catch(SQLiteException e){
            Toast toast = Toast.makeText(this, "Baza danych jest niedostepna", Toast.LENGTH_SHORT);
            toast.show();
        }
        return answerList;
    }

    public ArrayList<Question> getQuestionList(int categoryId){
        String questionName;
        int questionId;
        ArrayList<Question> questionList = new ArrayList<Question>();

        try {
            SQLiteOpenHelper quizDatabaseHelper = new QuizDatabaseHelper(this);
            SQLiteDatabase db = quizDatabaseHelper.getReadableDatabase();
            Cursor cursor = db.query ("QUESTION", new String[] {"_id", "NAME"}, "CATEGORY_ID = ? ", new String[] {Integer.toString(categoryId)}, null, null, null);
            if(cursor.moveToFirst()){
                questionId = cursor.getInt(0);
                questionName = cursor.getString(1);
                Question question = new Question();
                question.setName(questionName);
                question.setAnswerList(getAnswerList(questionId));
                questionList.add(question);

            }
            while(cursor.moveToNext()){
                questionId = cursor.getInt(0);
                questionName = cursor.getString(1);
                Question question = new Question();
                question.setName(questionName);
                question.setAnswerList(getAnswerList(questionId));
                questionList.add(question);
            }
            cursor.close();
            db.close();

        }
        catch(SQLiteException e){
            Toast toast = Toast.makeText(this, "Baza danych jest niedostepna", Toast.LENGTH_SHORT);
            toast.show();
        }


        return questionList;
    }


    public ArrayList<Question> prepareQuestions(int categoryId, int difficultyLevel){
        int AmountOfQuestions = 0;
        ArrayList<Question> questionList = new ArrayList<Question>();
        ArrayList<Question> finalQuestionList = new ArrayList<Question>();
        //teraz wyciagamy liste wszystkich pytan
        questionList = getQuestionList(categoryId);
        AmountOfQuestions = questionList.size();
        //teraz losujemy tyle pytan ile wynosi difficultyLevel z przedziału [1, AmountOfQuestions-1]

        Question question = new Question();
        question = questionList.get(0);
        finalQuestionList.add(question);
        /*Random randomGenerator = new Random();
        for (int idx = 1; idx <= difficultyLevel; ++idx){
            int randomInt = randomGenerator.nextInt(AmountOfQuestions);
            Question question = new Question();
            question = questionList.get(randomInt);
            finalQuestionList.add(question);
        }*/


        return  finalQuestionList;
    }


}
