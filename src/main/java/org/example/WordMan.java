package org.example;
import java.util.Scanner;

public class WordMan {
    Scanner s = new Scanner(System.in);

    WordCRUD wordCRUD;
    WordMan(){
        wordCRUD = new WordCRUD();
    }

    public void select_menu(){
        System.out.println("=> "+wordCRUD.LoadFile()+"개 데이터 로딩 완료!!!");
        int menu;
        System.out.println("*** 영단어 마스터 ***\n");
        while (true){
            System.out.println("********************\n"
                    + "1. 모든 단어 보기\n"
                    + "2. 수준별 단어 보기\n"
                    + "3. 단어 검색\n"
                    + "4. 단어 추가\n"
                    + "5. 단어 수정\n"
                    + "6. 단어 삭제\n"
                    + "7. 파일 저장\n"
                    + "0. 나가기\n"
                    + "********************\n"
                    + "=> 원하는 메뉴는? ");
            menu = s.nextInt();
            s.nextLine();
            if(menu == 1){ //모든 단어 보기
                wordCRUD.printAll();
            }
            else if (menu == 2) { //수준별 단어 보기
                System.out.println("=> 레벨(1:초급, 2:중급, 3:고급) 선택: ");
                int level = s.nextInt();
                wordCRUD.searchId(level);
            }
            else if (menu == 3) { //단어 검색
                System.out.print("=> 검색할 단어 입력:");
                String keyword = s.nextLine();
                wordCRUD.search(keyword);
            }
            else if (menu == 4) { //단어 추가
                wordCRUD.add();
                System.out.println("새 단어가 단어장에 추가되었습니다!!!\n");
            }
            else if (menu == 5) { //단어 수정
                wordCRUD.update();
                System.out.println("단어 수정이 성공적으로 되었습니다!!");
            }
            else if (menu == 6) { //단어 삭제
                wordCRUD.delete();
                System.out.println("선택한 단어 삭제 완료!!!");

            }
            else if (menu ==7) { //파일 저장
                wordCRUD.SaveFile();
            }
            else if (menu == 0) { //나가기
                break;
            }
            else{
                System.out.println("메뉴 중에 선택해 주세요.");
            }

        }
        System.out.println("프로그램 종료! 다음에 만나요~");
    }
}
