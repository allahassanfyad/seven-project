package com.besolutions.seven.ScenarioSeven.Models;

public class RcyMain {

    String textMain;
    String textMain1;
    String textMain2;
    String textMain3;
    int poster;


    public RcyMain(String textMain, String textMain1, String textMain2, String textMain3, int poster) {
        this.textMain = textMain;
        this.textMain1 = textMain1;
        this.textMain2 = textMain2;
        this.textMain3 = textMain3;
        this.poster = poster;
    }

    public String getTextMain() {
        return textMain;
    }

    public void setTextMain(String textMain) {
        this.textMain = textMain;
    }

    public String getTextMain1() {
        return textMain1;
    }

    public void setTextMain1(String textMain1) {
        this.textMain1 = textMain1;
    }

    public String getTextMain2() {
        return textMain2;
    }

    public void setTextMain2(String textMain2) {
        this.textMain2 = textMain2;
    }

    public String getTextMain3() {
        return textMain3;
    }

    public void setTextMain3(String textMain3) {
        this.textMain3 = textMain3;
    }

    public int getPoster() {
        return poster;
    }

    public void setPoster(int poster) {
        this.poster = poster;
    }
}
