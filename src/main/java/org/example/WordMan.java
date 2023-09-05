package org.example;
import java.util.Scanner;

public class WordMan {
    Scanner s = new Scanner(System.in);

    WordCRUD wordCRUD;
    WordMan(){
        wordCRUD = new WordCRUD();
    }

    public void select_menu(){
        int menu;
        while (true){
            System.out.println("*** 영단어 마스터 ***\n"
                    + "**********************\n"
                    + "1. 모든 단어 보기\n"
                    + "2. 수준별 단어 보기\n"
                    + "3. 단어 검색\n"
                    + "4. 단어 추가\n"
                    + "5. 단어 수정\n"
                    + "6. 단어 삭제\n"
                    + "7. 파일 저장\n"
                    + "0. 나가기\n"
                    + "**********************\n"
                    + "=> 원하는 메뉴는? ");
            menu = s.nextInt();
            if(menu == 1){ //모든 단어 보기

            } else if (menu == 2) { //수준별 단어 보기

            } else if (menu == 3) { //단어 검색

            } else if (menu == 4) { //단어 추가
                new WordCRUD().add();
                System.out.println("새 단어가 단어장에 추가되었습니다!!!\n");
            } else if (menu == 5) { //단어 수정

            } else if (menu == 6) { //단어 삭제

            } else if (menu ==7) { //파일 저장

            } else if (menu == 0) { //나가기
                System.out.println("프로그램 종료! 다음에 만나요~");
                break;
            }else{
                System.out.println("메뉴 중에 선택해 주세요.");
            }

        }

    }
}
