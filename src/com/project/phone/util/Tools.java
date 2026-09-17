package com.project.phone.util;

import java.awt.*;
import java.io.IOException;
import java.net.URI;

public class Tools {
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
        }
    }

    public static void flush(){
        try {
            while (System.in.available() > 0) {
                System.in.read();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void connectURL(String url){
        try{
            Desktop.getDesktop().browse(new URI(url));
        }catch(Exception e) {
        }
    }


}
