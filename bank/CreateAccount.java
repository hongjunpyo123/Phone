package com.project.phone.bank;

import com.project.phone.database.Connecting;
import com.project.phone.main.Phone;
import com.project.phone.util.Tools;

import java.sql.SQLException;
import java.util.Random;
import java.util.Scanner;

public class CreateAccount {
    private static CreateAccount createAccount;
    private Connecting connecting;
    private String accountNumber;
    private String input = null;
    Scanner in = new Scanner(System.in);
    private CreateAccount(Connecting connecting){
        this.connecting = connecting;
    }



    public int createAccount(){

        Tools.clear(); //화면 초기화
        Tools.flush(); //입력버퍼 초기화

        createAccountNumber(); //계좌번호 생성


        System.out.printf("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓\n");
        System.out.printf("┃┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓      ┃\n");
        System.out.printf("┃┃                         [ Opening an Account ]                        ┃      ┃\n");
        System.out.printf("┃┃                                                                       ┃      ┃\n");
        System.out.printf("┃┃                                                                       ┃      ┃\n");
        System.out.printf("┃┃                                                                       ┃      ┃\n");
        System.out.printf("┃┃                                                                       ┃      ┃\n");
        System.out.printf("┃┃                            Your Account Number                        ┃┏━━━━┓┃\n");
        System.out.printf("┃┃                               [ %s ]                            ┃┃home┃┃\n", this.accountNumber);
        System.out.printf("┃┃                                                                       ┃┗━━━━┛┃\n");
        System.out.printf("┃┃                                                                       ┃      ┃\n");
        System.out.printf("┃┃                                                                       ┃      ┃\n");
        System.out.printf("┃┃                                                                       ┃      ┃\n");
        System.out.printf("┃┃                                                                       ┃      ┃\n");
        System.out.printf("┃┃                                                                       ┃      ┃\n");
        System.out.printf("┃┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛      ┃\n");
        System.out.printf("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛\n");
        System.out.printf("=>계좌를 생성하시겠습니까?(yes / no) :");
        input = in.nextLine();
        if(input.equals("home")){
            return 0;
        }
        else if(input.equals("yes")) {
            if(!connecting.query("INSERT INTO bank (name, number, account, cash) VALUES (?, ?, ?, ?)", Phone.name, Phone.number, this.accountNumber,
                    "0","insert")){
                return -1;
            }
            System.out.println("계좌를 생성하였습니다");
            Tools.pause(1);
            Money.addMoney(this.accountNumber, 10000, "Event");
            System.out.println("[ 1만원 지급됨 ]");
            Tools.pause(1);
        }
        else{
            System.out.println("생성을 취소합니다.");
            Tools.pause(1);
            return -1; //생성실패 -1반환
        }



        return 0;
    }



    public static CreateAccount getInstance(Connecting connecting){
        if(createAccount == null){
            return createAccount = new CreateAccount(connecting);
        }
        return createAccount;
    }


    public String getAccountNumber(){
        connecting.query("SELECT * FROM bank WHERE number = ?", Phone.number, "select");
        try{
            if (connecting.getQueryResult().next()){
                this.accountNumber = connecting.getQueryResult().getString("account");
                return accountNumber;
            }
        } catch (SQLException e) {
            return "00000000"; //계좌번호를 검색하지 못했을 경우
        }


        return accountNumber;
    }

    private void createAccountNumber(){
        Random random = new Random();
        int accountN = 10000000 + random.nextInt(90000000);
        this.accountNumber = Integer.toString(accountN);
    }

}
