package ist311;
import java.io.Serializable;
public class User implements Serializable{
    
    private String username = null;
    
    public User(String newUsername){
        username = newUsername;
    }
    
    public String getUsername(){
        return username;
    }
}
    
