package com.example.nataliailealmanca;

public class dataModel {
    String german="";
    String turkish ="";
    String sentences="";

    public dataModel(String german, String turkish,String sentences ){
        this.german = german;
        this.turkish = turkish;
        this.sentences = sentences;
    }

    public String getSentences() {
        return sentences;
    }

    public void setSentences(String sentences) {
        this.sentences = sentences;
    }

    public String getGerman() {
        return german;
    }

    public void setGerman(String german) {
        this.german = german;
    }

    public String getTurkish() {
        return turkish;
    }

    public void setTurkish(String turkish) {
        this.turkish = turkish;
    }
}
