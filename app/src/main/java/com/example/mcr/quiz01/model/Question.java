package com.example.mcr.quiz01.model;

import java.util.ArrayList;

/**
 * Created by MCR on 09.09.2016.
 */
public class Question {

    private String name;

    private ArrayList<Answer> answerList;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Answer> getAnswerList() {
        return answerList;
    }

    public void setAnswerList(ArrayList<Answer> answerList) {
        this.answerList = answerList;
    }



}
