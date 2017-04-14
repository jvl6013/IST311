package ist311;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class ContactCtrl {
    ContactUI con;
    AddContactPanel aCP;
      
    ContactCtrl(ContactUI con, AddContactPanel aCP)
    {
        this.aCP = aCP;
        this.con = con;
        
        

        
        aCP.addCancelListener(new CListener());
      

    }
    class CListener implements ActionListener
        {

            
            public void actionPerformed(ActionEvent ae) {
                con.back();
            }
        }

}
