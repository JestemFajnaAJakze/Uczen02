package com.example.mcr.quiz01.model;

import java.util.ArrayList;

/**
 * Created by MCR on 13.11.2016.
 */
public class Test {

    private String name;

    private ArrayList<Question> questionList;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Question> getQuestionList() {
        return questionList;
    }

    public void setQuestionList(ArrayList<Question> questionList) {
        this.questionList = questionList;
    }
}
