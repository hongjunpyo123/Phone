package com.project.phone.hotel;

import com.project.phone.database.Connecting;
import com.project.phone.main.Phone;
import com.project.phone.util.Tools;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Reservation {
    Scanner in = new Scanner(System.in);
    static Reservation reservation;
    Connecting connecting = Connecting.getInstance();
    private String input;
    private int cnt;
    private List<Room> room;
    private Reservation(){
        this.cnt = 0;
        room = new ArrayList<>();
    }
    public boolean roomAdd(Room room){
        if(room != null){
            cnt += 1;
            this.room.add(room);
            return true;
        }else{
            return false;
        }

    }
    public boolean hotelReservation(String type){
        System.out.print("예약 인원(ex> 10) : ");
        String persons = in.next();

        System.out.print("\n체크인 날짜(ex> 24/00/00) : ");
        String check_in_date = in.next();
        Tools.flush(); //입력 버퍼 비우기 / 개행문자

        System.out.print("\n이용 시간(ex> 4) : ");
        String usage_time = in.next();
        Tools.flush(); //입력 버퍼 비우기 / 개행문자

        System.out.print("\n체크인 시간(ex> 00:00) : ");
        String check_in_time = in.next();

        if(type.equals("1")){//study room
            if(connecting.query("INSERT INTO hotel (name, number, persons, check_in_date, usage_time, check_in_time, type, houlyrate, today) " +
                            "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)",
                    Phone.name, Phone.number, persons, check_in_date, usage_time,check_in_time, "StudyRoom", "2000", Phone.today.toString(),"insert"))
            {
                return true;
            } else{
                return false;
            }
        }
        else if(type.equals("2")){//meeting room
            if(connecting.query("INSERT INTO hotel (name, number, persons, check_in_date, usage_time, check_in_time, type, houlyrate, today) " +
                            "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)",
                    Phone.name, Phone.number, persons, check_in_date, usage_time,check_in_time, "MeetingRoom", "3500", Phone.today.toString(),"insert"))
            {
                return true;
            } else{
                return false;
            }
        }
        else if(type.equals("3")){//guest room
            if(connecting.query("INSERT INTO hotel (name, number, persons, check_in_date, usage_time, check_in_time, type, houlyrate, today) " +
                            "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)",
                    Phone.name, Phone.number, persons, check_in_date, usage_time,check_in_time, "GuestRoom", "4000", Phone.today.toString(),"insert"))
            {
                return true;
            } else{
                return false;
            }
        }
        return false;
    }
    public static Reservation getInstance(){
        if(reservation == null){
            return reservation = new Reservation();
        }
        return reservation;
    }

    public int getCnt(){
        return this.cnt;
    }

    public List<Room> getRoom(){
        return this.room;
    }

    public void setCnt(int cnt){
        this.cnt = cnt;
    }
}
