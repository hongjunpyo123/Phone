package com.project.phone.hotel;

public class GuestRoom extends Room{
    public GuestRoom(String persons, String check_in_date, String usage_time, String check_in_time, String hourlyRate){
        this.persons = persons;
        this.hourlyRate = hourlyRate;
    }

    public String getHourlyRate() {
        return this.hourlyRate;
    }
}
