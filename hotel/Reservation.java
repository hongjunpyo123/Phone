package com.project.phone.hotel;

import com.project.phone.database.Connecting;
import com.project.phone.main.Phone;
import com.project.phone.util.Tools;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Reservation {
    Scanner in = new Scanner(System.in);
    Connecting connecting = Connecting.getInstance();
    private String input;
    private int cnt;
    private int size;
    private List<Room> room;
    public Reservation(){
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
        System.out.print("예약 인원 : ");
        String persons = in.next();

        System.out.print("\n체크인 날짜(2024/00/00) : ");
        String check_in_date = in.next();
        Tools.flush(); //입력 버퍼 비우기 / 개행문자

        System.out.print("\n이용 시간(00:00) : ");
        String usage_time = in.next();
        Tools.flush(); //입력 버퍼 비우기 / 개행문자

        System.out.print("\n체크인 시간(00:00) : ");
        String check_in_time = in.next();

        if(type.equals("1")){//study room
            StudyRoom studyRoom = new StudyRoom(persons, check_in_date, usage_time, check_in_time, "2000");
            roomAdd(studyRoom);
            if(connecting.query("INSERT INTO hotel (name, number, persons, check_in_date, usage_time, check_in_time, type, houlyrate, today) " +
                            "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)",
                    Phone.name, Phone.number, persons, check_in_date, usage_time,check_in_time, "StudyRoom", studyRoom.getHourlyRate(), Phone.today.toString(),"insert"))
            {
                return true;
            } else{
                return false;
            }
        }
        else if(type.equals("2")){//meeting room
            MeetingRoom meetingRoom = new MeetingRoom(persons, check_in_date, usage_time, check_in_time, "3500");
            roomAdd(meetingRoom);
            if(connecting.query("INSERT INTO hotel (name, number, persons, check_in_date, usage_time, check_in_time, type, houlyrate, today) " +
                            "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)",
                    Phone.name, Phone.number, persons, check_in_date, usage_time,check_in_time, "MeetingRoom", meetingRoom.getHourlyRate(), Phone.today.toString(),"insert"))
            {
                return true;
            } else{
                return false;
            }
        }
        else if(type.equals("3")){//guest room
            GuestRoom guestRoom = new GuestRoom(persons, check_in_date, usage_time, check_in_time, "3500");
            roomAdd(guestRoom);
            if(connecting.query("INSERT INTO hotel (name, number, persons, check_in_date, usage_time, check_in_time, type, houlyrate, today) " +
                            "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)",
                    Phone.name, Phone.number, persons, check_in_date, usage_time,check_in_time, "GuestRoom", guestRoom.getHourlyRate(), Phone.today.toString(),"insert"))
            {
                return true;
            } else{
                return false;
            }
        }
        return false;
    }

    public int getCnt(){
        return this.cnt;
    }
}
