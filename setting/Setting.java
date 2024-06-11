package com.project.phone.setting;

import com.project.phone.database.DBsetting;
import com.project.phone.file.FileIO;
import com.project.phone.util.Tools;

import java.util.Scanner;

public class Setting {
    private static Setting setting;
    private FileIO fileIO;
    private Scanner in = new Scanner(System.in);
    private Setting(FileIO fileIO){
        this.fileIO = fileIO;
    }
    public int settingView(){
        Tools.clear();
        Tools.flush();

        fileIO.FileRead("setting.txt");
        String input = null; //사용자 입력값 저장


        System.out.printf("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓\n");
        System.out.printf("┃┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓      ┃\n");
        System.out.printf("┃┃                               [ Setting ]                             ┃      ┃\n");
        System.out.printf("┃┃  [DB setting]                                                         ┃      ┃\n");

        System.out.printf("┃┃   url : %s", DBsetting.url);
        for(int i = 0; i < 62-DBsetting.url.length(); i++){
            System.out.printf(" ");
        }
        System.out.printf("┃      ┃\n");

        System.out.printf("┃┃   username : %s", DBsetting.username);
        for(int i = 0; i < 57-DBsetting.username.length(); i++){
            System.out.printf(" ");
        }
        System.out.printf("┃      ┃\n");


        System.out.printf("┃┃   password : %s", DBsetting.password);
        for(int i = 0; i < 57-DBsetting.password.length(); i++){
            System.out.printf(" ");
        }
        System.out.printf("┃      ┃\n");


        System.out.printf("┃┃                                                                       ┃┏━━━━┓┃\n");
        System.out.printf("┃┃                                                                       ┃┃home┃┃\n");
        System.out.printf("┃┃                                                                       ┃┗━━━━┛┃\n");
        System.out.printf("┃┃                                                                       ┃      ┃\n");
        System.out.printf("┃┃                                                                       ┃      ┃\n");
        System.out.printf("┃┃                                                                       ┃      ┃\n");
        System.out.printf("┃┣━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┫      ┃\n");
        System.out.printf("┃┃ [0] :                                                                 ┃      ┃\n");
        System.out.printf("┃┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛      ┃\n");
        System.out.printf("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛\n");
        System.out.printf("=>:");
        input = this.in.next();
        if(input.equals("home")){
            return 0;
        }
        return 0;

    }


    public static Setting getInstance(FileIO fileIO){
        if(setting == null){
            return setting = new Setting(fileIO);
        }
        return setting;
    }
}
