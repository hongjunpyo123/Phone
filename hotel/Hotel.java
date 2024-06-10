package com.project.phone.hotel;

import com.project.phone.database.Connecting;
import com.project.phone.main.Phone;
import com.project.phone.util.Tools;

import java.util.Scanner;

public class Hotel {
    Scanner in = new Scanner(System.in);
    private static Hotel hotel;
    private Reservation reservation = Reservation.getInstance(); //예약 객체 생성
    private Connecting connecting = Connecting.getInstance(); //db연결 객체 생성
    private Inquiry inquiry = Inquiry.getInstance(reservation, connecting); //생성자 의존성 주입

    private Hotel() {}



    public int phoneHotel(){

        Tools.clear(); //화면 초기화
        Tools.flush(); //입력버퍼 초기화
        String input = null; //사용자 입력값 저장


        System.out.printf("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓\n");
        System.out.printf("┃┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓      ┃\n");
        System.out.printf("┃┃                               [ Yanolja ]                             ┃      ┃\n");
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
        if(!Phone.getSignal()){
            System.out.println("연결 상태를 확인해주세요.");
            Tools.pause(2);
            return 0;
        }
        if(input.equals("home")){ //돌아가기
            return 0;
        }
        else if(input.equals("1") || input.equals("2") || input.equals("3")){ //호텔예약
            if(this.reservation.hotelReservation(input)){
                System.out.println("예약 정보를 전송하였습니다.");
                Tools.pause(2);
                return 0;
            } else{
                System.out.println("얘약 정보 전송에 실패하였습니다.");
                Tools.pause(2);
                return 0;
            }

        }
        else if(input.equals("0")){ //예약조회
            inquiry.hotelInquiry();
        }

        else{
            System.out.println("정상적인 값이 아닙니다. \n([1] or [2] or [3] or [0] or [home]) ");
            Tools.pause(3);
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
