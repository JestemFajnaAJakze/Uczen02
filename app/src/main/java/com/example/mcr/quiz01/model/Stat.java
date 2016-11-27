package com.example.mcr.quiz01.model;

/**
 * Created by MCR on 09.09.2016.
 */
public class Stat {
    private int playedGames;
    private int completedGames;
    private int score;
    private int averageScore;
    private String lastCategoryPlayed;
    private int lastGameScore;

    public int getPlayedGames() {
        return playedGames;
    }

    public void setPlayedGames(int playedGames) {
        this.playedGames = playedGames;
    }

    public int getCompletedGames() {
        return completedGames;
    }

    public void setCompletedGames(int completedGames) {
        this.completedGames = completedGames;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getAverageScore() {
        return averageScore;
    }

    public void setAverageScore(int averageScore) {
        this.averageScore = averageScore;
    }

    public String getLastCategoryPlayed() {
        return lastCategoryPlayed;
    }

    public void setLastCategoryPlayed(String lastCategoryPlayed) {
        this.lastCategoryPlayed = lastCategoryPlayed;
    }

    public int getLastGameScore() {
        return lastGameScore;
    }

    public void setLastGameScore(int lastGameScore) {
        this.lastGameScore = lastGameScore;
    }
}
