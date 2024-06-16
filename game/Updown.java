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
    private static Coin coin = Coin.getInstance();
    private String input;
    private int IntegetInput = 0;
    private int attempts = 0;

    private Updown() {
    }

    public static Updown getInstance() {
        if (updown == null) {
            return updown = new Updown();
        }
        return updown;
    }


    public int gameUpdown() {

        Tools.clear(); //화면 초기화
        Tools.flush(); //입력버퍼 초기화

        System.out.println("**********룰설명**********");
        System.out.println("1부터31중 랜덤으로 정한 숫자 하나를 맞추는게임입니다.");
        System.out.println("5번안에 맞출시 100코인");
        System.out.println("10번안에 맞출시 50코인");
        System.out.println("10번안에 못맞출시 -50코인입니다.");
        System.out.println("행운을 빕니다");
        System.out.print("게임을 시작하시려면 [0]번을 입력하세요:");
        input = this.in.next();
        while(true) {
            try {
                Tools.flush();
                Tools.clear();

                Tools.clear(); // 화면 초기화
                Tools.flush(); // 입력버퍼 초기화

                int rd = r.nextInt(30) + 1;

                System.out.printf("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓\n");
                System.out.printf("┃┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓      ┃\n");
                System.out.printf("┃┃                            [  UpdownGame  ]          game coin : %d", coin.getCoin());
                for (int i = 0; i < 5 - Tools.intLength(coin.getCoin()); i++) {
                    System.out.printf(" ");
                }
                System.out.printf("┃      ┃\n");
                System.out.printf("┃┃                                                                       ┃      ┃\n");
                System.out.printf("┃┃                                                                       ┃      ┃\n");
                System.out.printf("┃┃  ####  ###    ######      # ######      ###    ###  ##  ###  ##    ## ┃      ┃\n");
                System.out.printf("┃┃   ##   ##     ##   ##    #   ##   #    #   #    ##  ##  ##    ##   #  ┃      ┃\n");
                System.out.printf("┃┃   ##   ##     ##   ##   #    ##   ##  ##   ##   ## # # ##     ###  #  ┃┏━━━━┓┃\n");
                System.out.printf("┃┃   ##   ##     #####    #     ##   ##  ##   ##   ## # # ##     #### #  ┃┃home┃┃\n");
                System.out.printf("┃┃   ##   ##     ##      #      ##   ##  ##   ##    ### ###      # ####  ┃┗━━━━┛┃\n");
                System.out.printf("┃┃   ##   ##     ##     #       ##   #    #   #     ##   ##      #  ###  ┃      ┃\n");
                System.out.printf("┃┃    #####     ####   #       ######      ###      #     #     ##    ## ┃      ┃\n");
                System.out.printf("┃┃                                                                       ┃      ┃\n");
                System.out.printf("┃┃                                                                       ┃      ┃\n");
                System.out.printf("┃┃                                                                       ┃      ┃\n");
                System.out.printf("┃┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛      ┃\n");
                System.out.printf("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛\n");
                System.out.print("숫자를 입력하세요:");
                input = in.next();
                if (input.equals("home")) {
                    return 0;
                }

                if (coin.getCoin() < 50) {
                    System.out.println("\n코인이 부족합니다.");
                    Tools.pause(1);
                    return 0;
                }

                while (true) {
                    if (Integer.parseInt(input) > rd) {
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
                        System.out.print("숫자를 입력하세요:");
                        input = in.next();
                        if (input.equals("home")) {
                            return 0;
                        }
                    } else if (Integer.parseInt(input) < rd) {
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
                        System.out.print("숫자를 입력하세요:");
                        input = in.next();
                        if (input.equals("home")) {
                            return 0;
                        }
                    }
                    attempts++;

                    if (attempts >= 8 && Integer.parseInt(input) != rd) {
                        System.out.println("정답은" + rd + "입니다!");
                        System.out.println("8번 안에 맞추지 못했습니다. -50코인!");
                        coin.subCoin(50);
                        Tools.pause(2);


                        System.out.println("남은코인: " + coin.getCoin() + "코인");
                        System.out.print("다시 하시겠습니까?(yes/no):");
                        input = in.next();
                        if (input.equals("yes")) {
                            break;
                        } else {
                            return 0;
                        }
                    }

                    if (Integer.parseInt(input) == rd) {
                        if (attempts <= 5) {
                            System.out.println("5번안에 맞췄습니다! +100코인");
                            coin.addCoin(100);
                            Tools.pause(2);

                            System.out.println("남은코인: " + coin.getCoin() + "코인");
                            System.out.print("다시 하시겠습니까?(yes/no):");
                            input = in.next();
                            if (input.equals("yes")) {
                                break;
                            } else {
                                return 0;
                            }
                        } else {
                            System.out.println("8번 안에 맞췄습니다. +50코인!");
                            coin.addCoin(50);
                            Tools.pause(2);

                            System.out.println("남은코인: " + coin.getCoin() + "코인");
                            System.out.print("다시 하시겠습니까?(yes/no):");
                            input = in.next();
                            if (input.equals("yes")) {
                                break;
                            } else {
                                return 0;
                            }
                        }
                    }
                } //두번째 while문
            }catch (Exception e){
                System.out.println("잘못된 값입니다.");
                Tools.pause(1);
                return 0;
            }
        } //첫번쩨 while문
    } //함수
}//클래스

