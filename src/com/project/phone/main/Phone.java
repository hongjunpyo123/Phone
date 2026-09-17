package com.project.phone.main;

import com.project.phone.database.DBsetting;
import com.project.phone.internet.Internet;
import com.project.phone.message.Message;
import com.project.phone.util.Tools;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;
public class Phone {
    public static Internet internet = Internet.getInstance();
    public static Message message = Message.getInstance();
    //의존성 주입 필요
    public static String name;
    public static String number;
    public static String model;

    private static String signal = "X"; //신호 확인용


    private Phone() { }

    public static void main(String[] args) {
        String model;
        String name;
        String number;

        Scanner in = new Scanner(System.in);
        while (true) {
            Tools.clear();
            System.out.println("** 휴대폰 생성 페이지 **");
            System.out.print("모델명을 입력해주세요 : ");
            model = in.next();
            System.out.print("사용자 이름을 입력해주세요 : ");
            name = in.next();
            System.out.print("사용할 " +
                    "전화번호를 입력해주세요 : ");
            number = in.next();
            if (number.length() != 11) {
                System.out.println("\n전화번호가 유효하지 않습니다 다시 입력하세요!");
                Tools.pause(3);
                continue;
            }
            Phone.model = model;
            Phone.number = number;
            Phone.name = name;

            Phone.startPhone();
        }
    }
    public static void startPhone(){
        while(true){
            Tools.clear();
            System.out.printf("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓\n");
            System.out.printf("┃┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓┃\n");
            System.out.printf("┃┃                            ┃┃\n");
            System.out.printf("┃┃                            ┃┃\n");
            System.out.printf("┃┃                            ┃┃\n");
            System.out.printf("┃┃                            ┃┃\n");
            System.out.printf("┃┃                            ┃┃\n");
            System.out.printf("┃┃                            ┃┃\n");
            System.out.printf("┃┃           welcome!         ┃┃\n", name);
            System.out.printf("┃┃ Your number :   %s┃┃\n",number);
            System.out.printf("┃┃                            ┃┃\n");
            System.out.printf("┃┃                            ┃┃\n");
            System.out.printf("┃┃                            ┃┃\n");
            System.out.printf("┃┃                            ┃┃\n");
            System.out.printf("┃┃                            ┃┃\n");
            System.out.printf("┃┃                            ┃┃\n");
            System.out.printf("┃┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛┃\n");
            System.out.printf("┃             ┏━━┓             ┃\n");
            System.out.printf("┃             ┗━━┛             ┃\n");
            System.out.printf("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛\n");


            Tools.pause(3);
            Tools.clear();


            System.out.printf("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓\n");
            System.out.printf("┃┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓┃\n");
            System.out.printf("┃┃                            ┃┃\n");
            System.out.printf("┃┃                            ┃┃\n");
            System.out.printf("┃┃                            ┃┃\n");
            System.out.printf("┃┃                            ┃┃\n");
            System.out.printf("┃┃                            ┃┃\n");
            System.out.printf("┃┃                            ┃┃\n");
            System.out.printf("┃┃           welcome!         ┃┃\n");
            System.out.printf("┃┃      name : %s",name);
            for(int i = 0; i < 15-name.length(); i++){
                System.out.printf(" ");
            }
            System.out.printf("┃┃\n");
            System.out.printf("┃┃                            ┃┃\n");
            System.out.printf("┃┃                            ┃┃\n");
            System.out.printf("┃┃                            ┃┃\n");
            System.out.printf("┃┃                            ┃┃\n");
            System.out.printf("┃┃                            ┃┃\n");
            System.out.printf("┃┃                            ┃┃\n");
            System.out.printf("┃┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛┃\n");
            System.out.printf("┃             ┏━━┓             ┃\n");
            System.out.printf("┃             ┗━━┛             ┃\n");
            System.out.printf("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛\n");
            Tools.pause(3);

            while(true) {
                Phone.mainPhone(); //함수가 종료되었을 때 mainPhone이 다시 호출되게 하기 위함
            }
        }
    }

    public static int mainPhone(){

        //연결 확인
        try{
            DriverManager.getConnection(DBsetting.url, DBsetting.username, DBsetting.password);
            signal = "○";
        } catch (SQLException e) {
            signal = "X";
        }
        //연결 확인


        Scanner in = new Scanner(System.in);
        Tools.clear(); //화면 초기화
        Tools.flush(); //입력버퍼 초기화
        String input = null; //사용자 입력값 저장

        System.out.printf("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓\n");
        System.out.printf("┃┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓      ┃\n");
        System.out.printf("┃┃ ┏━━━━┓     ┏━━━━┓     ┏━━━━┓                              signal: (%s) ┃      ┃\n", signal);
        System.out.printf("┃┃internet     msg       hotel                                           ┃      ┃\n");
        System.out.printf("┃┃ ┗━━━━┛     ┗━━━━┛     ┗━━━━┛                                          ┃      ┃\n");
        System.out.printf("┃┃                                                                       ┃      ┃\n");
        System.out.printf("┃┃                                                                       ┃      ┃\n");
        System.out.printf("┃┃                                                                       ┃┏━━━━┓┃\n");
        System.out.printf("┃┃                                                                       ┃┃home┃┃\n");
        System.out.printf("┃┃                                                                       ┃┗━━━━┛┃\n");
        System.out.printf("┃┃                                                                       ┃      ┃\n");
        System.out.printf("┃┃                                                                       ┃      ┃\n");
        System.out.printf("┃┃                                                                       ┃      ┃\n");
        System.out.printf("┃┃                                                                       ┃      ┃\n");
        System.out.printf("┃┃                                                                       ┃      ┃\n");
        System.out.printf("┃┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛      ┃\n");
        System.out.printf("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛\n");
        System.out.printf("=>:");
        input = in.nextLine();
        if(input.equals("home")){
            return 0;
        }
        else if(input.equals("internet")){
            internet.phoneInternet();
        }
        else if(input.equals("msg")){
            message.phoneMessage();
        }


        return 0;
    }
}
