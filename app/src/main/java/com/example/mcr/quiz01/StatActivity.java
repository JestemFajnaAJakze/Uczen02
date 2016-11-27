package com.example.mcr.quiz01;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mcr.quiz01.model.Stat;

/**
 * Created by MCR on 03.09.2016.
 */
public class StatActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stat);
        Stat stat = new Stat();
        stat = getUserStat(1);
        TextView playedGames = (TextView) findViewById(R.id.playedGames);
        playedGames.setText("Rozpoczete testy: "+Integer.toString(stat.getPlayedGames()));

        TextView completedGames = (TextView) findViewById(R.id.completedGames);
        completedGames.setText("Ukonczone testy: "+Integer.toString(stat.getCompletedGames()));

        TextView score = (TextView) findViewById(R.id.score);
        score.setText("Zdobyte punkty: "+Integer.toString(stat.getScore()));

        TextView averageScore = (TextView) findViewById(R.id.averageScore);
        averageScore.setText("Sredni wynik: "+Integer.toString(stat.getAverageScore()));

        TextView lastCategoryPlayed = (TextView) findViewById(R.id.lastCategoryPlayed);
        lastCategoryPlayed.setText("Ostatnio rozpoczeto test z kategorii: "+stat.getLastCategoryPlayed());

        TextView lastGameScore = (TextView) findViewById(R.id.lastGameScore);
        lastGameScore.setText("Ostatnio uzytkano wynik: "+Integer.toString(stat.getLastGameScore()));




    }



    public void onClickReturn (View v){
        Intent intent = new Intent(getApplicationContext(), QuizActivity.class);
        startActivity(intent);
    };

    public Stat getUserStat(int userId){
        int playedGames;
        int completedGames;
        int score;
        int averageScore;
        String lastCategoryPlayed;
        int lastGameScore;
        Stat stat = new Stat();
        try {
            SQLiteOpenHelper quizDatabaseHelper = new QuizDatabaseHelper(this);
            SQLiteDatabase db = quizDatabaseHelper.getReadableDatabase();
            Cursor cursor = db.query("STAT", new String[]{"PLAYED_GAMES", "COMPLETED_GAMES", "SCORE", "AVERAGE_SCORE", "LAST_CATEGORY_PLAYED", "LAST_GAME_SCORE"}, "USER_ID = ? ", new String[]{Integer.toString(userId)}, null, null, null);

            if (cursor.moveToFirst()) {
                playedGames = cursor.getInt(0);
                completedGames = cursor.getInt(1);
                score = cursor.getInt(2);
                averageScore = cursor.getInt(3);
                lastCategoryPlayed = cursor.getString(4);
                lastGameScore = cursor.getInt(5);

                stat.setPlayedGames(playedGames);
                stat.setCompletedGames(completedGames);
                stat.setScore(score);
                stat.setAverageScore(averageScore);
                stat.setLastCategoryPlayed(lastCategoryPlayed);
                stat.setLastGameScore(lastGameScore);

            }
            cursor.close();
            db.close();


        }
        catch(SQLiteException e){
            Toast toast = Toast.makeText(this, "Baza danych jest niedostepna", Toast.LENGTH_SHORT);
            toast.show();
        }
        return stat;
    }


}
