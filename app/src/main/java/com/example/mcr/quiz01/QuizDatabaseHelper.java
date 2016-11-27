package com.example.mcr.quiz01;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import com.example.mcr.quiz01.R;
import com.example.mcr.quiz01.model.Stat;

/**
 * Created by MCR on 07.09.2016.
 */
public class QuizDatabaseHelper extends SQLiteOpenHelper {

    private static final String DB_NAME = "quiz";
    private static final int DB_VERSION = 1;

    QuizDatabaseHelper(Context context){
        super(context, DB_NAME, null, DB_VERSION);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("CREATE TABLE CATEGORY (_id INTEGER PRIMARY KEY AUTOINCREMENT, "
                + "NAME TEXT, "
                + "IMAGE_RESOURCE_ID);");
        //QUESTION
        db.execSQL("CREATE TABLE QUESTION (_id INTEGER PRIMARY KEY AUTOINCREMENT, "
                + "NAME TEXT, "
                + "CATEGORY_ID INTEGER);");
        //ANSWER
        db.execSQL("CREATE TABLE ANSWER (_id INTEGER PRIMARY KEY AUTOINCREMENT, "
                + "NAME TEXT, "
                + "IS_CORRECT INTEGER, "
                + "QUESTION_ID INTEGER);");
        //USER
        db.execSQL("CREATE TABLE USER (_id INTEGER PRIMARY KEY AUTOINCREMENT, "
                + "NAME TEXT, "
                + "EMAIL TEXT, "
                + "PASSWORD TEXT);");
        //STAT
        db.execSQL("CREATE TABLE STAT (_id INTEGER PRIMARY KEY AUTOINCREMENT, "
                + "PLAYED_GAMES INTEGER, "
                + "COMPLETED_GAMES INTEGER, "
                + "SCORE INTEGER, "
                + "AVERAGE_SCORE INTEGER, "
                + "LAST_CATEGORY_PLAYED TEXT, "
                + "LAST_GAME_SCORE INTEGER, "
                + "USER_ID INTEGER);");

        insertCategory(db, "Geografia", R.drawable.geography);
        insertCategory(db, "Biologia", R.drawable.biology);
        insertCategory(db, "Matematyka", R.drawable.math);
        insertCategory(db, "Chemia", R.drawable.math);
        insertCategory(db, "Język Polski", R.drawable.math);
        insertCategory(db, "WOS", R.drawable.math);
        insertCategory(db, "Historia", R.drawable.math);
        insertCategory(db, "Fizyka", R.drawable.math);
        insertUser(db, "test", "test@test.pl", "test");
        insertUser(db, "a", "at@a.pl", "a");
        insertStat(db, 0, 0, 0, 0, "BRAK", 0, 1);
        insertStat(db, 10, 10, 10, 10, "Historia", 10, 2);


        //pytania i odpowiedzi
        //geografia
        insertQuestion(db, "Najdluższa rzeka w Europie to...", 1);
        insertAnswer(db, "Ren", 0, 1);
        insertAnswer(db, "Sekwana", 0, 1);
        insertAnswer(db, "Dunaj", 1, 1);
        insertAnswer(db, "Wołga", 0, 1);

        insertQuestion(db, "Najwyższy szczyt w Europie to...", 1);
        insertAnswer(db, "Gerlach", 0, 2);
        insertAnswer(db, "Monte Rosa", 0, 2);
        insertAnswer(db, "Góra Kościuszki", 0, 2);
        insertAnswer(db, "Mount Blanc", 1, 2);

        insertQuestion(db, "Stolica Bułgarii to...", 1);
        insertAnswer(db, "Sofia", 1, 3);
        insertAnswer(db, "Varna", 0, 3);
        insertAnswer(db, "Zagrzeb", 0, 3);
        insertAnswer(db, "Skopje", 0, 3);

        insertQuestion(db, "Do jakiego państwa należy Madera...", 1);
        insertAnswer(db, "Do Portugalii", 1, 4);
        insertAnswer(db, "Do Grecji", 0, 4);
        insertAnswer(db, "Do żadnego - Madera jest państwem", 0, 4);
        insertAnswer(db, "Do Hiszpanii", 0, 4);

        insertQuestion(db, "Które morze NIE oblewa Grecji...", 1);
        insertAnswer(db, "Morze Egejskie", 0, 5);
        insertAnswer(db, "Morze Jońskie", 0, 5);
        insertAnswer(db, "Morze Kreteńskie", 0, 5);
        insertAnswer(db, "Morze Koryńskie", 1, 5);

        insertQuestion(db, "Teneryfa to...", 1);
        insertAnswer(db, "Nazwa wybrzeża", 0, 6);
        insertAnswer(db, "Miasto", 0, 6);
        insertAnswer(db, "Wyspa", 1, 6);
        insertAnswer(db, "Państwo", 0, 6);

        insertQuestion(db, "Alpy NIE sa polożone na terytorium...", 1);
        insertAnswer(db, "Niemiec", 0, 7);
        insertAnswer(db, "Włoch", 0, 7);
        insertAnswer(db, "Francji", 0, 7);
        insertAnswer(db, "Portugalii", 0, 7);

        insertQuestion(db, "Belgia NIE graniczy z...", 1);
        insertAnswer(db, "Luksemburgiem", 0, 8);
        insertAnswer(db, "Danią", 1, 8);
        insertAnswer(db, "Holandią", 0, 8);
        insertAnswer(db, "Francją", 0, 8);

        insertQuestion(db, "Tirana to stolicą...", 1);
        insertAnswer(db, "Albanii", 0, 9);
        insertAnswer(db, "Serbii", 0, 9);
        insertAnswer(db, "Bośni i Hercegowiny", 0, 9);
        insertAnswer(db, "Bułgarii", 0, 9);

//biologia

        insertQuestion(db, "Który z organów w ciele człowieka jest największy?", 2);
        insertAnswer(db, "Płuca", 0, 1);
        insertAnswer(db, "Skóra", 1, 1);
        insertAnswer(db, "Mózg", 0, 1);
        insertAnswer(db, "Jelito grube", 0, 1);

        insertQuestion(db, "Endorfiny to hormony, które wywołują uczucie...", 2);
        insertAnswer(db, "Szczęścia", 1, 2);
        insertAnswer(db, "Smutku", 0, 2);
        insertAnswer(db, "Złości", 0, 2);
        insertAnswer(db, "Strachu", 0, 2);

        insertQuestion(db, "Ile zębów powiniem mieć dorosły, zdrowy człowiek?", 2);
        insertAnswer(db, "30", 0, 3);
        insertAnswer(db, "32", 1, 3);
        insertAnswer(db, "28", 0, 3);
        insertAnswer(db, "20", 0, 3);

//matematyka
        insertQuestion(db, "3 do sześcianu to...", 3);
        insertAnswer(db, "81", 0, 1);
        insertAnswer(db, "9", 0, 1);
        insertAnswer(db, "6", 0, 1);
        insertAnswer(db, "27", 1, 1);

        insertQuestion(db, "Rzucamy 2 razy monetą. Jakie jest prawdopodobieństwo, że 2 razy wypadnie orzeł?", 3);
        insertAnswer(db, "3/4", 0, 2);
        insertAnswer(db, "1/4", 1, 2);
        insertAnswer(db, "1/3", 0, 2);
        insertAnswer(db, "1/2", 0, 2);

        insertQuestion(db, "Ile wynosi pierwiastek sześcienny ze 125?", 3);
        insertAnswer(db, "5", 1, 3);
        insertAnswer(db, "4", 0, 3);
        insertAnswer(db, "15", 0, 3);
        insertAnswer(db, "25", 0, 3);

        insertQuestion(db, "Wynikiem działania 5^(-1) jest...", 3);
        insertAnswer(db, "-5", 1, 4);
        insertAnswer(db, "0,2", 0, 4);
        insertAnswer(db, "0", 0, 4);
        insertAnswer(db, "-1/5", 0, 4);

        insertQuestion(db, "Rozwiązaniem równania x^2-3x jest...", 3);
        insertAnswer(db, "x=3 lub x=0", 1, 5);
        insertAnswer(db, "x=2", 0, 5);
        insertAnswer(db, "x=1/3", 0, 5);
        insertAnswer(db, "x=9", 0, 5);

//chemia
        insertQuestion(db, "Jaka jest liczba atomowa tlenu?", 4);
        insertAnswer(db, "10", 0, 1);
        insertAnswer(db, "8", 1, 1);
        insertAnswer(db, "4", 0, 1);
        insertAnswer(db, "16", 0, 1);

        insertQuestion(db, "Jaki pierwiastek występuje w dużej ilości w bananach?", 4);
        insertAnswer(db, "Wapń", 0, 2);
        insertAnswer(db, "Fosfor", 0, 2);
        insertAnswer(db, "Jod", 0, 2);
        insertAnswer(db, "Potas", 1, 2);

        insertQuestion(db, "Temperatura wrzenia wody to...", 4);
        insertAnswer(db, "173K", 0, 3);
        insertAnswer(db, "273K", 0, 3);
        insertAnswer(db, "327K", 1, 3);
        insertAnswer(db, "0K", 0, 3);

//polski
        insertQuestion(db, "Dokończ przysłowie: Nosił wilk razy kilka...", 5);
        insertAnswer(db, "teraz noszą futro z wilka", 0, 1);
        insertAnswer(db, "ponieśli i wilka", 1, 1);
        insertAnswer(db, "przyszedł czas i na wilka", 0, 1);
        insertAnswer(db, "ale zjadła owca wilka", 0, 1);

        insertQuestion(db, "Dokończ przysłowie: Nie bierz...", 5);
        insertAnswer(db, "czego tykac nie chcesz", 0, 2);
        insertAnswer(db, "póki nie zapłacisz", 0, 2);
        insertAnswer(db, "czegoś nie zgubił", 0, 2);
        insertAnswer(db, "gdzieś nie położył", 1, 2);

        insertQuestion(db, "Dokończ przysłowie: Gdzie baba rządzi...", 5);
        insertAnswer(db, "tam diabeł błądzi", 0, 3);
        insertAnswer(db, "tam chłop nie błądzi", 0, 3);
        insertAnswer(db, "tam i chłop zbłądzi", 1, 3);
        insertAnswer(db, "tylko Bóg osądzi", 0, 3);

//wos

        insertQuestion(db, "Pogląd, iż człowiek jest istotą społeczną sformułował...", 6);
        insertAnswer(db, "Epikur", 0, 1);
        insertAnswer(db, "Heraklit", 0, 1);
        insertAnswer(db, "Eurypides", 0, 1);
        insertAnswer(db, "Arystoteles", 1, 1);

        insertQuestion(db, "Ważnośc wyborów do Sejmu i Senatu w Polsce stwierdza...", 6);
        insertAnswer(db, "Trybunał Konstytucyjny", 0, 2);
        insertAnswer(db, "Państwowa Komisja Wyborcza", 0, 2);
        insertAnswer(db, "Naczelny Sąd Administracyjny", 0, 2);
        insertAnswer(db, "Sąd Najwyższy", 1, 2);

        insertQuestion(db, "Europejski Trybunał Praw Człowieka w Strasburgu rozpatruje skargi dotyczące naruszenia...?", 6);
        insertAnswer(db, "Karty Praw Podstawowych", 0, 3);
        insertAnswer(db, "Powszechnej Deklaracji Praw Człowieka", 0, 3);
        insertAnswer(db, "Konwencji o Ochronie Praw Człowieka i Podstawowych Wolności", 1, 3);
        insertAnswer(db, "Międzynarodowego Paktu Praw Obywatelskich i Politycznych", 0, 3);

        insertQuestion(db, "Mediacja, jako jeden ze sposobów rozwiązywania konfliktów, polega na...", 6);
        insertAnswer(db, "podjęciu bezpośrednich rozmów przez strony konfliktu", 0, 4);
        insertAnswer(db, "poddaniu konfliktu pod osąd społeczny", 0, 4);
        insertAnswer(db, "rozstrzygnięciu konfliktu przez wybranego arbitra", 0, 4);
        insertAnswer(db, "pośredniczeniu osoby bezstronnej w sporze w celu ułatwienia stronom konfliktu osiągnięcia porozumienia", 1, 4);

//historia
        insertQuestion(db, "Kryptonim Godzina W oznaczał porę...", 7);
        insertAnswer(db, "wybuchu powstania warszawskiego", 1, 1);
        insertAnswer(db, "ataku III Rzeszy na Polskę", 0, 1);
        insertAnswer(db, "zamachu na Hitlera w Wilczym Szańcu", 0, 1);
        insertAnswer(db, "podpisania bezwarunkowej kapitulacji III Rzeszy", 0, 1);

        insertQuestion(db, "Kto zastał Polskę drewnianą, a zostawił murowaną?", 7);
        insertAnswer(db, "Zygmunt I Stary", 0, 2);
        insertAnswer(db, "Władysław Jagiełło", 0, 2);
        insertAnswer(db, "Kazimierz Wielki", 1, 2);
        insertAnswer(db, "Bolesław Chrobry", 0, 2);

        insertQuestion(db, "Kogo pokonały wojska Rzeczypospolitej w bitwie pod Kircholmem?", 7);
        insertAnswer(db, "Szwedów", 1, 3);
        insertAnswer(db, "Turków", 0, 3);
        insertAnswer(db, "Tatarów", 0, 3);
        insertAnswer(db, "Krzyżaków", 0, 3);

        insertQuestion(db, "Kto przeniósł stolicę Polski z Krakowa do Warszawy?", 7);
        insertAnswer(db, "Zygmunt I Stary", 1, 4);
        insertAnswer(db, "Kazimierz Wielki", 0, 4);
        insertAnswer(db, "Stanisław August Poniatowski", 0, 4);
        insertAnswer(db, "Jan III Sobieski", 0, 4);

//fizyka

        insertQuestion(db, "Prędkość światła w powietrzu wynosi...", 8);
        insertAnswer(db, "340 m/s", 1, 1);
        insertAnswer(db, "340 km/h", 0, 1);
        insertAnswer(db, "300000 km/s", 1, 1);
        insertAnswer(db, "300000 m/s", 0, 1);

        insertQuestion(db, "Przejście ze stanu gazowego w stały...", 8);
        insertAnswer(db, "jest niemozliwy", 0, 2);
        insertAnswer(db, "nazywamy topnieniem", 0, 2);
        insertAnswer(db, "nazywamy krzepnięciem", 0, 2);
        insertAnswer(db, "nazywamy resublimacją", 1, 2);

        insertQuestion(db, "Czego jednostką miary w układzie SI jest niuton [N]", 8);
        insertAnswer(db, "Siły", 1, 3);
        insertAnswer(db, "Temperatury", 0, 3);
        insertAnswer(db, "Natężenia prądu elektrycznego", 0, 3);
        insertAnswer(db, "Prędkości", 0, 3);




        //updateMyDatabase(db, 0, DB_VERSION);
        //insertCategory(db, "123", R.drawable.math);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        updateMyDatabase(db, oldVersion, newVersion);

        //insertCategory(db, "Jezyk angielski", R.drawable.math);

    }

    private static void updateStats(Stat s){
        //db.
    }

    private void updateMyDatabase(SQLiteDatabase db, int oldVersion, int newVersion){

       if(oldVersion < 1){

        //db.update()

        }
    }
    private  static void insertCategory(SQLiteDatabase db, String name, int resourceId){

        ContentValues categoryValues = new ContentValues();
        categoryValues.put("NAME", name);
        categoryValues.put("IMAGE_RESOURCE_ID", resourceId);
        db.insert("CATEGORY", null, categoryValues);
    }

    private static void insertQuestion(SQLiteDatabase db, String name, int categoryId){
        ContentValues questionValues = new ContentValues();
        questionValues.put("NAME", name);
        questionValues.put("CATEGORY_ID", categoryId);
        db.insert("QUESTION", null, questionValues);
    }

    private static void insertAnswer(SQLiteDatabase db, String name, int isCorrect, int questionId){
        ContentValues answerValues = new ContentValues();
        answerValues.put("NAME", name);
        answerValues.put("IS_CORRECT", isCorrect);
        answerValues.put("QUESTION_ID", questionId);
        db.insert("ANSWER", null, answerValues);
    }
    private static void insertUser(SQLiteDatabase db, String name, String email, String password){
        ContentValues userValues = new ContentValues();
        userValues.put("NAME", name);
        userValues.put("EMAIL", email);
        userValues.put("PASSWORD", password);
        db.insert("USER", null, userValues);
    }
    private static void insertStat(SQLiteDatabase db, int playedGames, int completedGames, int score, int averageScore, String lastCategoryPlayed, int lastGameScore, int userId){
        ContentValues statValues = new ContentValues();
        statValues.put("PLAYED_GAMES", playedGames);
        statValues.put("COMPLETED_GAMES", completedGames);
        statValues.put("SCORE", score);
        statValues.put("AVERAGE_SCORE", averageScore);
        statValues.put("LAST_CATEGORY_PLAYED", lastCategoryPlayed);
        statValues.put("LAST_GAME_SCORE", lastGameScore);
        statValues.put("USER_ID", userId);
        db.insert("STAT", null, statValues);
    }




}
