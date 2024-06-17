package com.project.phone.thred;

import com.project.phone.database.Connecting;
import com.project.phone.main.Phone;
import com.project.phone.util.Tools;

import java.sql.ResultSet;

public class ChatThread extends Thread {
    private Connecting connecting = Connecting.getInstance();
    public static boolean th_check;

    public static void setThread(boolean check) {
        th_check = check;
    }

    public static boolean optionThread(String option){
        ChatThread chatThread = new ChatThread();
        if(option.equals("start")){
            if(!Phone.signal){
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
            if(!connecting.query("SELECT * FROM msg WHERE send_number = ?", Phone.number, "select")){
                Thread.currentThread().interrupt();
                th_check = true;
            }
            ResultSet resultSet1 = connecting.getQueryResult();
                    Tools.pause(1);
            while (resultSet1.next() && Thread.currentThread().isInterrupted()) {
                String message = resultSet1.getString("message");
                String send_name = resultSet1.getString("send_name");
                System.out.print("\n" + "[" + send_name + "]" + " : " + message);
                connecting.query("DELETE FROM msg WHERE send_number = ?", Phone.number, "delete");
            }
            System.out.printf("\n=>:");
            while (!Thread.currentThread().isInterrupted() && Phone.signal) {
                if (th_check == true) {
                    break;
                }
                Tools.pause(1); //등록되기 이전 select하는 문제를 방지하기 위한 딜레이
                connecting.query("SELECT * FROM msg WHERE send_number = ?",Phone.number, "select");
                ResultSet resultSet = connecting.getQueryResult();

                if (resultSet.next()) {
                    String message = resultSet.getString("message");
                    String send_name = resultSet.getString("send_name");
                    System.out.print("\n" + "[" + send_name + "]" + " : " + message + "\n(이어서 입력[0] : ");
                    connecting.query("DELETE FROM msg WHERE send_number = ?", Phone.number, "delete");
                } else {
                    //무한 루프를 위한 else문
                }
            }
        } catch (Exception e) {
            System.out.printf("에러");
            ChatThread.optionThread("stop");
        }
    }
}

