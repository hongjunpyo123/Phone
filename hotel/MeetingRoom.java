package com.project.phone.hotel;

public class MeetingRoom extends Room{
    public MeetingRoom(String persons, String check_in_date, String usage_time, String check_in_time, String hourlyRate, String roomName, String name, String number){
        this.persons = persons;
        this.hourlyRate = hourlyRate;
        this.roomName = roomName;
        this.check_in_date = check_in_date;
        this.check_in_time = check_in_time;
        this.usage_time = Integer.parseInt(usage_time);
        this.name = name;
        this.number = number;
    }
}
