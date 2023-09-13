package org.example;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
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
        System.out.print("=>난이도(1,2,3) & 새 단어 입력 : ");
        int level = sc.nextInt();
        String word = sc.nextLine();
        System.out.print("뜻 입력 : ");
        String meaning = sc.nextLine();

        Word one = new Word(level, word, meaning);
        list.add(one);
    }

    @Override
    public int update(){
        System.out.print("수정할 단어 검색: ");
        String keyword = sc.nextLine();
        ArrayList<Integer> idlist = this.search(keyword);
        System.out.print("=>수정할 번호 선택: ");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.print("=>뜻 입력: ");
        String meaning = sc.nextLine();
        list.get(idlist.get(id-1)).setMeaning(meaning);

        return 0;
    }

    @Override
    public int delete() {
        return 0;
    }

    @Override
    public void select(Object o) {

    }
    public ArrayList<Integer> search(String keyword){
        int j=1;
        ArrayList<Integer> idlist = new ArrayList<>();
        for(int i=0; i<list.size(); i++){
            if(list.get(i).getWord().contains(keyword)){
                idlist.add(i);
                System.out.println(j+list.get(i).toString());
                j++;
            }
        }

        return idlist;
    }
    public  void printAll(){
        if(list.size()==0){
            System.out.println("단어장에 단어가 없습니다.");
        }
        else{
            System.out.println("---------------------------------------");
            for(int i=0; i<list.size(); i++){
                System.out.println((i+1 + " "+list.get(i).toString()));
            }
            System.out.println("---------------------------------------");
        }
    }

    public int LoadFile() {
        int num = 0;
        try {
            BufferedReader br = new BufferedReader(new FileReader("word.txt"));
            String line = br.readLine();
            while (line != null) {
                String data[] = line.split("\\|");

                int level = Integer.parseInt(data[0]);
                String word = data[1];
                String meaning = data[2];

                list.add(new Word(level, word, meaning));
                line = br.readLine();
                num++;
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return num;
    }
    public void SaveFile(){

    }
}