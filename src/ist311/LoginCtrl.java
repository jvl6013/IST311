/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ist311;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LoginCtrl {
    String fileName = "\\\\up.ist.local\\Users\\jvl6013\\Documents\\NetBeansProjects\\IST311\\src\\ist311\\userList.txt";
    File userList = new File(fileName);
        
    public LoginCtrl(){
    
    }
    
    public boolean authenticate(String userName){
        List<String> list = new ArrayList<String>();
        
        try{
            FileReader fileReader = new FileReader(userList);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String str;
            while ((str = bufferedReader.readLine()) != null) {
                list.add(str);
            }
        }
        catch(IOException ex){
            System.out.println("Error: Unable to read");
        }
        
        for(int i = 0; i < list.size(); i++){
            if(userName.equals(list.get(i))){
                return true;
            }
        }
        
        return false;
    }
    
    public void addUser(String userName){
        try{
            FileWriter fileWriter = new FileWriter(userList, true);
            
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(userName);
            bufferedWriter.newLine();
            
            bufferedWriter.close();
            fileWriter.close();
   
        }
        catch(IOException ex){
            System.out.println("Error: Unable to write");
        }
    }

  public  boolean requestAuthenticate(String username, char[] password) {
         List<String> list = new ArrayList<String>();
        
        try{
            FileReader fileReader = new FileReader(userList);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String str;
            while ((str = bufferedReader.readLine()) != null) {
                list.add(str);
            }
        }
        catch(IOException ex){
            System.out.println("Error: Unable to read");
        }
        
        for(int i = 0; i < list.size(); i++){
            if(fileName.equals(list.get(i))){
                return true;
            }
        }
        
        return false;
    }

    
    }

 

   

