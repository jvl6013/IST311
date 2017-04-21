package ist311;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.io.*;
import java.util.Scanner;


public class ContactCtrl {
    ContactUI con;
    AddContactPanel aCP;
    ContactPanel cP;
    ArrayList <Contact> contacts; 
    ContactCtrl()
    {
        
        contacts = new ArrayList<Contact>();
        readContacts();
        aCP = new AddContactPanel();
        cP = new ContactPanel(contacts);
        
        con = new ContactUI(aCP, cP);
        con.setVisible(true);
        
        con.addCPListener(new ContactListener());
        con.addCancelListener(new CancelListener());
        con.addSubmitListener(new SubmitListener());

        
    }
    
        class ContactListener implements ActionListener
        {
            public void actionPerformed(ActionEvent e)
            {
                con.addACP();
            }
        }

        class SubmitListener implements ActionListener
        {
            public void actionPerformed(ActionEvent e)
            {
                saveContact();
                con.addCP();
            }
        }
        class CancelListener implements ActionListener
        {
            public void actionPerformed(ActionEvent e)
            {
                con.addCP();
            }
        }
        
        public void saveContact()
        {
            Contact contact = new Contact(aCP.fNameField.getText());
            contacts.add(contact);
            try 
            {
                FileOutputStream fOutput = new FileOutputStream("src\\ist311\\contact.txt");
                PrintWriter outF = new PrintWriter(fOutput);
                
                for (int y = 0; y < contacts.size(); y++)
                {
                    contact = contacts.get(y);
                    outF.println(contact.getName());
                }//for
                System.out.println("Success!");
                outF.flush();
            }//try
            catch (IOException oFail)
            {
                System.out.println("ERROR! FILE (contact.txt) NOT FOUND");
            }//catch
        }
        
        public void readContacts()
        {
        try 
        {
            FileInputStream fInput = new FileInputStream ("src\\ist311\\contact.txt");
            Scanner fI = new Scanner(fInput);
            while (fI.hasNextLine())                
            {
                Contact contact = new Contact(fI.nextLine());
                contacts.add(contact);
            }
            fInput.close();
            System.out.println("Read successful!");

        }//try
        catch(IOException inFail)
        {
            System.out.println("ERROR! FILE (contact.txt) NOT FOUND");
        }//catch
        }

}
