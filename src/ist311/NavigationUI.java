package ist311;

import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class NavigationUI extends javax.swing.JFrame{
    public NavigationUI(){
        initComponents();
    }
    
    private void initComponents() {

        //Create and set up the window.
        JFrame frame = new JFrame("HelloWorldSwing");
        frame.setPreferredSize(new Dimension(500, 500));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   
        
        //Display the window.
        frame.pack();
        frame.setVisible(true);
        
        
    }
}
