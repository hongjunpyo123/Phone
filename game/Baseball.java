package com.project.phone.game;

import com.project.phone.database.Connecting;
import com.project.phone.util.Tools;

import java.util.Random;
import java.util.Scanner;

public class Baseball {
    private int rdNum[] = new int[4];
    private int numArr[] = new int[4];
    private int strike = 0;
    private int ball = 0;
    private int out = 0;
    private String choose;
    private Scanner in = new Scanner(System.in);
    private Connecting connecting = Connecting.getInstance(); //db연결 객체 생성
    private static Baseball baseball;
    private Random r = new Random();
    private static Coin coin = Coin.getInstance();



    private Baseball() {

    }


    public static Baseball getInstance() {
        if (baseball == null) {
            return baseball = new Baseball();
        }
        return baseball;
    }


    public int gameBaseball() {
        Tools.set_uniqueRandArray(4);
        rdNum = Tools.get_uniqueRandArray();

        Tools.clear(); //화면 초기화
        Tools.flush(in); //입력버퍼 초기화
        in = new Scanner(System.in);

        System.out.println("****************룰설명****************");
        System.out.println("4자리의 숫자와 위치를 맞추는 게임입니다.");
        System.out.println("숫자와 위치가 맞을경우 스트라이크");
        System.out.println("숫자만 맞고 위치는 틀릴경우 볼");
        System.out.println("숫자와 위치 전부 틀릴시 아웃입니다.");
        System.out.println("한번의 정답입력시마다 15코인이 차감됩니다.");
        System.out.println("정답을 맞출경우 200코인이 지급됩니다.");
        System.out.println("************************************\n");
        System.out.print("게임을 시작하시려면 [0]번을 입력하세요:");
        choose = this.in.next();
        Tools.flush();
        if(coin.getCoin() < 10){
            System.out.println("\n코인이 부족합니다.");
            Tools.pause(1);
            return 0;
        }
        if(choose.equals("0")) {
            while (true) {
                try {
                    String input = null; //사용자 입력값 저장
                    int intput = 0;


                    while (true) {
                        strike = 0;
                        ball = 0;
                        out = 0;
                        System.out.print("숫자네자리를 입력하시오:");
                        coin.subCoin(10);
                        intput = this.in.nextInt();

                        if (Tools.intLength(intput) < 4 || Tools.intLength(intput) > 4) {
                            System.out.println("!!숫자4자리를 입력하세요!!");
                            Tools.pause(2);
                            Tools.clear();
                            continue;
                        }
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
                                    System.out.println("!!같은숫자 입력은 안됩니다.!!");
                                    Tools.pause(2);
                                    break outer;
                                }
                            }

                        }

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
                        if (strike == 4) {
                            System.out.println("정답입니다.[ 200코인 지급됨 ]");
                            coin.addCoin(200);
                            break;

                        }
                        Tools.clear(); //화면 초기화
                        Tools.flush(); //입력버퍼 초기화


                        System.out.printf("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓\n");
                        System.out.printf("┃┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓      ┃\n");
                        System.out.printf("┃┃                            [  Baseballgame  ]      game coin : %d", coin.getCoin());
                        for (int i = 0; i < 7 - Tools.intLength(coin.getCoin()); i++) {
                            System.out.printf(" ");
                        }
                        System.out.printf("┃      ┃\n");
                        System.out.printf("┃┃                                                                       ┃      ┃\n");
                        System.out.printf("┃┃                                                                       ┃      ┃\n");
                        System.out.printf("┃┃                                                                       ┃      ┃\n");
                        System.out.printf("┃┃                                                                       ┃      ┃\n");
                        System.out.printf("┃┃                                                                       ┃┏━━━━┓┃\n");
                        System.out.printf("┃┃                                                                       ┃┃home┃┃\n");
                        System.out.printf("┃┃              last nunmber     [%d][%d][%d][%d]                            ┃┗━━━━┛┃\n", numArr[0], numArr[1], numArr[2], numArr[3]);
                        System.out.printf("┃┃                                                                       ┃      ┃\n");
                        System.out.printf("┃┃        strike : " + strike + "            ball : " + ball + "              out : " + out + "            ┃      ┃\n");
                        System.out.printf("┃┃                                                                       ┃      ┃\n");
                        System.out.printf("┃┃                                                                       ┃      ┃\n");
                        System.out.printf("┃┃                                                                       ┃      ┃\n");
                        System.out.printf("┃┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛      ┃\n");
                        System.out.printf("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛\n");
                    }

                }catch (Exception e){
                    System.out.println("메인화면으로 돌아갑니다.");
                    Tools.pause(2);
                    return 0;
                }

            }
        }else{
            System.out.println("잘못된입력입니다 다시 입력하세요");
            Tools.pause(2);
            return 0;
        }
    }
}

