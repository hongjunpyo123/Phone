package com.project.phone.main;

import com.project.phone.bank.Bank;
import com.project.phone.database.Connecting;
import com.project.phone.file.FileIO;
import com.project.phone.hotel.Hotel;
import com.project.phone.internet.Internet;
import com.project.phone.message.Message;
import com.project.phone.setting.Setting;
import com.project.phone.util.Tools;

import java.time.LocalDate;
import java.util.Scanner;
public class Phone {
    public static Internet internet = Internet.getInstance();
    public static Message message = Message.getInstance();
    public static Connecting connecting = Connecting.getInstance();
    public static Hotel hotel = Hotel.getInstance();
    public static FileIO fileIO = FileIO.getInstance();
    public static Bank bank = Bank.getInstance();
    public static LocalDate today = LocalDate.now();
    public static Setting setting = Setting.getInstance(fileIO);

    public static String name;
    public static String number;
    public static String model;

    private static boolean signal = false; //db연결 유무 초기값
    private static String signal_text = "X"; //db연결 유무 표시 문자
    private static boolean re_start = false;


    private Phone() { }

    public static void main(String[] args) {


        String model;
        String name;
        String number;

        Scanner in = new Scanner(System.in);
        while (true) {
            Tools.clear();
            System.out.println("** 휴대폰 생성 페이지 **");

            System.out.print("모델명을 입력해주세요(영문, 숫자) : ");
            model = in.next();
            if (!model.matches("^[a-zA-Z0-9]*$")){ //영문인지 검사
                System.out.println("\n모델명이 유효하지 않습니다 다시 입력하세요!");
                Tools.pause(2);
                continue;
            }

            System.out.print("사용자 이름을 입력해주세요(영문, 숫자) : ");
            name = in.next();
            if (!name.matches("^[a-zA-Z0-9]*$")){ //영문인지 검사
                System.out.println("\n이름이 유효하지 않습니다 다시 입력하세요!");
                Tools.pause(2);
                continue;
            }


            System.out.print("사용할 " +
                    "전화번호를 입력해주세요(11글자, -제외) : ");
            number = in.next();
            if (number.length() != 11) { //전화번호 길이 검사
                System.out.println("\n전화번호가 유효하지 않습니다 다시 입력하세요!");
                Tools.pause(2);
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

            while(!re_start) {
                Phone.mainPhone(); //함수가 종료되었을 때 mainPhone이 다시 호출되게 하기 위함
            }
            re_start = false;
            break;
        }
    }

    public static int mainPhone(){
        //설정 파일 생성
        fileIO.createFile("setting.txt");//setting파일 생성
        fileIO.FileRead("setting.txt"); //setting파일을 읽어온 후 변수에 저장

        //db 연결 확인
        if(connecting.DBconnect()){
            signal = true;
            signal_text = "○";
        }else{
            signal = false;
            signal_text = "X";
        }




        Scanner in = new Scanner(System.in);
        Tools.clear(); //화면 초기화
        Tools.flush(); //입력버퍼 초기화
        String input = null; //사용자 입력값 저장

        System.out.printf("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓\n");
        System.out.printf("┃┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓      ┃\n");
        System.out.printf("┃┃ ┏━━━━┓     ┏━━━━┓     ┏━━━━┓     ┏━━━━┓                   signal: (%s) ┃      ┃\n", signal_text);
        System.out.printf("┃┃internet    message    yanolja    setting                              ┃      ┃\n");
        System.out.printf("┃┃ ┗━━━━┛     ┗━━━━┛     ┗━━━━┛     ┗━━━━┛                               ┃      ┃\n");
        System.out.printf("┃┃                                                                       ┃      ┃\n");
        System.out.printf("┃┃                                                                       ┃      ┃\n");
        System.out.printf("┃┃ ┏━━━━┓     ┏━━━━┓                                                     ┃┏━━━━┓┃\n");
        System.out.printf("┃┃  bank       game                                                      ┃┃home┃┃\n");
        System.out.printf("┃┃ ┗━━━━┛     ┗━━━━┛                                                     ┃┗━━━━┛┃\n");
        System.out.printf("┃┃                                                                       ┃      ┃\n");
        System.out.printf("┃┃                                                                       ┃      ┃\n");
        System.out.printf("┃┃                                                                       ┃      ┃\n");
        System.out.printf("┃┃                                                   [1] : re-connecting ┃      ┃\n");
        System.out.printf("┃┃                                                   [0] : reset         ┃      ┃\n");
        System.out.printf("┃┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛      ┃\n");
        System.out.printf("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛\n");
        System.out.printf("=>:");
        input = in.nextLine();
        if(input.equals("home")){
            return 0;
        }
        else if(input.equals("0")){
            System.out.println("휴대폰을 재시작합니다.");
            Tools.pause(2);
            re_start = true;
            return 0;
        }
        else if(input.equals("internet")){
            internet.phoneInternet();
        }
        else if(input.equals("message")){
            message.phoneMessage();
        }
        else if(input.equals("yanolja")){
            hotel.phoneHotel();
        }
        else if(input.equals("setting")){
            setting.settingView();
        }
        else if(input.equals("bank")){
            bank.phoneBank();
        }
        else if(input.equals("game")){

        }


        return 0;
    }

    public static boolean getSignal(){ //db연결 유무 반환 메서드
        return Phone.signal;
    }
}
