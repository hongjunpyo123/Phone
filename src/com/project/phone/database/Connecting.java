package com.project.phone.database;

import com.project.phone.thred.ChatThread;
import com.project.phone.util.Tools;

import java.sql.*;

public class Connecting {
    private static Connecting connecting;
    private Connection connection;
    private PreparedStatement preparedStatement;

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

    public ResultSet query_1(String query, String parameter){
        try{
            this.preparedStatement = this.connection.prepareStatement(query);
            this.preparedStatement.setString(1, parameter);
            return this.preparedStatement.executeQuery();

        } catch (SQLException e) {
            return null;
        }
    }

    public void query_2(String query, String parameter_one, String parameter_two, String parameter_three){
        try{
            Statement statement = connection.createStatement();
            PreparedStatement pstmt = connection.prepareStatement(query);
            pstmt.setString(1, parameter_one);
           pstmt.setString(2, parameter_two);
           pstmt.setString(3, parameter_three);
           pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void query_1(String query, String parameter, String option){

        try{
            if(option.equals("delete")){
                this.preparedStatement = this.connection.prepareStatement(query);
                this.preparedStatement.setString(1, parameter);
                this.preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private void setConnection(Connection connection){
        this.connection = connection;
    }

    public Connection getConnection(){
        return this.connection;
    }
}
