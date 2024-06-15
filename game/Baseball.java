package com.project.phone.game;

import com.project.phone.bank.Money;
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
    private static Coin coin = Coin.getInstance();
    Scanner in = new Scanner(System.in);
    Connecting connecting = Connecting.getInstance(); //db연결 객체 생성
    private static Baseball baseball;
    Random r = new Random();


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
            int k = 0;
            Money.getCash();

            System.out.printf("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓\n");
            System.out.printf("┃┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓      ┃\n");
            System.out.printf("┃┃                            [  Baseballgame  ]      Coin:%d", coin.getCoin());
            System.out.printf("            ┃      ┃\n");
            System.out.printf("┃┃                                                                       ┃      ┃\n");
            System.out.printf("┃┃                                                                       ┃      ┃\n");
            System.out.printf("┃┃                                                                       ┃      ┃\n");
            System.out.printf("┃┃                                                                       ┃      ┃\n");
            System.out.printf("┃┃                                                                       ┃┏━━━━┓┃\n");
            System.out.printf("┃┃           ┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓            ┃┃home┃┃\n");
            System.out.printf("┃┃           ┃       [%d]       [%d]       [%d]      [%d]       ┃            ┃┗━━━━┛┃\n", numArr[0], numArr[1], numArr[2], numArr[3]);
            System.out.printf("┃┃           ┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛            ┃      ┃\n");
            System.out.printf("┃┃          strike : %d            ball : %d              out : %d          ┃      ┃\n", strike, ball, out);
            System.out.printf("┃┃                                                                       ┃      ┃\n");
            System.out.printf("┃┃                                                                       ┃      ┃\n");
            System.out.printf("┃┃                                                                       ┃      ┃\n");
            System.out.printf("┃┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛      ┃\n");
            System.out.printf("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛\n");
                for(int x=0;x<1;x++) {
                    System.out.println("*****************룰설명*****************");
                    System.out.println("1~9사이의 4개의 숫자를 맞추면 되는게임입니다.");
                    System.out.println("숫자와 위치가 맞을경우 스트라이크");
                    System.out.println("숫자는 맞지만 위치는 다를경우 볼");
                    System.out.println("둘다 맞지 않을 경우는 아웃");
                    System.out.println("4개의 숫자와 답을 맞출경우 승리합니다.");
                    System.out.println("한번의 답을 낼때마다 10코인씩 차감됩니다.");
                    System.out.println("승리할경우 100코인이 지급됩니다.");
                }
            strike = 0;
            ball = 0;
            out = 0;

            while (true) {
                System.out.print("숫자네자리를 입력하시오");
                intput = this.in.nextInt();
                coin.subCoin(10);//10코인씩 차감
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
                //숫자중복방지
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
                    out = 4 - (strike + ball);
                    System.out.print(rdNum[0] + "/");
                    System.out.print(rdNum[1] + "/");
                    System.out.print(rdNum[2] + "/");
                    System.out.print(rdNum[3] + "/");
                    break;


                }
                if (numArr[0] == rdNum[0] && numArr[1] == rdNum[1] && numArr[2] == rdNum[2] && numArr[3] == rdNum[3]) {
                    System.out.printf("정답입니다!");
                    coin.addCoin(100);
                    break;
                }

            }
        }
    }
}