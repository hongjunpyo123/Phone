package com.project.phone.game;

import com.project.phone.database.Connecting;
import com.project.phone.util.Tools;

import java.util.Random;
import java.util.Scanner;

public class Baseball {
    int rdNum[] = new int[4];
    int numArr[] = new int[4];
    int strike = 0;
    int ball = 0;
    int out = 0;
    Scanner in = new Scanner(System.in);
    Connecting connecting = Connecting.getInstance(); //db연결 객체 생성
    private static Baseball baseball;
    Random r = new Random();
    int cash = 1000;


    private Baseball() {

    }


    public static Baseball getInstance() {
        if (baseball == null) {
            return baseball = new Baseball();
        }
        return baseball;
    }


    public void gameBaseball() {

        for (int i = 0; i < rdNum.length; i++) {
            rdNum[i] = r.nextInt(9) + 1;
            for (int j = 0; j < i; j++) {
                if (rdNum[i] == rdNum[j]) {
                    break;
                }
            }
        }
        while (true) {

            Tools.clear(); //화면 초기화
            Tools.flush(); //입력버퍼 초기화
            String input = null; //사용자 입력값 저장
            int intput = 0;


            System.out.printf("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓\n");
            System.out.printf("┃┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓      ┃\n");
            System.out.printf("┃┃                            [  Baseballgame  ]      cash:" + cash + "          ┃      ┃\n");
            System.out.printf("┃┃                                                                       ┃      ┃\n");
            System.out.printf("┃┃                                                                       ┃      ┃\n");
            System.out.printf("┃┃                                                                       ┃      ┃\n");
            System.out.printf("┃┃                                                                       ┃      ┃\n");
            System.out.printf("┃┃                                                                       ┃┏━━━━┓┃\n");
            System.out.printf("┃┃                                                                       ┃┃home┃┃\n");
            System.out.printf("┃┃              last nunmber                                                         ┃┗━━━━┛┃\n");
            System.out.printf("┃┃                                                                       ┃      ┃\n");
            System.out.printf("┃┃        strike : " + strike + "            ball : " + ball + "              out : " + out + "            ┃      ┃\n");
            System.out.printf("┃┃                                                                       ┃      ┃\n");
            System.out.printf("┃┃                                                                       ┃      ┃\n");
            System.out.printf("┃┃                                                                       ┃      ┃\n");
            System.out.printf("┃┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛      ┃\n");
            System.out.printf("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛\n");
            strike = 0;
            ball = 0;
            out = 0;
            while (true) {
                System.out.print("숫자네자리를 입력하시오");
                intput = this.in.nextInt();
                for (int i = 0; i < numArr.length; i++) {
                    if (i == 0) {
                        numArr[i] = (int) (intput / 1000);
                    } else if (i == 1) {
                        numArr[i] = (int) ((intput - numArr[0] * 1000) / 100);
                    } else if (i == 2) {
                        numArr[i] = (int) ((intput - numArr[0] * 1000 - numArr[1] * 100) / 10);
                    } else if (i == 3) {
                        numArr[i] = (int) ((intput - numArr[0] * 1000 - numArr[1] * 100 - numArr[2] * 10));
                    }
                }

                outer:
                for (int i = 0; i < numArr.length; i++) {
                    for (int j = 0; j < numArr.length; j++) {
                        if (i == j) {
                            if (j != 3) {
                                j++;
                            }
                            break;
                        }
                        if (numArr[i] == numArr[j]) {
                            System.out.println("같은숫자 입력은 안됩니다.");
                            break outer;
                        }
                    }

                }
                System.out.print("컴퓨터 : ");
                for (int i = 0; i < rdNum.length; i++) {
                    System.out.print(rdNum[i] + "/");
                }
                System.out.print("\n");
                for (int i = 0; i < numArr.length; i++) {
                    for (int j = 0; j < numArr.length; j++) {
                        if (rdNum[i] == numArr[j] && i == j) {//값위치만 같을때
                            strike += 1;
                        } else if (rdNum[i] == numArr[j] && i != j) {
                            ball += 1;
                        }
                    }

                }
                out = 4 - (strike + ball);
                System.out.print(rdNum[0] + "/");
                System.out.print(rdNum[1] + "/");
                System.out.print(rdNum[2] + "/");
                System.out.print(rdNum[3] + "/");
                break;
            }

        }
    }
}



