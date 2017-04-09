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

/**
 *
 * @author jvl6013
 */
public class IST311 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        LoginCtrl lct = new LoginCtrl();
        lct.addUser("Owen");
        lct.addUser("Jerry");

        LoginUI theLoginUI = new LoginUI(lct);
        theLoginUI.setVisible(true);
           
    }   
}
