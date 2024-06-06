package com.project.phone.database;

import com.project.phone.thred.ChatThread;
import com.project.phone.util.Tools;

import java.sql.*;

public class Connecting {
    private static Connecting connecting;
    private Connection connection;
    private PreparedStatement preparedStatement;
    private ResultSet queryResult;

    private Connecting() {}

    public static Connecting getInstance(){
        if(connecting == null){
            connecting = new Connecting();
        }
        return connecting;
    }

    public boolean DBconnect(){
        try{
            System.out.println("(connecting...)");
            Connection connection = DriverManager.getConnection(DBsetting.url, DBsetting.username, DBsetting.password);
            System.out.println("(succ)");
            Tools.pause(1);
            this.setConnection(connection);
            return true;
        } catch (SQLException e) {
            ChatThread.optionThread("stop");
            System.out.println("(fail)");
            Tools.pause(2);
            return false;
        }
    }
    //query 처리 메서드
    public void query(String query, String parameter, String option){
        try{
            if(option.equals("delete") || option.equals("insert")){
                Statement statement = connection.createStatement();
                this.preparedStatement = this.connection.prepareStatement(query);
                this.preparedStatement.setString(1, parameter);
                this.preparedStatement.executeUpdate();
            } else{ //return type
                this.preparedStatement = this.connection.prepareStatement(query);
                this.preparedStatement.setString(1, parameter);
                this.queryResult = this.preparedStatement.executeQuery();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void query(String query, String parameter, String parameter_two, String option){
        try{
            if(option.equals("delete") || option.equals("insert")){
                Statement statement = connection.createStatement();
                this.preparedStatement = this.connection.prepareStatement(query);
                this.preparedStatement.setString(1, parameter);
                this.preparedStatement.setString(2, parameter_two);
                this.preparedStatement.executeUpdate();
            }else{ //return type
                this.preparedStatement = this.connection.prepareStatement(query);
                this.preparedStatement.setString(1, parameter);
                this.preparedStatement.setString(2, parameter_two);
                this.queryResult =  this.preparedStatement.executeQuery();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void query(String query, String parameter, String parameter_two, String parameter_three, String option){
        try{
            if(option.equals("delete") || option.equals("insert")){
                Statement statement = connection.createStatement();
                this.preparedStatement = this.connection.prepareStatement(query);
                this.preparedStatement.setString(1, parameter);
                this.preparedStatement.setString(2, parameter_two);
                this.preparedStatement.setString(3, parameter_three);
                this.preparedStatement.executeUpdate();
            }else{ //return type
                this.preparedStatement = this.connection.prepareStatement(query);
                this.preparedStatement.setString(1, parameter);
                this.preparedStatement.setString(2, parameter_two);
                this.preparedStatement.setString(3, parameter_three);
                this.queryResult =  this.preparedStatement.executeQuery();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    //query 처리 메서드


    private void setConnection(Connection connection){
        this.connection = connection;
    }

    public Connection getConnection(){
        return this.connection;
    }

    public ResultSet getQueryResult(){
        return this.queryResult;
    }










}
