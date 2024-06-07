package com.project.phone.hotel;

public class MeetingRoom extends Room{
    public MeetingRoom(String persons, String check_in_date, String usage_time, String check_in_time, String hourlyRate){
        this.persons = persons;
        this.hourlyRate = hourlyRate;
    }
    public String getHourlyRate() {
        return this.hourlyRate;
    }
}
