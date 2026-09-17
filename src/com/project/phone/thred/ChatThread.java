package com.project.phone.thred;

import com.project.phone.database.Connecting;
import com.project.phone.database.DBsetting;
import com.project.phone.main.Phone;
import com.project.phone.util.Tools;

import java.sql.*;

public class ChatThread extends Thread {
    Connecting connecting = Connecting.getInstance();
    private String url = DBsetting.url;
    private String username = DBsetting.username;
    private String password = DBsetting.password;
    private String number = Phone.number;
    public static boolean th_check;

    public static void setThread(boolean check) {
        th_check = check;
    }

    public static boolean optionThread(String option){
        ChatThread chatThread = new ChatThread();
        if(option.equals("start")){
            if(!Connecting.getInstance().DBconnect()){
                return false;
            }
            ChatThread.setThread(false);
            chatThread.start();
            return true;
        }
        else if(option.equals("stop")){
            ChatThread.setThread(true);
            Thread.currentThread().interrupt();
            return false;
        }
        return false;
    }

    public void run() {
        try {
            ResultSet resultSet1 = connecting.query_1("SELECT * FROM msg WHERE send_number = ?", Phone.number);
            Tools.pause(1);
            while (resultSet1.next()) {
                String message = resultSet1.getString("message");
                String send_name = resultSet1.getString("send_name");
                System.out.print("\n" + "[" + send_name + "]" + " : " + message);
                connecting.query_1("DELETE FROM msg WHERE send_number = ?", Phone.number, "delete");
            }
            System.out.printf("=>:");
            while (!Thread.currentThread().isInterrupted()) {
                if (th_check == true) {
                    break;
                }
                ResultSet resultSet = connecting.query_1("SELECT * FROM msg WHERE send_number = ?",Phone.number);

                if (resultSet.next()) {
                    String message = resultSet.getString("message");
                    String send_name = resultSet.getString("send_name");
                    System.out.print("\n" + "[" + send_name + "]" + " : " + message + "\n(이어서 입력[0] : ");
                    connecting.query_1("DELETE FROM msg WHERE send_number = ?", Phone.number, "delete");
                } else {
                }
            }
        } catch (Exception e) {
            ChatThread.optionThread("stop");
        }
    }
}

