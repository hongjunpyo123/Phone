package com.project.phone.database;

public class DBsetting {
    private DBsetting(){ }
    public static String url;
    public static String username;
    public static String password;

    public static void setUrl(String url){
        DBsetting.url = url;
    }

    public static void setUsername(String username){
        DBsetting.username = username;
    }

    public static void setPassword(String password){
        DBsetting.password = password;
    }
}
