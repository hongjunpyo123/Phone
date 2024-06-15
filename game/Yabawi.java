package com.project.phone.game;

import com.project.phone.bank.Bank;
import com.project.phone.bank.CreateAccount;
import com.project.phone.database.Connecting;
import com.project.phone.util.Tools;

import java.util.Random;
import java.util.Scanner;

public class Yabawi {
    Random random = new Random();
    private Coin coin;
    private Bank bank;
    private CreateAccount createAccount;
    private Connecting connecting;
    private Scanner in = new Scanner(System.in);
    private static Yabawi yabawi;
    private String input = null;

    private String[] yabawiArray = new String[3];
    private int yabawiNumber;



    private Yabawi(Coin coin, Bank bank, CreateAccount createAccount, Connecting connecting){
        this.coin = coin;
        this.bank = bank;
        this.createAccount = createAccount;
        this.connecting = connecting;
    }


    public int gameYabawi(){
        while(true) {
            input = null;
            in = new Scanner(System.in);

            setYabawi();
            Tools.flush(in);
            Tools.clear();

            System.out.printf("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓\n");
            System.out.printf("┃┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓      ┃\n");
            System.out.printf("┃┃                           [ Yabawi Game ]                             ┃      ┃\n");
            System.out.printf("┃┣━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┫      ┃\n");
            System.out.printf("┃┃       ┏━━━━━━━━━┓            ┏━━━━━━━━━┓            ┏━━━━━━━━━┓       ┃      ┃\n");
            System.out.printf("┃┃       ┃■■■■■■■■■┃            ┃■■■■■■■■■┃            ┃■■■■■■■■■┃       ┃      ┃\n");
            System.out.printf("┃┃       ┃    1    ┃            ┃    2    ┃            ┃    3    ┃       ┃      ┃\n");
            System.out.printf("┃┃       ┃         ┃            ┃         ┃            ┃         ┃       ┃┏━━━━┓┃\n");
            System.out.printf("┃┃       ┃         ┃            ┃         ┃            ┃         ┃       ┃┃back┃┃\n");
            System.out.printf("┃┃       ┃         ┃            ┃         ┃            ┃         ┃       ┃┗━━━━┛┃\n");
            System.out.printf("┃┃       ┗━━━━━━━━━┛            ┗━━━━━━━━━┛            ┗━━━━━━━━━┛       ┃      ┃\n");
            System.out.printf("┃┃                                                                       ┃      ┃\n");
            System.out.printf("┃┃                             [ [0]start ]                              ┃      ┃\n");
            System.out.printf("┃┃       ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━       ┃      ┃\n");
            System.out.printf("┃┃                                                                       ┃      ┃\n");
            System.out.printf("┃┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛      ┃\n");
            System.out.printf("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛\n");
            System.out.println("[판당 100코인 소모]");
            System.out.println("[승리 시 2배 지급]");
            System.out.println("[코인 보유 수 : "+coin.getCoin()+"(coin)]");
            System.out.print("시작하려면 0번을 누르세요!:");
            input = in.next();

            if (input.equals("home") || input.equals("back")) {
                return 0;
            }

            if(coin.getCoin() < 100){
                System.out.println("\n코인이 부족합니다.");
                Tools.pause(1);
                return 0;
            }

            in.nextLine();

            Tools.flush(in);
            Tools.clear();

            coin.subCoin(100);

            System.out.printf("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓\n");
            System.out.printf("┃┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓      ┃\n");
            System.out.printf("┃┃                           [ Yabawi Game ]                             ┃      ┃\n");
            System.out.printf("┃┣━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┫      ┃\n");
            System.out.printf("┃┃       ┏━━━━━━━━━┓            ┏━━━━━━━━━┓            ┏━━━━━━━━━┓       ┃      ┃\n");
            System.out.printf("┃┃       ┃■■■■■■■■■┃            ┃■■■■■■■■■┃            ┃■■■■■■■■■┃       ┃      ┃\n");
            System.out.printf("┃┃       ┃    1    ┃            ┃    2    ┃            ┃    3    ┃       ┃      ┃\n");
            System.out.printf("┃┃       ┃         ┃            ┃         ┃            ┃         ┃       ┃┏━━━━┓┃\n");
            System.out.printf("┃┃       ┃         ┃            ┃         ┃            ┃         ┃       ┃┃back┃┃\n");
            System.out.printf("┃┃       ┃         ┃            ┃         ┃            ┃         ┃       ┃┗━━━━┛┃\n");
            System.out.printf("┃┃       ┗━━━━━━━━━┛            ┗━━━━━━━━━┛            ┗━━━━━━━━━┛       ┃      ┃\n");
            System.out.printf("┃┃                                                                       ┃      ┃\n");
            System.out.printf("┃┃           %s                       %s                      %s            ┃      ┃\n", yabawiArray[0], yabawiArray[1], yabawiArray[2]);
            System.out.printf("┃┃       ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━       ┃      ┃\n");
            System.out.printf("┃┃                                                                       ┃      ┃\n");
            System.out.printf("┃┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛      ┃\n");
            System.out.printf("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛\n");

            Tools.pause(3);
            Tools.flush();
            Tools.clear();

            setYabawi();

            System.out.printf("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓\n");
            System.out.printf("┃┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓      ┃\n");
            System.out.printf("┃┃                              [ Yabawi Game ]                          ┃      ┃\n");
            System.out.printf("┃┣━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┫      ┃\n");
            System.out.printf("┃┃                                                                       ┃      ┃\n");
            System.out.printf("┃┃                                                                       ┃      ┃\n");
            System.out.printf("┃┃       ┏━━━━━━━━━┓            ┏━━━━━━━━━┓            ┏━━━━━━━━━┓       ┃      ┃\n");
            System.out.printf("┃┃       ┃■■■■■■■■■┃            ┃■■■■■■■■■┃            ┃■■■■■■■■■┃       ┃┏━━━━┓┃\n");
            System.out.printf("┃┃       ┃    1    ┃            ┃    2    ┃            ┃    3    ┃       ┃┃back┃┃\n");
            System.out.printf("┃┃       ┃         ┃            ┃         ┃            ┃         ┃       ┃┗━━━━┛┃\n");
            System.out.printf("┃┃       ┃         ┃            ┃         ┃            ┃         ┃       ┃      ┃\n");
            System.out.printf("┃┃       ┃         ┃            ┃         ┃            ┃         ┃       ┃      ┃\n");
            System.out.printf("┃┃       ┗━━━━━━━━━┛            ┗━━━━━━━━━┛            ┗━━━━━━━━━┛       ┃      ┃\n");
            System.out.printf("┃┃       ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━       ┃      ┃\n");
            System.out.printf("┃┃                                                                       ┃      ┃\n");
            System.out.printf("┃┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛      ┃\n");
            System.out.printf("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛\n");
            System.out.printf("=>(번호를 고르세요):");
            input = in.next();
            if (input.equals("home") || input.equals("back")) {
                return 0;
            }
            else if (input.equals("1")) {

                Tools.flush(in);
                Tools.clear();

                System.out.printf("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓\n");
                System.out.printf("┃┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓      ┃\n");
                System.out.printf("┃┃                              [ Yabawi Game ]                          ┃      ┃\n");
                System.out.printf("┃┣━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┫      ┃\n");
                System.out.printf("┃┃       ┏━━━━━━━━━┓                                                     ┃      ┃\n");
                System.out.printf("┃┃       ┃■■■■■■■■■┃                                                     ┃      ┃\n");
                System.out.printf("┃┃       ┃    1    ┃            ┏━━━━━━━━━┓            ┏━━━━━━━━━┓       ┃      ┃\n");
                System.out.printf("┃┃       ┃         ┃            ┃■■■■■■■■■┃            ┃■■■■■■■■■┃       ┃┏━━━━┓┃\n");
                System.out.printf("┃┃       ┃         ┃            ┃    2    ┃            ┃    3    ┃       ┃┃back┃┃\n");
                System.out.printf("┃┃       ┃         ┃            ┃         ┃            ┃         ┃       ┃┗━━━━┛┃\n");
                System.out.printf("┃┃       ┗━━━━━━━━━┛            ┃         ┃            ┃         ┃       ┃      ┃\n");
                System.out.printf("┃┃                              ┃         ┃            ┃         ┃       ┃      ┃\n");
                System.out.printf("┃┃            %s                 ┗━━━━━━━━━┛            ┗━━━━━━━━━┛       ┃      ┃\n", yabawiArray[0]);
                System.out.printf("┃┃       ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━       ┃      ┃\n");
                System.out.printf("┃┃                                                                       ┃      ┃\n");
                System.out.printf("┃┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛      ┃\n");
                System.out.printf("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛\n");
                Tools.pause(1);
                if(Integer.parseInt(input)-1 == yabawiNumber){
                    System.out.println("축하드립니다!");
                    Tools.pause(1);
                    System.out.println("[ 200코인 지급됨 ]");
                    coin.addCoin(200);
                    Tools.pause(2);
                }else{
                    System.out.println("꽝! 다음 기회에..");
                    Tools.pause(1);
                }

            }

            else if (input.equals("2")) {

                Tools.flush(in);
                Tools.clear();

                System.out.printf("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓\n");
                System.out.printf("┃┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓      ┃\n");
                System.out.printf("┃┃                              [ Yabawi Game ]                          ┃      ┃\n");
                System.out.printf("┃┣━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┫      ┃\n");
                System.out.printf("┃┃                              ┏━━━━━━━━━┓                              ┃      ┃\n");
                System.out.printf("┃┃                              ┃■■■■■■■■■┃                              ┃      ┃\n");
                System.out.printf("┃┃       ┏━━━━━━━━━┓            ┃    2    ┃            ┏━━━━━━━━━┓       ┃      ┃\n");
                System.out.printf("┃┃       ┃■■■■■■■■■┃            ┃         ┃            ┃■■■■■■■■■┃       ┃┏━━━━┓┃\n");
                System.out.printf("┃┃       ┃    1    ┃            ┃         ┃            ┃    3    ┃       ┃┃back┃┃\n");
                System.out.printf("┃┃       ┃         ┃            ┃         ┃            ┃         ┃       ┃┗━━━━┛┃\n");
                System.out.printf("┃┃       ┃         ┃            ┗━━━━━━━━━┛            ┃         ┃       ┃      ┃\n");
                System.out.printf("┃┃       ┃         ┃                                   ┃         ┃       ┃      ┃\n");
                System.out.printf("┃┃       ┗━━━━━━━━━┛                 %s                 ┗━━━━━━━━━┛       ┃      ┃\n", yabawiArray[1]);
                System.out.printf("┃┃       ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━       ┃      ┃\n");
                System.out.printf("┃┃                                                                       ┃      ┃\n");
                System.out.printf("┃┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛      ┃\n");
                System.out.printf("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛\n");
                Tools.pause(1);
                if(Integer.parseInt(input)-1 == yabawiNumber){
                    System.out.println("축하드립니다!");
                    Tools.pause(1);
                    System.out.println("[ 200코인 지급됨 ]");
                    coin.addCoin(200);
                    Tools.pause(2);
                }else{
                    System.out.println("꽝! 다음 기회에..");
                    Tools.pause(1);
                }


            }

            else if (input.equals("3")) {

                Tools.flush(in);
                Tools.clear();

                System.out.printf("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓\n");
                System.out.printf("┃┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓      ┃\n");
                System.out.printf("┃┃                              [ Yabawi Game ]                          ┃      ┃\n");
                System.out.printf("┃┣━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┫      ┃\n");
                System.out.printf("┃┃                                                     ┏━━━━━━━━━┓       ┃      ┃\n");
                System.out.printf("┃┃                                                     ┃■■■■■■■■■┃       ┃      ┃\n");
                System.out.printf("┃┃       ┏━━━━━━━━━┓            ┏━━━━━━━━━┓            ┃    3    ┃       ┃      ┃\n");
                System.out.printf("┃┃       ┃■■■■■■■■■┃            ┃■■■■■■■■■┃            ┃         ┃       ┃┏━━━━┓┃\n");
                System.out.printf("┃┃       ┃    1    ┃            ┃    2    ┃            ┃         ┃       ┃┃back┃┃\n");
                System.out.printf("┃┃       ┃         ┃            ┃         ┃            ┃         ┃       ┃┗━━━━┛┃\n");
                System.out.printf("┃┃       ┃         ┃            ┃         ┃            ┗━━━━━━━━━┛       ┃      ┃\n");
                System.out.printf("┃┃       ┃         ┃            ┃         ┃                              ┃      ┃\n");
                System.out.printf("┃┃       ┗━━━━━━━━━┛            ┗━━━━━━━━━┛                 %s            ┃      ┃\n", yabawiArray[2]);
                System.out.printf("┃┃       ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━       ┃      ┃\n");
                System.out.printf("┃┃                                                                       ┃      ┃\n");
                System.out.printf("┃┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛      ┃\n");
                System.out.printf("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛\n");
                Tools.pause(1);
                if(Integer.parseInt(input)-1 == yabawiNumber){
                    System.out.println("축하드립니다!");
                    Tools.pause(1);
                    System.out.println("[ 200코인 지급됨 ]");
                    coin.addCoin(200);
                    Tools.pause(2);
                }else{
                    System.out.println("꽝! 다음 기회에..");
                    Tools.pause(1);
                }

            }

            else{
                System.out.println("잘못된 값입니다.");
                Tools.pause(1);
            }

        }
    }


    public static Yabawi getInstance(Coin coin, Bank bank, CreateAccount createAccount, Connecting connecting){
        if(yabawi == null){
            return yabawi = new Yabawi(coin, bank, createAccount, connecting);
        }
        return yabawi;
    }

    private void setYabawi(){
        for(int i = 0 ;i < yabawiArray.length; i++){
            yabawiArray[i] = " ";
        }
        yabawiNumber = random.nextInt(3);
        yabawiArray[yabawiNumber] = "○";

    }



}
