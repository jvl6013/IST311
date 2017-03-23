/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taskcontactmanager;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LoginCtrl {
    List<String> userList = new ArrayList<String>();
       
    public LoginCtrl(){
    
    }
    
    public boolean authenticate(String userName){
        
        
        for(int i = 0; i < userList.size(); i++){
            if(userName.equals(userList.get(i))){
                return true;
            }
        }
        
        return false;
    }
    
    public void listUsers(){
        for(int i = 0; i < userList.size(); i++){
            System.out.println(userList.get(i));
        }
    }
    
    public void addUser(String userName){
        userList.add(userName);
    }
}
