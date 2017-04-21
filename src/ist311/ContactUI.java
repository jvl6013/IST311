package ist311;
import javax.swing.*;
import java.awt.event.*;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class ContactUI extends JFrame{
    ContactPanel cP;
    AddContactPanel aCP;
    
    
    ContactUI(AddContactPanel aCP, ContactPanel cP)
    {
        
        setTitle("Contact Manager");
        this.setSize(500,600);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setResizable(false);
        this.aCP = aCP;
        this.cP = cP;
        this.add(cP);
        
   
    }
    
    public void addCPListener(ActionListener al)
    {
        cP.getButton().addActionListener(al);
    }
    
    public void addCancelListener(ActionListener al)
    {
        aCP.getCancel().addActionListener(al);
    }

    public void addSubmitListener(ActionListener al)
    {
        aCP.getSubmit().addActionListener(al);
    }
    
    
    public void addACP()
    {
        if (this.cP != null)
        {this.remove(cP);}
        this.add(aCP);
        repaint();
        revalidate();
    }

    public void addCP()
    {
        if (this.aCP != null)
        {this.remove(aCP);}
        cP.addCon();
        this.add(cP);
        repaint();
        revalidate();
    }
}
