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

        public void gameYabawe() {
                Tools.clear();
                Tools.flush();
                String input = null; //사용자 입력값 저장
                String yabawe;
                while (true){
                while (true) {
                        System.out.printf("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓\n");
                        System.out.printf("┃┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓┏━━━━┓┃\n");
                        System.out.printf("┃┃                              [ 야바위게임 ]                             ┃┃back┃┃\n");
                        System.out.printf("┃┣━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┫┗━━━━┛┃\n");
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
                                System.out.printf("┃┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓┏━━━━┓┃\n");
                                System.out.printf("┃┃                              [ 야바위게임 ]                             ┃┃back┃┃\n");
                                System.out.printf("┃┣━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┫┗━━━━┛┃\n");
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
                                cash += 1000;
                                System.out.println("승리했습니다. +1000캐시");
                                Tools.pause(2);

                        }


                        if (num == 1 && 1 != rd) {
                                System.out.printf("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓\n");
                                System.out.printf("┃┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓┏━━━━┓┃\n");
                                System.out.printf("┃┃                              [ 야바위게임 ]                             ┃┃back┃┃\n");
                                System.out.printf("┃┣━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┫┗━━━━┛┃\n");
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
                                cash -= 1000;
                                System.out.println("패배했습니다. -1000캐시");
                                Tools.pause(2);

                        }
                        Tools.clear();
                        if (num == 2 && 2 == rd) {
                                System.out.printf("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓\n");
                                System.out.printf("┃┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓┏━━━━┓┃\n");
                                System.out.printf("┃┃                              [ 야바위게임 ]                             ┃┃back┃┃\n");
                                System.out.printf("┃┣━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┫┗━━━━┛┃\n");
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
                                cash += 1000;
                                System.out.println("승리했습니다. +1000캐시");
                                Tools.pause(2);

                        }
                        Tools.clear();
                        if (num == 2 && 2 != rd) {
                                System.out.printf("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓\n");
                                System.out.printf("┃┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓┏━━━━┓┃\n");
                                System.out.printf("┃┃                              [ 야바위게임 ]                             ┃┃back┃┃\n");
                                System.out.printf("┃┣━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┫┗━━━━┛┃\n");
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
                                cash -= 1000;
                                System.out.println("패배했습니다. -1000캐시");
                                Tools.pause(2);

                        }
                        Tools.clear();
                        if (num == 3 && 3 == rd) {
                                System.out.printf("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓\n");
                                System.out.printf("┃┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓┏━━━━┓┃\n");
                                System.out.printf("┃┃                              [ 야바위게임 ]                             ┃┃back┃┃\n");
                                System.out.printf("┃┣━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┫┗━━━━┛┃\n");
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
                                cash += 1000;
                                System.out.println("승리했습니다. +1000캐시");
                                Tools.pause(2);

                        }
                        Tools.clear();
                        if (num == 3 && 3 != rd) {
                                System.out.printf("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓\n");
                                System.out.printf("┃┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓┏━━━━┓┃\n");
                                System.out.printf("┃┃                              [ 야바위게임 ]                             ┃┃back┃┃\n");
                                System.out.printf("┃┣━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┫┗━━━━┛┃\n");
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
                                cash -= 1000;
                                System.out.println("패배했습니다. -1000캐시");
                                Tools.pause(2);

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