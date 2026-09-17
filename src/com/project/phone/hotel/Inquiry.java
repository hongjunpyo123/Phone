package com.project.phone.hotel;

import com.project.phone.database.Connecting;
import com.project.phone.main.Phone;
import com.project.phone.util.Tools;

import java.sql.SQLException;
import java.util.Scanner;

public class Inquiry {
    private Scanner in = new Scanner(System.in);
    private static Inquiry inquiry;
    private Reservation reservation;
    private Connecting connecting;
    private Inquiry(Reservation reservation, Connecting connecting){
        this.connecting = connecting;
        this.reservation = reservation;
    }
    public boolean hotelInquiry(){
        this.DBhotelInquiry();

        Tools.flush();
        Tools.clear();

        for(int i = 0; i < reservation.getCnt(); i++){
            System.out.println("------------------------------------------------------------------");
            System.out.println("예약자 명 : " + reservation.getRoom().get(i).getName());
            System.out.println("예약 번호 : " + reservation.getRoom().get(i).getNumber());
            System.out.println("예약한 룸 : "+reservation.getRoom().get(i).roomName);
            System.out.println("예약 인원수 : "+reservation.getRoom().get(i).getPersons());
            System.out.println("입실 일자 : "+reservation.getRoom().get(i).getCheck_in_date()+"/"+reservation.getRoom().get(i).getCheck_in_time());
            System.out.println("이용 시간 : "+reservation.getRoom().get(i).getUsage_time());
            System.out.println("------------------------------------------------------------------");
        }
        System.out.print("[ENTER를 눌러주세요]");
        in.nextLine();
        return true;
    }


    public static Inquiry getInstance(Reservation reservation, Connecting connecting){
        if(inquiry == null){
            return inquiry = new Inquiry(reservation, connecting);
        }
        return inquiry;
    }

    private boolean DBhotelInquiry(){
        try{
            connecting.query("SELECT * FROM hotel WHERE number = ?", Phone.number, "select");
            reservation.getRoom().clear();
            reservation.setCnt(0);

            String persons;
            String check_in_date;
            String usage_time;
            String check_in_time;
            String houlyrate;
            String roomName;
            String name;
            String number;

            while(connecting.getQueryResult().next()){
                persons = connecting.getQueryResult().getString("persons");
                check_in_date = connecting.getQueryResult().getString("check_in_date");
                usage_time = connecting.getQueryResult().getString("usage_time");
                check_in_time = connecting.getQueryResult().getString("check_in_time");
                houlyrate = connecting.getQueryResult().getString("houlyrate");
                roomName = connecting.getQueryResult().getString("type");
                name = connecting.getQueryResult().getString("name");
                number = connecting.getQueryResult().getString("number");

                if(connecting.getQueryResult().getString("type").equals("StudyRoom")){
                    reservation.roomAdd(new StudyRoom(persons, check_in_date, usage_time, check_in_time, houlyrate, roomName, name, number));
                }
                else if(connecting.getQueryResult().getString("type").equals("MeetingRoom")){
                    reservation.roomAdd(new MeetingRoom(persons, check_in_date, usage_time, check_in_time, houlyrate, roomName, name, number));
                }
                else if(connecting.getQueryResult().getString("type").equals("GuestRoom")){
                    reservation.roomAdd(new GuestRoom(persons, check_in_date, usage_time, check_in_time, houlyrate, roomName, name, number));
                }

            }
            return true;
        } catch (SQLException e) {
            return false;
        }

    }
}
