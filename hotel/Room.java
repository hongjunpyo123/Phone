package com.project.phone.hotel;

public abstract class Room {
    protected String name;
    protected String number;
    protected String roomName;
    protected String persons; //예약 인원수
    protected String check_in_time;
    protected String check_in_date;
    protected int usage_time;

    protected String hourlyRate; //시간당 금액

    public String getPersons(){
        return this.persons;
    }

    public String getCheck_in_time(){
        return this.check_in_time;
    }

    public String getCheck_in_date(){
        return this.check_in_date;
    }

    public int getUsage_time(){
        return this.usage_time;
    }

    public String getHourlyRate() {
        return this.hourlyRate;
    }

    public String getName() { return this.name; }

    public String getNumber() { return this.number; }

}
