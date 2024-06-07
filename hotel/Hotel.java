package com.project.phone.hotel;

import com.project.phone.util.Tools;

import java.util.Scanner;

public class Hotel {
    Scanner in = new Scanner(System.in);
    private static Hotel hotel;
    private Hotel() {}



    public int phoneHotel(){
        Tools.clear(); //화면 초기화
        Tools.flush(); //입력버퍼 초기화
        String input = null; //사용자 입력값 저장

        System.out.printf("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓\n");
        System.out.printf("┃┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓      ┃\n");
        System.out.printf("┃┃                                [ Hotel ]                              ┃      ┃\n");
        System.out.printf("┃┃                                                                       ┃      ┃\n");
        System.out.printf("┃┃                                                                       ┃      ┃\n");
        System.out.printf("┃┃                                                                       ┃      ┃\n");
        System.out.printf("┃┃        ┏━━━━━━━━━━━┓         ┏━━━━━━━━━━━┓         ┏━━━━━━━━━━━┓      ┃      ┃\n");
        System.out.printf("┃┃        ┃    [1]    ┃         ┃    [2]    ┃         ┃    [3]    ┃      ┃┏━━━━┓┃\n");
        System.out.printf("┃┃        ┃ StudyRoom ┃         ┃MeetingRoom┃         ┃ GuestRoom ┃      ┃┃home┃┃\n");
        System.out.printf("┃┃        ┗━━━━━━━━━━━┛         ┗━━━━━━━━━━━┛         ┗━━━━━━━━━━━┛      ┃┗━━━━┛┃\n");
        System.out.printf("┃┃                                                                       ┃      ┃\n");
        System.out.printf("┃┃                                                                       ┃      ┃\n");
        System.out.printf("┃┃                                                                       ┃      ┃\n");
        System.out.printf("┃┣━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┫      ┃\n");
        System.out.printf("┃┃ [0] : Reservation Inquiry                                             ┃      ┃\n");
        System.out.printf("┃┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛      ┃\n");
        System.out.printf("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛\n");
        System.out.printf("=>:");
        input = this.in.nextLine();
        if(input.equals("home")){
            return 0;
        }

        return 0;
    }

    public static Hotel getInstance(){
        if(Hotel.hotel == null){
            return hotel = new Hotel();
        }
        return hotel;
    }
}
