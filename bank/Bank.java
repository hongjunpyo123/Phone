package com.project.phone.bank;

import com.project.phone.database.Connecting;
import com.project.phone.main.Phone;
import com.project.phone.util.Tools;

import java.sql.SQLException;
import java.util.Scanner;

public class Bank {
    private Scanner in = new Scanner(System.in);
    private static Bank bank;
    private String input = null;
    private Connecting connecting = Connecting.getInstance();
    private CreateAccount createAccount = CreateAccount.getInstance(connecting); //connecting의존성 주입
    private SendMoney sendMoney = SendMoney.getInstance(connecting, createAccount);// connecting, createAccount 의존성 주입
    private TransferHistory transferHistory = TransferHistory.getInstance(connecting);

    private Bank(){ }


    public int phoneBank(){
        if(!Phone.getSignal()){
            System.out.println("연결 상태를 확인해주세요.");
            Tools.pause(1);
            return -1;
        }

        if(!checkAccount()) {
            if (createAccount.createAccount() == -1) {
                return 0;
            }
        }else {
            while (true) {
                Tools.clear(); //화면 초기화
                Tools.flush(); //입력버퍼 초기화


                System.out.printf("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓\n");
                System.out.printf("┃┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓      ┃\n");
                System.out.printf("┃┃                                 [ BANK ]                              ┃      ┃\n");
                System.out.printf("┃┃                                                                       ┃      ┃\n");
                System.out.printf("┃┃                                                                       ┃      ┃\n");
                System.out.printf("┃┃                                                                       ┃      ┃\n");
                System.out.printf("┃┃         ┏━━━━━━━━━━━━━━━━━━━┓             ┏━━━━━━━━━━━━━━━━┓          ┃      ┃\n");
                System.out.printf("┃┃         ┃[1]Transfer History┃             ┃ [2]Send Money  ┃          ┃┏━━━━┓┃\n");
                System.out.printf("┃┃         ┗━━━━━━━━━━━━━━━━━━━┛             ┗━━━━━━━━━━━━━━━━┛          ┃┃home┃┃\n");
                System.out.printf("┃┃                                                                       ┃┗━━━━┛┃\n");
                System.out.printf("┃┃                                                                       ┃      ┃\n");
                System.out.printf("┃┃                                                                       ┃      ┃\n");
                System.out.printf("┃┣━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┫      ┃\n");
                System.out.printf("┃┃                     my account number : %s                      ┃      ┃\n", createAccount.getAccountNumber());
                System.out.printf("┃┃                               my cash : %,d(won)", Money.getCash());
                for (int i = 0; i < 24 - Tools.intLength(Money.getCash()); i++) {
                    System.out.printf(" ");
                }
                if(Tools.intLength(Money.getCash()) <= 3){
                    System.out.printf(" ");
                }
                System.out.printf("┃      ┃\n");
                System.out.printf("┃┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛      ┃\n");
                System.out.printf("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛\n");
                System.out.printf("=>:");
                input = in.nextLine();
                if (input.equals("home")) {
                    return 0;
                }
                else if(input.equals("1")){
                    if(!transferHistory.BankTransferHistory(createAccount.getAccountNumber())){
                        return 0;
                    }
                }
                else if(input.equals("2")){
                    sendMoney.bankSendMoney();
                }
            }
        }




        return 0;
    }



    public static Bank getInstance(){
        if(bank == null){
            return bank = new Bank();
        }
        return bank;
    }

    public boolean checkAccount(){
        connecting.query("SELECT * FROM bank WHERE number = ?", Phone.number, "select");
        try{
            if(connecting.getQueryResult().next()){
                return true;
            }
            else{
                return false;
            }
        } catch (SQLException e) {
            return false;
        }
    }
}
