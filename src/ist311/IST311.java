/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ist311;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


public class Sandbox {

  
    public static void main(String[] args) {
        LoginCtrl lc1 = new LoginCtrl();
        LoginUI theLoginUI = new LoginUI();
        lc1.addUser("asdfasdf");
        System.out.println(lc1.authenticate("jvl6012"));
    }

    
    
}   

    //tedst comment
    
}
