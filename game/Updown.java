package com.project.phone.game;

import com.project.phone.database.Connecting;
import com.project.phone.util.Tools;

import java.util.Random;
import java.util.Scanner;

public class Updown {
    Scanner in = new Scanner(System.in);
    Connecting connecting = Connecting.getInstance(); //db연결 객체 생성
    private static Updown updown;
    Random r = new Random();
    int cash = 1000;
    private static Coin coin = Coin.getInstance();

    private Updown() {
    }

    public static Updown getInstance() {
        if (updown == null) {
            return updown = new Updown();
        }
        return updown;
    }


    public void gameUpdown() {

        Tools.clear(); //화면 초기화
        Tools.flush(); //입력버퍼 초기화
        String input = null; //사용자 입력값 저장


        System.out.printf("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓\n");
        System.out.printf("┃┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓      ┃\n");
        System.out.printf("┃┃                            [  UpdownGame  ]          cash:" + cash + "        ┃      ┃\n");
        System.out.printf("┃┃                                                                       ┃      ┃\n");
        System.out.printf("┃┃                                                                       ┃      ┃\n");
        System.out.printf("┃┃                                                                       ┃      ┃\n");
        System.out.printf("┃┃                                                                       ┃      ┃\n");
        System.out.printf("┃┃                                                                       ┃┏━━━━┓┃\n");
        System.out.printf("┃┃                                                                       ┃┃home┃┃\n");
        System.out.printf("┃┃                                                                       ┃┗━━━━┛┃\n");
        System.out.printf("┃┃         1.게임시작               2.돈 확인               3.게임종료       ┃      ┃\n");
        System.out.printf("┃┃                                                                       ┃      ┃\n");
        System.out.printf("┃┃                                                                       ┃      ┃\n");
        System.out.printf("┃┃                                                                       ┃      ┃\n");
        System.out.printf("┃┃                                                                       ┃      ┃\n");
        System.out.printf("┃┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛      ┃\n");
        System.out.printf("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛\n");
        System.out.println("선택하시오.");
        int check = in.nextInt();
        switch (check) {
            case 1:
                System.out.printf("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓\n");
                System.out.printf("┃┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓      ┃\n");
                System.out.printf("┃┃                            [   룰설명   ]          cash:" + cash + "           ┃      ┃\n");
                System.out.printf("┃┃                                                                       ┃      ┃\n");
                System.out.printf("┃┃                              업다운게임!                                ┃      ┃\n");
                System.out.printf("┃┃                    1부터 30사이의 숫자를 맞추면됩니다!                     ┃      ┃\n");
                System.out.printf("┃┃                        5번안에 맞출시 +1000캐시!                         ┃      ┃\n");
                System.out.printf("┃┃                       6-8번안에 맞출시 +500캐시!                         ┃┏━━━━┓┃\n");
                System.out.printf("┃┃                       8번안에도 못맞추면 -1000캐시!                       ┃┃home┃┃\n");
                System.out.printf("┃┃                        1번에 맞춘다면 +5000캐시!!!                       ┃┗━━━━┛┃\n");
                System.out.printf("┃┃                             행운을 빕니다!                              ┃      ┃\n");
                System.out.printf("┃┃                                                                       ┃      ┃\n");
                System.out.printf("┃┃                                                                       ┃      ┃\n");
                System.out.printf("┃┃                                                                       ┃      ┃\n");
                System.out.printf("┃┃                                                                       ┃      ┃\n");
                System.out.printf("┃┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛      ┃\n");
                System.out.printf("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛\n");
                String rg;
                do {
                    int rd = r.nextInt(30) + 1;
                    int attempts = 0;
                    boolean correct = false;

                    while (attempts < 8) {
                        System.out.println("숫자를 입력하세요:");
                        int num = in.nextInt();
                        attempts++;

                        if (num > rd) {
                            Tools.clear();
                            System.out.printf("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓\n");
                            System.out.printf("┃┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓      ┃\n");
                            System.out.printf("┃┃                                                                       ┃      ┃\n");
                            System.out.printf("┃┃                                                                       ┃      ┃\n");
                            System.out.printf("┃┃                                                                       ┃      ┃\n");
                            System.out.printf("┃┃             ######      ###    ###  ##  ###  ##    ##    ##           ┃      ┃\n");
                            System.out.printf("┃┃              ##   #    #   #    ##  ##  ##    ##   #     ##           ┃      ┃\n");
                            System.out.printf("┃┃              ##   ##  ##   ##   ## # # ##     ###  #     ##           ┃┏━━━━┓┃\n");
                            System.out.printf("┃┃              ##   ##  ##   ##   ## # # ##     #### #     ##           ┃┃home┃┃\n");
                            System.out.printf("┃┃              ##   ##  ##   ##    ### ###      # ####     ##           ┃┗━━━━┛┃\n");
                            System.out.printf("┃┃              ##   #    #   #     ##   ##      #  ###                  ┃      ┃\n");
                            System.out.printf("┃┃             ######      ###      #     #     ##    ##    ##           ┃      ┃\n");
                            System.out.printf("┃┃                                                                       ┃      ┃\n");
                            System.out.printf("┃┃                                                                       ┃      ┃\n");
                            System.out.printf("┃┃                                                                       ┃      ┃\n");
                            System.out.printf("┃┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛      ┃\n");
                            System.out.printf("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛\n");
                            ;
                        } else if (num < rd) {
                            Tools.clear();
                            System.out.printf("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓\n");
                            System.out.printf("┃┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓      ┃\n");
                            System.out.printf("┃┃                                                                       ┃      ┃\n");
                            System.out.printf("┃┃                                                                       ┃      ┃\n");
                            System.out.printf("┃┃                                                                       ┃      ┃\n");
                            System.out.printf("┃┃                     ####  ###    ######     ##                        ┃      ┃\n");
                            System.out.printf("┃┃                      ##   ##     ##   ##    ##                        ┃      ┃\n");
                            System.out.printf("┃┃                      ##   ##     ##   ##    ##                        ┃┏━━━━┓┃\n");
                            System.out.printf("┃┃                      ##   ##     #####      ##                        ┃┃home┃┃\n");
                            System.out.printf("┃┃                      ##   ##     ##         ##                        ┃┗━━━━┛┃\n");
                            System.out.printf("┃┃                      ##   ##     ##                                   ┃      ┃\n");
                            System.out.printf("┃┃                       #####     ####        ##                        ┃      ┃\n");
                            System.out.printf("┃┃                                                                       ┃      ┃\n");
                            System.out.printf("┃┃                                                                       ┃      ┃\n");
                            System.out.printf("┃┃                                                                       ┃      ┃\n");
                            System.out.printf("┃┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛      ┃\n");
                            System.out.printf("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛\n");
                        } else {
                            System.out.println("정답!!");
                            if (attempts == 1) {
                                cash += 5000;
                            } else if (attempts <= 5) {
                                cash += 1000;
                            } else if (attempts <= 8) {
                                cash += 500;
                            }
                            correct = true;
                            break;
                        }
                    }

                    if (!correct) {
                        System.out.println("정답은" + rd + "입니다!");
                        System.out.println("8번 안에 맞추지 못했습니다. -1000캐시!");
                        cash -= 1000;
                    }

                    System.out.println("현잔액: " + cash + " 캐시");
                    System.out.println("다시 하시겠습니까? Yes or No");
                    rg = in.next();
                } while (rg.equalsIgnoreCase("Yes"));
                break;

        }
    }
}





