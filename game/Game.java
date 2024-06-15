package com.project.phone.game;

import com.project.phone.bank.Bank;
import com.project.phone.database.Connecting;
import com.project.phone.main.Phone;
import com.project.phone.util.Tools;

import java.util.Scanner;

public class Game {
    Scanner in = new Scanner(System.in);
    private static Game game;
    private Connecting connecting = Connecting.getInstance(); //db연결 객체 생성
    private Yabawe yabawe = Yabawe.getInstance();
    private Updown updown = Updown.getInstance();
    private Baseball baseball = Baseball.getInstance();
    private Coin coin = Coin.getInstance();
    private Bank bank = Bank.getInstance();

    private String input = null; //사용자 입력값 저장

    private Game() {}



    public int phoneGame(){
        while(true) {

            Tools.clear(); //화면 초기화
            Tools.flush(); //입력버퍼 초기화
            input = null;


            System.out.printf("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓\n");
            System.out.printf("┃┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓      ┃\n");
            System.out.printf("┃┃                               [  Game  ]           game coin : %d", coin.getCoin());
            for (int i = 0; i < 7 - Tools.intLength(coin.getCoin()); i++) {
                System.out.printf(" ");
            }
            System.out.printf("┃      ┃\n");
            System.out.printf("┃┃                                                                       ┃      ┃\n");
            System.out.printf("┃┃                                                                       ┃      ┃\n");
            System.out.printf("┃┃                                                                       ┃      ┃\n");
            System.out.printf("┃┃        ┏━━━━━━━━━━━┓         ┏━━━━━━━━━━━┓         ┏━━━━━━━━━━━┓      ┃      ┃\n");
            System.out.printf("┃┃        ┃    [1]    ┃         ┃    [2]    ┃         ┃    [3]    ┃      ┃┏━━━━┓┃\n");
            System.out.printf("┃┃        ┃  Baseball ┃         ┃   Updown  ┃         ┃   Yabawe  ┃      ┃┃home┃┃\n");
            System.out.printf("┃┃        ┗━━━━━━━━━━━┛         ┗━━━━━━━━━━━┛         ┗━━━━━━━━━━━┛      ┃┗━━━━┛┃\n");
            System.out.printf("┃┃                                                                       ┃      ┃\n");
            System.out.printf("┃┃                                                                       ┃      ┃\n");
            System.out.printf("┃┃                                                                       ┃      ┃\n");
            System.out.printf("┃┣━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┫      ┃\n");
            System.out.printf("┃┃ [0] : Coin-Shop                                                       ┃      ┃\n");
            System.out.printf("┃┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛      ┃\n");
            System.out.printf("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛\n");
            System.out.print("=>:");
            input = this.in.next();

            if(!Phone.signal){
                System.out.println("연결 상태를 확인해주세요.");
                Tools.pause(1);
                return 0;
            }

            if(!bank.checkAccount()){
                System.out.print("보유중인 계좌가 없습니다.\n [bank] 에서 계좌를 만드세요. \n");
                Tools.pause(2);
                return 0;
            }


            if (input.equals("home")) {
                return 0;
            } else if (input.equals("Baseball") || input.equals("1")) {
                baseball.gameBaseball();
            } else if (input.equals("Updown") || input.equals("2")) {
                updown.gameUpdown();
            } else if (input.equals("Yabawe") || input.equals("3")) {
                yabawe.gameYabawe();
            } else if (input.equals("0")) {
                coin.gameCoin();
            } else {
                System.out.println("정상적인 값이 아닙니다. \n([0] or [1] or [2] or [3] or [home]) ");
                Tools.pause(1);
            }
        }
    }

    public static Game getInstance(){
        if(Game.game == null){
            return game = new Game();
        }
        return game;
    }
}

