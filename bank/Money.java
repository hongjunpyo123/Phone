package com.project.phone.bank;

import com.project.phone.database.Connecting;
import com.project.phone.main.Phone;

import java.sql.SQLException;

public class Money {
    private static int cash = 0;
    private static Connecting connecting = Connecting.getInstance();
    private static CreateAccount createAccount = CreateAccount.getInstance(connecting);

    private Money(){}

    public static int getCash(){
        if(!Phone.signal){
            System.out.println("연결 상태를 확인해주세요.");
        }
        connecting.query("SELECT * FROM bank WHERE account = ?", createAccount.getAccountNumber(), "select");
        try{
            if (connecting.getQueryResult().next()){
                cash = Integer.parseInt(connecting.getQueryResult().getString("cash"));
                return cash;
            }
        } catch (SQLException e) {
            return -2; //계좌번호를 검색하지 못했을 경우
        }

        return cash;
    }

    public static boolean addMoney(String account, int cash, String name){
        if(!Phone.signal){
            System.out.println("연결 상태를 확인해주세요.");
            return false;
        }
        if(connecting.query("UPDATE bank SET cash = cash + ? WHERE account = ?", Integer.toString(cash), account, "insert")){
            connecting.query("INSERT INTO transfer (account, cash, sendName, type, today) VALUES (?, ?, ?, ?, ?)",
                    account,
                    Integer.toString(cash),
                    name,
                    "add",
                    Phone.today.toString(), "insert");
            return true;
        }else {
            return false;
        }
    }
    public static boolean subMoney(String account, int cash, String name){
        if(!Phone.signal){
            System.out.println("연결 상태를 확인해주세요.");
            return false;
        }
        if(connecting.query("UPDATE bank SET cash = cash - ? WHERE account = ?", Integer.toString(cash), account, "insert")){
            connecting.query("INSERT INTO transfer (account, cash, sendName, type, today) VALUES (?, ?, ?, ?, ?)",
                    account,
                    Integer.toString(cash),
                    name,
                    "sub",
                    Phone.today.toString(), "insert");

            return true;
        }else {
            return false;
        }
    }
}
