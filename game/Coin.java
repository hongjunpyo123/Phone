package com.project.phone.game;

import com.project.phone.bank.Money;
import com.project.phone.database.Connecting;
import com.project.phone.util.Tools;

import java.util.Scanner;

public class Coin {

    Scanner in = new Scanner(System.in);
    Connecting connecting = Connecting.getInstance(); //db연결 객체 생성
    private static Coin coin;
    private int gameCoin;

    private String input = null; //사용자 입력값 저장
    private int intput = 0; //사용자 입력값 정수형
    private Coin(){
        this.gameCoin = 0;
    }

    public int gameCoin() {

        Tools.clear(); //화면 초기화
        Tools.flush(); //입력버퍼 초기화

        System.out.printf("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓\n");
        System.out.printf("┃┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓      ┃\n");
        System.out.printf("┃┃                             [  GameCoin  ]                            ┃      ┃\n");
        System.out.printf("┃┃                                                                       ┃      ┃\n");
        System.out.printf("┃┃                                                                       ┃      ┃\n");
        System.out.printf("┃┃                  my game coin : %d(coin)", this.gameCoin);
        for (int i = 0; i < 32 - Tools.intLength(this.gameCoin); i++) {
            System.out.printf(" ");
        }
        System.out.printf("┃      ┃\n");

        System.out.printf("┃┃                  my cash : %,d(won)", Money.getCash());
        for (int i = 0; i < 37 - Tools.intLength(Money.getCash()); i++) {
            System.out.printf(" ");
        }
        if(Tools.intLength(Money.getCash()) <= 3){
            System.out.printf(" ");
        }
        System.out.printf("┃      ┃\n");
        System.out.printf("┃┃                                                                       ┃┏━━━━┓┃\n");
        System.out.printf("┃┃                                                                       ┃┃home┃┃\n");
        System.out.printf("┃┃                                                                       ┃┗━━━━┛┃\n");
        System.out.printf("┃┃             [1]                   [2]                    [3]          ┃      ┃\n");
        System.out.printf("┃┃         코인 구매하기            돈 환전하기            메인메뉴돌아가기     ┃      ┃\n");
        System.out.printf("┃┃                                                                       ┃      ┃\n");
        System.out.printf("┃┃                                                                       ┃      ┃\n");
        System.out.printf("┃┃                                                                       ┃      ┃\n");
        System.out.printf("┃┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛      ┃\n");
        System.out.printf("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛\n");
        System.out.print("=>:");
        input = this.in.nextLine();
        if (input.equals("home")) {
            return 0;
        } else if (input.equals("코인 구매하기") || input.equals("1")) {
            System.out.println("현 통장 잔고는" + Money.getCash() + "입니다");
            System.out.println("10원에 코인 1개 입니다. 코인를 몇개 구입하시겠습니까?");
            intput = this.in.nextInt();
            System.out.println("총 : " + intput*10 + " 원 입니다. 구매하시겠습니까?");
            System.out.println("yes/no");
            input = this.in.next();
            if (input.equals("yes")) {
                System.out.println("구매완료되었습니다");
                Tools.pause(1);
                this.gameCoin += intput;
                System.out.println("남은 계좌 잔액:" + Money.getCash() + "/ 코인:" + this.gameCoin);
                Tools.pause(1);
                return 0;
            }
        }


        return 0;
    }

    public int getCoin(){
        return this.gameCoin;
    }

    public void addCoin(int plus){
        this.gameCoin += plus;
    }

    public void subCoin(int minus){
        this.gameCoin -= minus;
    }


    public static Coin getInstance(){
        if(coin == null){
            return coin = new Coin();
        }
        return coin;
    }


}





