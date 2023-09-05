package org.example;

public class Word {
    private int level;
    private  String word;
    private  String meaning;
    Word(){}
    Word(int level, String word, String meaning){
        this.level = level;
        this.word = word;
        this.meaning = meaning;
    }


    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
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

    public  String toString(){
        String level_star = "";
        for(int i=0; i<level; i++){
            level_star +="*";
        }
        String str = level_star + "  " + word + "  " + meaning;
        return str;
    }
}
