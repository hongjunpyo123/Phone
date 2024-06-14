package com.project.phone.bank;

import com.project.phone.database.Connecting;
import com.project.phone.util.Tools;

import java.sql.SQLException;
import java.util.Scanner;

public class TransferHistory {
    private static TransferHistory transferHistory;
    private Connecting connecting;
    Scanner in = new Scanner(System.in);
    private TransferHistory(Connecting connecting){
        this.connecting = connecting;
    }

    public boolean BankTransferHistory(String account){
        Tools.flush();
        Tools.clear();
        connecting.query("SELECT * FROM transfer WHERE account = ?", account, "select");
        try{
            while(connecting.getQueryResult().next()){

                System.out.println("--------------------------------");
                if(connecting.getQueryResult().getString("type").equals("add")){
                    System.out.printf("[%s]        +%,d(won)\n", connecting.getQueryResult().getString("sendName"),
                            Integer.parseInt(connecting.getQueryResult().getString("cash")));
                    System.out.printf("-%s-\n", connecting.getQueryResult().getString("today"));
                }
                else if(connecting.getQueryResult().getString("type").equals("sub")){
                    System.out.printf("[%s]        -%,d(won)\n", connecting.getQueryResult().getString("sendName"),
                            Integer.parseInt(connecting.getQueryResult().getString("cash")));
                    System.out.printf("-%s-\n", connecting.getQueryResult().getString("today"));
                }
                System.out.println("--------------------------------");

            }
            System.out.print("[ENTER를 눌러주세요]");
            in.nextLine();
            return true;
        } catch (SQLException e) {
            return false;
        }

    }






    public static TransferHistory getInstance(Connecting connecting){
        if(transferHistory == null){
            return transferHistory = new TransferHistory(connecting);
        }
        return transferHistory;
    }
}
