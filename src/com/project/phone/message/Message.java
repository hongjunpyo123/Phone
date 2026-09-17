package com.project.phone.message;

import com.project.phone.database.Connecting;
import com.project.phone.main.Phone;
import com.project.phone.thred.ChatThread;
import com.project.phone.util.Tools;

import java.util.Scanner;

public class Message {
    Scanner in = new Scanner(System.in);
    Connecting connecting = Connecting.getInstance();
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
        if(!ChatThread.optionThread("start")){
            Tools.pause(2);
            return 0;
        }
        if(input.equals("home")){
            return 0;
        }
        Tools.pause(2);
        while(true){
            message = in.nextLine();
            System.out.printf("=>:");
            if(message.equals("0")){
                ChatThread.optionThread("stop");
                break;
            }
            connecting.query_2("INSERT INTO msg (send_name, send_number, message) VALUES (?, ?, ?)", Phone.name, input, message);
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
