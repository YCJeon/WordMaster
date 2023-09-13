package org.example;

import java.io.*;
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
    public void update(){
        System.out.print("수정할 단어 검색: ");
        String keyword = sc.nextLine();
        ArrayList<Integer> idlist = this.search(keyword);
        System.out.print("=>수정할 번호 선택: ");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.print("=>뜻 입력: ");
        String meaning = sc.nextLine();
        list.get(idlist.get(id-1)).setMeaning(meaning);

    }

    @Override
    public void delete() {
        System.out.print("삭제할 단어 검색: ");
        String keyword = sc.nextLine();
        ArrayList<Integer> idlist = this.search(keyword);
        System.out.print("=>삭제할 번호 선택: ");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.print("=>정말로 삭제하실래요?(Y/N): ");
        String meaning = sc.nextLine();
        list.remove(idlist.get(id-1));
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
    public void searchId(int level){
        int j=1;
        for(int i=0; i<list.size(); i++){
            if(list.get(i).getLevel()==level){
                System.out.println(j+list.get(i).toString());
                j++;
            }
        }
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
        try {
            PrintWriter pw = new PrintWriter(new FileWriter("word.txt"));
            for(Word word:list){
                pw.write(word.toFileString()+"\n");
            }
            pw.close();
            System.out.println("모든 단어 파일 저장 완료 !!!");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}