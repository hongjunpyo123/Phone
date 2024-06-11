package com.project.phone.file;

import com.project.phone.database.DBsetting;
import com.project.phone.util.Tools;

import java.io.*;

public class FileIO {
    private String settingPath;
    private String folderName = "data";
    private static FileIO fileIO;



    private FileIO(){ }
    public boolean createFile(String txtfilename){
        this.settingPath = "data/"+txtfilename;
        File data = new File(folderName);
        if(data.mkdir()) {
            System.out.println(this.folderName+" 폴더 생성 완료");
            Tools.pause(1);
        }else{
            Tools.pause(1);
            return false;
        }

        try{
            FileWriter writer = new FileWriter(settingPath); //setting파일 생성
            writer.write("------------DB setting---------------\n");
            writer.write("url:jdbc:mysql://localhost:3306/phone\n");
            writer.write("username:root\n");
            writer.write("password:\n");
            writer.write("-------------------------------------\n");
            writer.close();
            System.out.println("파일 생성 완료");
            Tools.pause(2);
            return true;
        } catch (IOException e) {
            Tools.pause(2);
            return false;
        }
    }
    public boolean FileRead(String readtextfile){
        String str;
        int index;
        try{
            BufferedReader reader = new BufferedReader(
                    new FileReader("data/"+readtextfile)
            );
            while((str = reader.readLine()) != null){

                index = str.indexOf("url:");
                if(index != -1){
                    DBsetting.setUrl(str.substring(index + "url:".length()));
                }else{}

                index = str.indexOf("username:");
                if(index != -1){
                    DBsetting.setUsername(str.substring(index + "username:".length()));
                }else{}

                index = str.indexOf("password:");
                if(index != -1){
                    DBsetting.setPassword(str.substring(index + "password:".length()));
                }else{}

            }
            reader.close();

            return true;
        } catch (FileNotFoundException e) {
           return false;
        } catch (IOException e) {
            return false;
        }
    }

    public static FileIO getInstance(){
        if(fileIO == null){
            return fileIO = new FileIO();
        }
        return fileIO;
    }
}
