package com.zjt.pojo;

public class Total {
    private int score;

    private int titles;

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getTitles() {
        return titles;
    }

    public void setTitles(int titles) {
        this.titles = titles;
    }

    @Override
    public String toString() {
        return "Total{" +
                "score=" + score +
                ", titles=" + titles +
                '}';
    }
}
