package com.example.ankit.firebasewithlistview;


public class Vocabulary {
    private String word;
    private String meaning;

    public Vocabulary() {
    }

    public Vocabulary(String word, String meaning) {
        this.word = word;
        this.meaning = meaning;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getMeaning() {
        return meaning;
    }

    public void setMeaning(String meaning) {
        this.meaning = meaning;
    }
}
