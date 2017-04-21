/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ist311;

import java.util.ArrayList;
import javax.swing.*;


public class ContactPanel extends JPanel
{
    ArrayList <Contact> contactList;
    Contact  contact;
    JButton add;
    String name;
    ContactPanel(final ArrayList contacts)
    {
        this.contactList = contacts;
        for (int x = 0; x < contactList.size(); x++)
        {
            
            contact = this.contactList.get(x);
            name = contact.getName();
            JButton contactButt = new JButton(name);
            this.add(contactButt);
        }
        add = new JButton("Add Contact");
        this.add(add);
    }
    
    public JButton getButton()
    {
        return add;
    }
    public void addCon()
    {
        int newCon = (contactList.size() - 1);
        Contact dummy = contactList.get(newCon);
        JButton contact = new JButton(dummy.getName());
        add(contact);

    }
}
