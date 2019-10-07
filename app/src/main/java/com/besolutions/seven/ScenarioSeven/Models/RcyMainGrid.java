package com.besolutions.seven.ScenarioSeven.Models;

public class RcyMainGrid {

    String textsuggest;
    String textsuggest1;
    int poster1;


    public RcyMainGrid(String textsuggest, String textsuggest1, int poster) {
        this.textsuggest = textsuggest;
        this.textsuggest1 = textsuggest1;
        this.poster1 = poster;
    }

    public String getTextsuggest() {
        return textsuggest;
    }

    public void setTextsuggest(String textsuggest) {
        this.textsuggest = textsuggest;
    }

    public String getTextsuggest1() {
        return textsuggest1;
    }

    public void setTextsuggest1(String textsuggest1) {
        this.textsuggest1 = textsuggest1;
    }

    public int getPoster1() {
        return poster1;
    }

    public void setPoster1(int poster1) {
        this.poster1 = poster1;
    }
}
