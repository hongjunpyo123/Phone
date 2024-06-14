package com.project.phone.bank;

import com.project.phone.database.Connecting;

import java.sql.SQLException;

public class Money {
    private static int cash = 0;
    private static Connecting connecting = Connecting.getInstance();
    private static CreateAccount createAccount = CreateAccount.getInstance(connecting);

    private Money(){}

    public static int getCash(){
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
}
