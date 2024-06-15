package com.project.phone.thred;

import com.project.phone.database.Connecting;
import com.project.phone.database.DBsetting;
import com.project.phone.file.FileIO;
import com.project.phone.main.Phone;
import com.project.phone.util.Tools;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectingThread extends Thread{
    Connecting connecting = Connecting.getInstance();
    FileIO fileIO = FileIO.getInstance();

    private static ConnectingThread connectingThread;



    public void run(){
        while(true) {
            try {
                fileIO.FileRead("setting.txt"); //setting파일을 읽어온 후 변수에 저장
                Connection connection = DriverManager.getConnection(DBsetting.url, DBsetting.username, DBsetting.password);
                connecting.setConnection(connection);
                Phone.signal = true;
                Phone.signal_text = "○";
                Tools.pause(1);
            } catch (SQLException e) {
                Phone.signal = false;
                Phone.signal_text = "X";
                Tools.pause(1);
            }
        }
    }

    public static ConnectingThread getInstance(){
        if(connectingThread == null){
            return connectingThread = new ConnectingThread();
        }
        return connectingThread;
    }

}
