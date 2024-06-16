package com.project.phone.util;

import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.util.Random;
import java.util.Scanner;

public class Tools {
    private static Random random = new Random();
    private static Runtime runtime = Runtime.getRuntime();
    private static Process process;

    private static int[] randNumber;
    private Tools() {}

    public static void clear(){
        for(int i = 0; i < 80 ; i++){
            System.out.println("");
        }
    }

    public static void pause(int second){
        try{
            Thread.sleep(second*1000);
        } catch (InterruptedException e) {
//            System.out.println("pause메서드 Exeption 발생");
        }
    }

    public static void flush(Scanner scanner){
        try {
            while (System.in.available() > 0) {
                System.in.read();
            }
            scanner = new Scanner(System.in);
        } catch (IOException e) {
//            System.out.println("flush메서드 Exeption 발생");
            throw new RuntimeException(e);
        }
    }

    public static void flush(){
        try {
            while (System.in.available() > 0) {
                System.in.read();
            }
        } catch (IOException e) {
//            System.out.println("flush메서드 Exeption 발생");
            throw new RuntimeException(e);
        }
    }

    public static void connectURL(String url){
        try{
            Desktop.getDesktop().browse(new URI(url));
        }catch(Exception e) {
//            System.out.println("connectURL메서드 Exeption 발생");
        }
    }

    public static boolean runFile(String path){
        try{
            process = runtime.exec("cmd /c start data/"+path); //윈도우 전용 함수, os종속 문제(?) / setting.txt파일 실행
            process.waitFor();
            return true;
        } catch (IOException e) {
            return false;
        } catch (InterruptedException e) {
            return false;
        }
    }

    public static int intLength(int myInt){
        return Integer.toString(myInt).length();
    }

    public static void set_uniqueRandArray(int count){
        if(count > 10){
            count = 10;
        }

        ;boolean[] randomCheck = new boolean[10];
        int[] randomNumber = new int[count];

        for(int i = 0; i < 10; i++){
            randomCheck[i] = false;
        }


        for(int i = 0; i < count; i++){
            randomNumber[i] = random.nextInt(10);
            if(randomCheck[randomNumber[i]]){
                i--;
            }
            else{
                randomCheck[randomNumber[i]] = true;
            }
        }

        randNumber = randomNumber;

    }

    public static int[] get_uniqueRandArray(){
        return randNumber;
    }

}
