package com.project.phone.game;

import com.project.phone.database.Connecting;
import com.project.phone.util.Tools;

import java.util.Scanner;

public class Game {
    Scanner in = new Scanner(System.in);
    private static Game game;
    Connecting connecting = Connecting.getInstance(); //db연결 객체 생성
    public static Yabawe gameYabawe = Yabawe.getInstance();
    public static Updown gameUpdown = Updown.getInstance();
    public static Baseball gameBaseball = Baseball.getInstance();
    public static Cash gameCash = Cash.getInstance();
    int cash =1000;
    private Game() {}



    public int phoneGame(){

        Tools.clear(); //화면 초기화
        Tools.flush(); //입력버퍼 초기화
        String input = null; //사용자 입력값 저장


        System.out.printf("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓\n");
        System.out.printf("┃┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓      ┃\n");
        System.out.printf("┃┃                               [  Game  ]             cash:"+cash+"        ┃      ┃\n");
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
        System.out.printf("┃┃                        [0]캐시 구매하기                                 ┃      ┃\n");
        System.out.printf("┃┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛      ┃\n");
        System.out.printf("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛\n");
        System.out.println("게임을 선택하세요.");
        input = this.in.next();
        if(input.equals("home")){
            Tools.pause(2);
            return 0;
        }
        else if(input.equals("Baseball")||input.equals("1")){
            gameBaseball.gameBaseball();
        }
        else if(input.equals("Updown")||input.equals("2")){
            gameUpdown.gameUpdown();
        }
        else if(input.equals("Yabawe")||input.equals("3")){
            gameYabawe.gameYabawe();
        }
        else if(input.equals("캐시 구매하기")||input.equals("0")){
            gameCash.gameCash();
        }
        else{
            System.out.println("정상적인 값이 아닙니다. \n([1] or [2] or [3] or [home]) ");
            Tools.pause(3);
        }

        return 0;
    }

    public static Game getInstance(){
        if(Game.game == null){
            return game = new Game();
        }
        return game;
    }
}

