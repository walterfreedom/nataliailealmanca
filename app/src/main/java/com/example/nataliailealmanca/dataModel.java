package com.example.nataliailealmanca;

public class dataModel {
    String german="";
    String turkish ="";
    String sentences="";
    int index;

    public dataModel(String german, String turkish,String sentences,int index ){
        this.german = german;
        this.turkish = turkish;
        this.sentences = sentences;
        this.index=index;
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

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }
}
