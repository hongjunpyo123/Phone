package com.project.phone.game;

import com.project.phone.database.Connecting;
import com.project.phone.util.Tools;

import java.util.Scanner;

public class Cash {

    Scanner in = new Scanner(System.in);
    Connecting connecting = Connecting.getInstance(); //db연결 객체 생성
    private static Cash cash;

    private Cash() {
    }

    public static Cash getInstance() {
        if (cash == null) {
            return cash = new Cash();
        }
        return cash;
    }


    public int gameCash() {

        Tools.clear(); //화면 초기화
        Tools.flush(); //입력버퍼 초기화
        String input = null; //사용자 입력값 저장
        int intput;
        int bash = 1000;


        System.out.printf("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓\n");
        System.out.printf("┃┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓      ┃\n");
        System.out.printf("┃┃                               [  Cash  ]                     ┃      ┃\n");
        System.out.printf("┃┃                                                                       ┃      ┃\n");
        System.out.printf("┃┃                                                                       ┃      ┃\n");
        System.out.printf("┃┃                          cash:" + cash + "                                ┃      ┃\n");
        System.out.printf("┃┃                          bank:" + cash + "                             ┃      ┃\n");
        System.out.printf("┃┃                                                                       ┃┏━━━━┓┃\n");
        System.out.printf("┃┃                                                                       ┃┃home┃┃\n");
        System.out.printf("┃┃                                                                       ┃┗━━━━┛┃\n");
        System.out.printf("┃┃             [1]                     [2]                  [3]          ┃      ┃\n");
        System.out.printf("┃┃         캐시 구매하기               돈 환전하기         메인메뉴돌아가기     ┃      ┃\n");
        System.out.printf("┃┃                                                                       ┃      ┃\n");
        System.out.printf("┃┃                                                                       ┃      ┃\n");
        System.out.printf("┃┃                                                                       ┃      ┃\n");
        System.out.printf("┃┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛      ┃\n");
        System.out.printf("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛\n");
        System.out.println(".");
        input = this.in.next();
        if (input.equals("home")) {
            Tools.pause(2);
            return 0;
        } else if (input.equals("캐시 구매하기") || input.equals("1")) {
            System.out.println("현 통장 잔고는" + bash + "입니다");
            System.out.println("1000원에 100캐시 입니다. 캐시를 얼마나 구입하시겠습니까?");
            intput = this.in.nextInt();
            System.out.println(bash + "캐시는" + bash + "원 입니다. 구매하시겠습니까?");
            System.out.println("Yes/No");
            input = this.in.next();
            if (input == "Yes") {
                System.out.println("구매완료되었습니다");
                System.out.println("남은 계좌 잔액:" + bash + "/ 현 캐시:" + bash);
                return 0;

            }
        }


        return 0;
    }
}





