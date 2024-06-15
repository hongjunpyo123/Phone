package com.project.phone.game;

import com.project.phone.bank.CreateAccount;
import com.project.phone.bank.Money;
import com.project.phone.database.Connecting;
import com.project.phone.util.Tools;

import java.util.Scanner;

public class Coin {

    Scanner in = new Scanner(System.in);
    Connecting connecting = Connecting.getInstance(); //db연결 객체 생성
    CreateAccount createAccount = CreateAccount.getInstance(connecting);
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
        System.out.printf("┃┃                            [  Coin Shop  ]                            ┃      ┃\n");
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
        System.out.printf("┃┃       ┏━━━━━━━━━━━━━┓          ┏━━━━━━━━━┓           ┏━━━━━━━━━┓      ┃┗━━━━┛┃\n");
        System.out.printf("┃┃       ┃     [1]     ┃          ┃   [2]   ┃           ┃   [3]   ┃      ┃      ┃\n");
        System.out.printf("┃┃         코인 구매하기              환전하기                메인메뉴        ┃      ┃\n");
        System.out.printf("┃┃       ┗━━━━━━━━━━━━━┛          ┗━━━━━━━━━┛           ┗━━━━━━━━━┛      ┃      ┃\n");
        System.out.printf("┃┃                                                                       ┃      ┃\n");
        System.out.printf("┃┃                                                                       ┃      ┃\n");
        System.out.printf("┃┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛      ┃\n");
        System.out.printf("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛\n");
        System.out.print("=>:");
        input = this.in.next();
        if (input.equals("home")) {
            return 0;
        }
        else if (input.equals("코인") || input.equals("1")) {
            System.out.printf("현 통장 잔고는 %,d(won) 입니다.\n", Money.getCash());
            System.out.println("10원에 코인 1개 입니다. 몇개 구입하시겠습니까?");
            System.out.print("=>:");
            intput = this.in.nextInt();
            System.out.print("총" + intput*10 + " 원 입니다. 구매하시겠습니까?(yes/no):");
            input = this.in.next();
            if (input.equals("yes")) {

                if(intput*10 > Money.getCash()){
                    System.out.println("잔액이 부족합니다.");
                    Tools.pause(1);
                    return 0;
                }else{
                    if(!Money.subMoney(createAccount.getAccountNumber(), intput*10, "Coin")){
                        System.out.println("환전에 실패하였습니다.");
                        Tools.pause(1);
                        return 0;
                    }
                    System.out.println("구매완료되었습니다");
                    Tools.pause(1);
                    this.gameCoin += intput;
                    System.out.println("남은 계좌 잔액:" + Money.getCash() + "/ 코인:" + this.gameCoin);
                    Tools.pause(2);
                    return 0;
                }
            }
            else{
                System.out.println("취소합니다.");
                Tools.pause(1);
                return 0;
            }
        }
        else if(input.equals("환전하기") || input.equals("2")){
            System.out.printf("현 보유중인 코인은 %d(coin) 입니다. 몇개 환전하시겠습니까?\n", this.gameCoin);
            System.out.print("=>:");
            intput = this.in.nextInt();
            System.out.printf("환전 코인 : %d(coin)(%,d원)\n", intput, intput*10);
            System.out.printf("환전하시겠습니까?(yes/no):");
            input = this.in.next();

            if(this.gameCoin < intput){
                System.out.println("코인이 부족합니다.");
                Tools.pause(1);
                return 0;
            }

            if(!Money.addMoney(createAccount.getAccountNumber(), intput*10, "Coin")){
                System.out.println("환전에 실패하였습니다.");
                Tools.pause(1);
                return 0;
            }

            this.gameCoin -= intput;
            System.out.println("환전완료되었습니다.");
            Tools.pause(1);
            return 0;
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





