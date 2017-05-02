package ist311;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class NavigationUI extends javax.swing.JFrame{
    String username;
    public NavigationUI(String username){
        this.username = username;
        initComponents();
    }
    
    private void initComponents() {

        //Create and set up the window.
        JFrame frame = new JFrame("Navigation UI");
        frame.setPreferredSize(new Dimension(300, 400));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   

        JPanel navPanel = new JPanel();
        navPanel.setLayout(new GridLayout(3, 1));

        JButton uc1Button = new JButton("Calendar");
        uc1Button.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                CalUI cal = new CalUI(username);
            }
        });
        JButton uc2Button = new JButton("Contact List");
        uc2Button.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                ContactListUI cl = new ContactListUI(username);
            }
        });
        JButton uc3Button = new JButton("Task List");
        uc3Button.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                TaskListUI tl = new TaskListUI(username);
            }
        });

        navPanel.add(uc1Button);
        navPanel.add(uc2Button);
        navPanel.add(uc3Button);

        frame.add(navPanel);


        //Display the window.
        frame.pack();
        frame.setVisible(true);
        
        
    }
}
