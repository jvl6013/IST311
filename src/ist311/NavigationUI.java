package ist311;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class NavigationUI extends javax.swing.JFrame{
    public NavigationUI(){
        initComponents();
    }
    
    private void initComponents() {

        //Create and set up the window.
        JFrame frame = new JFrame("Navigation UI");
        frame.setPreferredSize(new Dimension(300, 500));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   

        JPanel navPanel = new JPanel();
        navPanel.setLayout(new GridLayout(4, 1));

        JButton uc1Button = new JButton("Calendar");
        uc1Button.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                CalUI2 cal = new CalUI2();
            }
        });
        JButton uc2Button = new JButton("Contact List (NOT IMPLEMENTED)");
        JButton uc3Button = new JButton("Task List");
        uc3Button.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                TaskListUI tl = new TaskListUI();
            }
        });
        JButton uc4Button = new JButton("Search Contact (NOT IMPLEMENTED");

        navPanel.add(uc1Button);
        navPanel.add(uc2Button);
        navPanel.add(uc3Button);
        navPanel.add(uc4Button);

        frame.add(navPanel);


        //Display the window.
        frame.pack();
        frame.setVisible(true);
        
        
    }
}
