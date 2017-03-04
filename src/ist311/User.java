package ist311;
import java.io.Serializable;
public class User implements Serializable{
    private String username = null;
    private char[] password = null;
    public User(String newUsername, char[] newPassword){
        username = newUsername;
        password = newPassword;}
    public String getUsername(){
        return username;}
    public char[] getPassword(){
        return password;}}
