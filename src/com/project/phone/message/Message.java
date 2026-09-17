package com.project.phone.message;

import com.project.phone.database.Connecting;
import com.project.phone.main.Phone;
import com.project.phone.thred.ChatThread;
import com.project.phone.util.Tools;

import java.util.Scanner;

public class Message {
    private Scanner in = new Scanner(System.in);
    private Connecting connecting = Connecting.getInstance();
    private static Message message;

    private Message() {};

    public int phoneMessage(){
        Tools.clear();
        Tools.flush();
        String input = null; //사용자 입력값 저장
        String message;

        System.out.printf("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓\n");
        System.out.printf("┃┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓      ┃\n");
        System.out.printf("┃┃                               [ message ]                             ┃      ┃\n");
        System.out.printf("┃┃                                                                       ┃      ┃\n");
        System.out.printf("┃┃ my phone number : %s",Phone.number);
        for(int i = 0; i < 52-Phone.number.length(); i++){
            System.out.printf(" ");
        }
        System.out.printf("┃      ┃\n");
        System.out.printf("┃┃                                                                       ┃      ┃\n");
        System.out.printf("┃┃                                                                       ┃      ┃\n");
        System.out.printf("┃┃                                                                       ┃┏━━━━┓┃\n");
        System.out.printf("┃┃                                                                       ┃┃home┃┃\n");
        System.out.printf("┃┃                                                                       ┃┗━━━━┛┃\n");
        System.out.printf("┃┃                                                                       ┃      ┃\n");
        System.out.printf("┃┃                                                                       ┃      ┃\n");
        System.out.printf("┃┃                                                                       ┃      ┃\n");
        System.out.printf("┃┃                                                                       ┃      ┃\n");
        System.out.printf("┃┃ !메세지를 전송할 번호를 입력하세요\n");
        System.out.printf("┃┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛      ┃\n");
        System.out.printf("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛\n");
        System.out.printf("=>:");
        input = this.in.nextLine();
        if(!Phone.getSignal()){
            System.out.println("연결 상태를 확인해주세요.");
            Tools.pause(1);
            return 0;
        }
        if(input.equals("home")){
            return 0;
        }
        if(!ChatThread.optionThread("start")){
            Tools.pause(1);
            return 0;
        }
        Tools.pause(2);
        while(true){

            if(!Phone.getSignal()){
                return 0;
            }

           if(Phone.signal){ //db에 성공적으로 연결되었을 때 입력값을 받음
               message = in.nextLine();
           }
           else{
               return 0;
           }

            System.out.printf("=>:");
            if(message.equals("0") || message.equals("home")){
                ChatThread.optionThread("stop");
                break;
            }
            if(!connecting.query("INSERT INTO msg (send_name, send_number, message) VALUES (?, ?, ?)", Phone.name, input, message, "insert")){
                return 0;
            }
        }


        return 0;
    }


    public static Message getInstance(){
        if(message == null){
            message = new Message();
            return message;
        }
        return message;
    }
}
