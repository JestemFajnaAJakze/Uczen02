package com.example.mcr.quiz01.model;

/**
 * Created by MCR on 09.09.2016.
 */
public class Answer {
    private String name;

    private int isCorrect;


    public Answer(String name) {
        this.name = name;
    }

    public int getIsCorrect() {
        return isCorrect;
    }

    public void setIsCorrect(int isCorrect) {
        this.isCorrect = isCorrect;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
