package com.project.phone.bank;

import com.project.phone.database.Connecting;
import com.project.phone.main.Phone;
import com.project.phone.util.Tools;

import java.util.Scanner;

public class SendMoney {

    private static SendMoney sendMoney;
    private String RecipientAccount;
    private String input = null;
    private int inputCash;

    Connecting connecting;
    CreateAccount createAccount;
    Scanner in = new Scanner(System.in);



    public int bankSendMoney(){
        Tools.clear(); //화면 초기화
        Tools.flush(); //입력버퍼 초기화

        System.out.printf("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓\n");
        System.out.printf("┃┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓      ┃\n");
        System.out.printf("┃┃                               [ SendMoney ]                           ┃      ┃\n");
        System.out.printf("┃┃                                                                       ┃      ┃\n");
        System.out.printf("┃┃                     ┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓  ┃      ┃\n");
        System.out.printf("┃┃  Recipient-Account  ┃                                              ┃  ┃      ┃\n");
        System.out.printf("┃┃                     ┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛  ┃      ┃\n");
        System.out.printf("┃┃                     ┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓  ┃┏━━━━┓┃\n");
        System.out.printf("┃┃   Transfer Amount   ┃                                              ┃  ┃┃home┃┃\n");
        System.out.printf("┃┃                     ┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛  ┃┗━━━━┛┃\n");
        System.out.printf("┃┃                                                                       ┃      ┃\n");
        System.out.printf("┃┃                                                                       ┃      ┃\n");
        System.out.printf("┃┣━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┫      ┃\n");
        System.out.printf("┃┃                     my account number : %s                      ┃      ┃\n", createAccount.getAccountNumber());
        System.out.printf("┃┃                               my cash : %,d(won)", Money.getCash());
        for(int i = 0; i < 24- Tools.intLength(Money.getCash()); i++){
            System.out.printf(" ");
        }
        System.out.printf("┃      ┃\n");
        System.out.printf("┃┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛      ┃\n");
        System.out.printf("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛\n");
        System.out.printf("=>(받으시는분)계좌번호:");
        input = in.next();

        if(input.equals("home")){
            return 0;
        }

        if(input.length() != 8){
            System.out.println("잘못된 값입니다");
            Tools.pause(1);
            return 0;
        }

        try{
            System.out.printf("=>송금금액:");
            inputCash = in.nextInt();
        }catch (Exception e){
            System.out.println("잘못된 값입니다");
            Tools.flush();
            Tools.pause(1);
            return 0;
        }

        this.RecipientAccount = input;


        Tools.clear(); //화면 초기화
        Tools.flush(); //입력버퍼 초기화

        System.out.printf("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓\n");
        System.out.printf("┃┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓      ┃\n");
        System.out.printf("┃┃                               [ SendMoney ]                           ┃      ┃\n");
        System.out.printf("┃┃                                                                       ┃      ┃\n");
        System.out.printf("┃┃                     ┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓  ┃      ┃\n");
        System.out.printf("┃┃  Recipient-Account  ┃                  %s                    ┃  ┃      ┃\n", this.RecipientAccount);
        System.out.printf("┃┃                     ┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛  ┃      ┃\n");
        System.out.printf("┃┃                     ┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓  ┃┏━━━━┓┃\n");
        System.out.printf("┃┃   Transfer Amount   ┃                 %,d(won)", this.inputCash);
        for(int i = 0; i < 23- Tools.intLength(this.inputCash); i++){
            System.out.printf(" ");
        }
        System.out.printf("┃  ┃┃home┃┃\n");
        System.out.printf("┃┃                     ┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛  ┃┗━━━━┛┃\n");
        System.out.printf("┃┃                                                                       ┃      ┃\n");
        System.out.printf("┃┃                                                                       ┃      ┃\n");
        System.out.printf("┃┣━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┫      ┃\n");
        System.out.printf("┃┃                     my account number : %s                      ┃      ┃\n", createAccount.getAccountNumber());
        System.out.printf("┃┃                               my cash : %,d(won)", Money.getCash()-this.inputCash);
        for(int i = 0; i < 24- Tools.intLength(Money.getCash()-this.inputCash); i++){
            System.out.printf(" ");
        }
        System.out.printf("┃      ┃\n");
        System.out.printf("┃┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛      ┃\n");
        System.out.printf("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛\n");

        System.out.printf("=>송금하시겠습니까?(yes/no):");
        input = in.next();
        if(input.equals("yes")){
            if(this.inputCash <= Money.getCash()){
                Money.subMoney(createAccount.getAccountNumber(), inputCash, Phone.name);
                Money.addMoney(this.RecipientAccount, inputCash, Phone.name);
                System.out.println("송금 완료되었습니다.");
                Tools.pause(1);
            }
            else{
                System.out.println("잔액이 부족합니다.");
                Tools.pause(1);
            }
        }
        else if(input.equals("no")){
            System.out.println("취소합니다.");
            Tools.pause(1);
            return 0;
        }
        else{
            System.out.println("취소합니다.");
            Tools.pause(1);
            return 0;
        }


        return 0;
    }












    private SendMoney(Connecting connecting, CreateAccount createAccount){
        this.connecting = connecting;
        this.createAccount = createAccount;
    }

    public static SendMoney getInstance(Connecting connecting, CreateAccount createAccount){
        if(sendMoney == null){
            return sendMoney = new SendMoney(connecting, createAccount);
        }
        return sendMoney;
    }

}
