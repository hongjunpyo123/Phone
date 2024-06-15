package com.project.phone.game;

import com.project.phone.database.Connecting;
import com.project.phone.util.Tools;

import java.util.Random;
import java.util.Scanner;

public class Yabawe {
        Scanner in = new Scanner(System.in);
        Connecting connecting = Connecting.getInstance();
        Random r = new Random();
        private static Yabawe yabawe;
        int cash = 1000;
        private static Coin coin = Coin.getInstance();
        private int intput;

        private Yabawe() {
        }

        ;

        public static Yabawe getInstance() {
                if (yabawe == null) {
                        yabawe = new Yabawe();
                        return yabawe;
                }
                return yabawe;
        }
        public void doubleCoin(int twox){this.intput *= twox;}

        public void gameYabawe() {
                Tools.clear();
                Tools.flush();
                String input = null; //사용자 입력값 저장
                System.out.println("****************룰설명**************");
                System.out.println("3개의 컵중 구슬이 든 컵을 맞추면 됩니다.");
                System.out.println("맞춰서 승리할시 걸었던 돈의 두배를 얻게 됩니다.");
                System.out.println("하지만 패배할시 걸었던 모든 돈을 잃게 됩니다.");
                System.out.printf("현 코인은 %d(코인)입니다. 얼마를 거시겠습니까?",coin.getCoin());
                int intput = in.nextInt();//걸은돈
                String yabawe;


                while (true){
                while (true) {
                        System.out.printf("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓\n");
                        System.out.printf("┃┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓      ┃\n");
                        System.out.printf("┃┃                              [ 야바위게임 ]                             ┃      ┃\n");
                        System.out.printf("┃┣━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┫      ┃\n");
                        System.out.printf("┃┃                                                                       ┃      ┃\n");
                        System.out.printf("┃┃                                                                       ┃      ┃\n");
                        System.out.printf("┃┃       ┏━━━━━━━━━┓            ┏━━━━━━━━━┓            ┏━━━━━━━━━┓       ┃      ┃\n");
                        System.out.printf("┃┃       ┃         ┃            ┃         ┃            ┃         ┃       ┃┏━━━━┓┃\n");
                        System.out.printf("┃┃       ┃    1    ┃            ┃    2    ┃            ┃    3    ┃       ┃┃home┃┃\n");
                        System.out.printf("┃┃       ┃         ┃            ┃         ┃            ┃         ┃       ┃┗━━━━┛┃\n");
                        System.out.printf("┃┃       ┃         ┃            ┃         ┃            ┃         ┃       ┃      ┃\n");
                        System.out.printf("┃┃       ┃         ┃            ┃         ┃            ┃         ┃       ┃      ┃\n");
                        System.out.printf("┃┃       ┗━━━━━━━━━┛            ┗━━━━━━━━━┛            ┗━━━━━━━━━┛       ┃      ┃\n");
                        System.out.printf("┃┃                                                                       ┃      ┃\n");
                        System.out.printf("┃┃                                                                       ┃      ┃\n");
                        System.out.printf("┃┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛      ┃\n");
                        System.out.printf("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛\n");
                        System.out.printf("번호를 고르시오 :");
                        int num = in.nextInt();
                        int rd = r.nextInt(3) + 1;

                        Tools.clear();
                        if (num == 1 && 1 == rd) {
                                System.out.printf("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓\n");
                                System.out.printf("┃┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓      ┃\n");
                                System.out.printf("┃┃                              [ 야바위게임 ]                             ┃      ┃\n");
                                System.out.printf("┃┣━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┫      ┃\n");
                                System.out.printf("┃┃       ┏━━━━━━━━━┓                                                     ┃      ┃\n");
                                System.out.printf("┃┃       ┃         ┃                                                     ┃      ┃\n");
                                System.out.printf("┃┃       ┃         ┃            ┏━━━━━━━━━┓            ┏━━━━━━━━━┓       ┃      ┃\n");
                                System.out.printf("┃┃       ┃         ┃            ┃         ┃            ┃         ┃       ┃┏━━━━┓┃\n");
                                System.out.printf("┃┃       ┃    1    ┃            ┃    2    ┃            ┃    3    ┃       ┃┃home┃┃\n");
                                System.out.printf("┃┃       ┃         ┃            ┃         ┃            ┃         ┃       ┃┗━━━━┛┃\n");
                                System.out.printf("┃┃       ┗━━━━━━━━━┛            ┃         ┃            ┃         ┃       ┃      ┃\n");
                                System.out.printf("┃┃                              ┃         ┃            ┃         ┃       ┃      ┃\n");
                                System.out.printf("┃┃            ○                 ┗━━━━━━━━━┛            ┗━━━━━━━━━┛       ┃      ┃\n");
                                System.out.printf("┃┃                                                                       ┃      ┃\n");
                                System.out.printf("┃┃                                                                       ┃      ┃\n");
                                System.out.printf("┃┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛      ┃\n");
                                System.out.printf("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛\n");
                                System.out.println("승리했습니다.계속하시겠습니까?(yes/no)");
                                input = in.nextLine();
                                if(input.equals("yes")){
                                        doubleCoin(2);
                                }
                                Tools.pause(2);

                        }


                        if (num == 1 && 1 != rd) {
                                System.out.printf("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓\n");
                                System.out.printf("┃┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓      ┃\n");
                                System.out.printf("┃┃                              [ Yabawe ]                               ┃      ┃\n");
                                System.out.printf("┃┣━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┫      ┃\n");
                                System.out.printf("┃┃       ┏━━━━━━━━━┓                                                     ┃      ┃\n");
                                System.out.printf("┃┃       ┃         ┃                                                     ┃      ┃\n");
                                System.out.printf("┃┃       ┃         ┃            ┏━━━━━━━━━┓            ┏━━━━━━━━━┓       ┃      ┃\n");
                                System.out.printf("┃┃       ┃         ┃            ┃         ┃            ┃         ┃       ┃┏━━━━┓┃\n");
                                System.out.printf("┃┃       ┃    1    ┃            ┃    2    ┃            ┃    3    ┃       ┃┃home┃┃\n");
                                System.out.printf("┃┃       ┃         ┃            ┃         ┃            ┃         ┃       ┃┗━━━━┛┃\n");
                                System.out.printf("┃┃       ┗━━━━━━━━━┛            ┃         ┃            ┃         ┃       ┃      ┃\n");
                                System.out.printf("┃┃                              ┃         ┃            ┃         ┃       ┃      ┃\n");
                                System.out.printf("┃┃                              ┗━━━━━━━━━┛            ┗━━━━━━━━━┛       ┃      ┃\n");
                                System.out.printf("┃┃                                                                       ┃      ┃\n");
                                System.out.printf("┃┃                                                                       ┃      ┃\n");
                                System.out.printf("┃┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛      ┃\n");
                                System.out.printf("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛\n");
                                System.out.println("패배했습니다.");
                                intput = 0;
                                Tools.pause(2);
                                break;


                        }
                        Tools.clear();
                        if (num == 2 && 2 == rd) {
                                System.out.printf("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓\n");
                                System.out.printf("┃┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓      ┃\n");
                                System.out.printf("┃┃                              [ 야바위게임 ]                             ┃      ┃\n");
                                System.out.printf("┃┣━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┫      ┃\n");
                                System.out.printf("┃┃                              ┏━━━━━━━━━┓                              ┃      ┃\n");
                                System.out.printf("┃┃                              ┃         ┃                              ┃      ┃\n");
                                System.out.printf("┃┃       ┏━━━━━━━━━┓            ┃         ┃            ┏━━━━━━━━━┓       ┃      ┃\n");
                                System.out.printf("┃┃       ┃         ┃            ┃         ┃            ┃         ┃       ┃┏━━━━┓┃\n");
                                System.out.printf("┃┃       ┃    1    ┃            ┃    2    ┃            ┃    3    ┃       ┃┃home┃┃\n");
                                System.out.printf("┃┃       ┃         ┃            ┃         ┃            ┃         ┃       ┃┗━━━━┛┃\n");
                                System.out.printf("┃┃       ┃         ┃            ┗━━━━━━━━━┛            ┃         ┃       ┃      ┃\n");
                                System.out.printf("┃┃       ┃         ┃                                   ┃         ┃       ┃      ┃\n");
                                System.out.printf("┃┃       ┗━━━━━━━━━┛                 ○                 ┗━━━━━━━━━┛       ┃      ┃\n");
                                System.out.printf("┃┃                                                                       ┃      ┃\n");
                                System.out.printf("┃┃                                                                       ┃      ┃\n");
                                System.out.printf("┃┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛      ┃\n");
                                System.out.printf("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛\n");
                                System.out.println("승리했습니다.계속하시겠습니까?(yes/no)");
                                input = in.nextLine();
                                if(input.equals("yes")){
                                        doubleCoin(2);
                                }
                                Tools.pause(2);

                        }
                        Tools.clear();
                        if (num == 2 && 2 != rd) {
                                System.out.printf("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓\n");
                                System.out.printf("┃┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓      ┃\n");
                                System.out.printf("┃┃                              [ 야바위게임 ]                             ┃      ┃\n");
                                System.out.printf("┃┣━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┫      ┃\n");
                                System.out.printf("┃┃                              ┏━━━━━━━━━┓                              ┃      ┃\n");
                                System.out.printf("┃┃                              ┃         ┃                              ┃      ┃\n");
                                System.out.printf("┃┃       ┏━━━━━━━━━┓            ┃         ┃            ┏━━━━━━━━━┓       ┃      ┃\n");
                                System.out.printf("┃┃       ┃         ┃            ┃         ┃            ┃         ┃       ┃┏━━━━┓┃\n");
                                System.out.printf("┃┃       ┃    1    ┃            ┃    2    ┃            ┃    3    ┃       ┃┃home┃┃\n");
                                System.out.printf("┃┃       ┃         ┃            ┃         ┃            ┃         ┃       ┃┗━━━━┛┃\n");
                                System.out.printf("┃┃       ┃         ┃            ┗━━━━━━━━━┛            ┃         ┃       ┃      ┃\n");
                                System.out.printf("┃┃       ┃         ┃                                   ┃         ┃       ┃      ┃\n");
                                System.out.printf("┃┃       ┗━━━━━━━━━┛                                   ┗━━━━━━━━━┛       ┃      ┃\n");
                                System.out.printf("┃┃                                                                       ┃      ┃\n");
                                System.out.printf("┃┃                                                                       ┃      ┃\n");
                                System.out.printf("┃┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛      ┃\n");
                                System.out.printf("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛\n");
                                System.out.println("패배했습니다.");
                                intput = 0;
                                Tools.pause(2);
                                break;


                        }
                        Tools.clear();
                        if (num == 3 && 3 == rd) {
                                System.out.printf("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓\n");
                                System.out.printf("┃┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓      ┃\n");
                                System.out.printf("┃┃                              [ 야바위게임 ]                             ┃      ┃\n");
                                System.out.printf("┃┣━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┫      ┃\n");
                                System.out.printf("┃┃                                                     ┏━━━━━━━━━┓       ┃      ┃\n");
                                System.out.printf("┃┃                                                     ┃         ┃       ┃      ┃\n");
                                System.out.printf("┃┃       ┏━━━━━━━━━┓            ┏━━━━━━━━━┓            ┃         ┃       ┃      ┃\n");
                                System.out.printf("┃┃       ┃         ┃            ┃         ┃            ┃         ┃       ┃┏━━━━┓┃\n");
                                System.out.printf("┃┃       ┃    1    ┃            ┃    2    ┃            ┃    3    ┃       ┃┃home┃┃\n");
                                System.out.printf("┃┃       ┃         ┃            ┃         ┃            ┃         ┃       ┃┗━━━━┛┃\n");
                                System.out.printf("┃┃       ┃         ┃            ┃         ┃            ┗━━━━━━━━━┛       ┃      ┃\n");
                                System.out.printf("┃┃       ┃         ┃            ┃         ┃                              ┃      ┃\n");
                                System.out.printf("┃┃       ┗━━━━━━━━━┛            ┗━━━━━━━━━┛                 ○            ┃      ┃\n");
                                System.out.printf("┃┃                                                                       ┃      ┃\n");
                                System.out.printf("┃┃                                                                       ┃      ┃\n");
                                System.out.printf("┃┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛      ┃\n");
                                System.out.printf("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛\n");
                                System.out.println("승리했습니다.계속하시겠습니까?(yes/no)");
                                input = in.nextLine();
                                Tools.pause(2);
                                if(input.equals("yes")){
                                        doubleCoin(2);
                                }
                                if(input.equals("no")){
                                        break;
                                }


                        }
                        Tools.clear();
                        if (num == 3 && 3 != rd) {
                                System.out.printf("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓\n");
                                System.out.printf("┃┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓      ┃\n");
                                System.out.printf("┃┃                              [ 야바위게임 ]                             ┃      ┃\n");
                                System.out.printf("┃┣━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┫      ┃\n");
                                System.out.printf("┃┃                                                     ┏━━━━━━━━━┓       ┃      ┃\n");
                                System.out.printf("┃┃                                                     ┃         ┃       ┃      ┃\n");
                                System.out.printf("┃┃       ┏━━━━━━━━━┓            ┏━━━━━━━━━┓            ┃         ┃       ┃      ┃\n");
                                System.out.printf("┃┃       ┃         ┃            ┃         ┃            ┃         ┃       ┃┏━━━━┓┃\n");
                                System.out.printf("┃┃       ┃    1    ┃            ┃    2    ┃            ┃    3    ┃       ┃┃home┃┃\n");
                                System.out.printf("┃┃       ┃         ┃            ┃         ┃            ┃         ┃       ┃┗━━━━┛┃\n");
                                System.out.printf("┃┃       ┃         ┃            ┃         ┃            ┗━━━━━━━━━┛       ┃      ┃\n");
                                System.out.printf("┃┃       ┃         ┃            ┃         ┃                              ┃      ┃\n");
                                System.out.printf("┃┃       ┗━━━━━━━━━┛            ┗━━━━━━━━━┛                              ┃      ┃\n");
                                System.out.printf("┃┃                                                                       ┃      ┃\n");
                                System.out.printf("┃┃                                                                       ┃      ┃\n");
                                System.out.printf("┃┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛      ┃\n");
                                System.out.printf("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛\n");
                                System.out.println("패배했습니다.");
                                intput = 0;
                                Tools.pause(2);
                                break;


                        }
                        Tools.clear();
                        System.out.printf("현재 캐시: %d\n", cash);
                        System.out.println("게임을 계속 하시겠습니까? (yes/no)");
                        String response = in.next().toLowerCase();
                        if (!response.equals("yes")) {
                                System.out.printf("남은 캐시: %d\n", cash);
                                System.out.println("게임을 종료합니다.");
                                return;

                        }

                        Tools.clear();
                }

        }
}
}