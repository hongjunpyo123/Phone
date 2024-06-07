package com.project.phone.hotel;

import com.project.phone.util.Tools;

import java.util.Scanner;

public class Hotel {
    Scanner in = new Scanner(System.in);
    private static Hotel hotel;
    private Reservation reservation = new Reservation(); //예약 객체 생성
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
        input = this.in.next();
        if(input.equals("home")){
            return 0;
        }
        else if(input.equals("1") || input.equals("2") || input.equals("3")){
            if(this.reservation.hotelReservation(input)){
                System.out.println("성공적으로 예약되었습니다.");
                Tools.pause(2);
                return 0;
            } else{
                System.out.println("예약에 실패하였습니다.");
                Tools.pause(2);
                return 0;
            }

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
