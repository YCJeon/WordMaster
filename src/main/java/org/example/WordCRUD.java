package org.example;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class WordCRUD implements ICRUD {
    ArrayList<Word> list;
    WordCRUD(){
        list = new ArrayList<>();
    }
    Scanner sc = new Scanner(System.in);
    @Override
    public void add() {
        System.out.print("\n=>난이도(1,2,3) & 새 단어 입력 : ");
        int level = sc.nextInt();
        String word = sc.nextLine();
        System.out.print("뜻 입력 : ");
        String meaning = sc.nextLine();

        Word one = new Word(level, word, meaning);
        list.add(one);
    }

    @Override
    public int update() {
        return 0;
    }

    @Override
    public int delete() {
        return 0;
    }

    @Override
    public void select(Object o) {

    }
    public  void printAll(){

        for(int i=0; i<list.size(); i++){
            System.out.println((i+1 + " "+list.get(i).toString()));
        }
    }
}
