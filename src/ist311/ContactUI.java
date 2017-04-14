package ist311;

import javax.swing.*;
import java.awt.event.*;

public class ContactUI extends JFrame{
    JPanel panel;
    AddContactPanel aCP;
    ContactUI(AddContactPanel aCP)
    {
        
        setTitle("Contact Manager");
        this.setSize(500,600);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setResizable(false);
        makePanel();
        this.aCP = aCP;
        this.add(panel);
   
    }

    private void makeOthers()
    {
        
        this.aCP = new AddContactPanel();
    }
    private void buttonHit()
    {
        this.remove(panel);
        makeOthers();
        this.add(aCP);
        revalidate();
        
    }
    
    public void makePanel()
    {
        panel = new JPanel();
        JButton addContact = new JButton("add contact");
        addContact.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent ae)
            {
                buttonHit();
            }
             
        });
        panel.add(addContact);

    }
    
    public void back()
    {
        makePanel();
        if (aCP != null)
        {this.remove(aCP);}
        else
        {System.out.println("sdjofnwskldfnwef");}
        
        this.add(panel);
    }
}
