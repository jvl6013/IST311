/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taskorganizer;

/**
 *
 * @author coyne
 */
public class User {
      private String username = null;
    private char[] password = null;
    
    public User(String newUsername, char[] newPassword){
    
        username = newUsername;
        password = newPassword;}
    
    public String getUsername(){
    
        return username;}
    
    public char[] getPassword(){
    
        return password;}
    
}
