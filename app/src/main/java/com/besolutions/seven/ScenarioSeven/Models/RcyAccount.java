package com.besolutions.seven.ScenarioSeven.Models;

public class RcyAccount {

    String textadpersonal;
    String textadpersonal1;
    String textadpersonal2;
    String textadpersonal3;
    int poster;

    public RcyAccount(String textadpersonal, String textadpersonal1, String textadpersonal2, String textadpersonal3, int poster) {
        this.textadpersonal = textadpersonal;
        this.textadpersonal1 = textadpersonal1;
        this.textadpersonal2 = textadpersonal2;
        this.textadpersonal3 = textadpersonal3;
        this.poster = poster;
    }


    public String getTextadpersonal() {
        return textadpersonal;
    }

    public void setTextadpersonal(String textadpersonal) {
        this.textadpersonal = textadpersonal;
    }

    public String getTextadpersonal1() {
        return textadpersonal1;
    }

    public void setTextadpersonal1(String textadpersonal1) {
        this.textadpersonal1 = textadpersonal1;
    }

    public String getTextadpersonal2() {
        return textadpersonal2;
    }

    public void setTextadpersonal2(String textadpersonal2) {
        this.textadpersonal2 = textadpersonal2;
    }

    public String getTextadpersonal3() {
        return textadpersonal3;
    }

    public void setTextadpersonal3(String textadpersonal3) {
        this.textadpersonal3 = textadpersonal3;
    }

    public int getPoster() {
        return poster;
    }

    public void setPoster(int poster) {
        this.poster = poster;
    }
}
