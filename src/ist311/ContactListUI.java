/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ist311;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListCellRenderer;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author jvl6013
 */
public class ContactListUI {
    ContactListCtrl clc = new ContactListCtrl();
    DefaultListModel<Contact> model = new DefaultListModel<Contact>();
    JList<Contact> contactJList;

    public ContactListUI(){
        clc.addContact("Owen", "Lee", "1234 testing drive", "State College",
                "16802", "1234567890", "testing@testing.com");

        for(Contact c:clc.getContactList()){
            model.addElement(c);
        }

        initComp();
    }

    private void initComp() {
        JButton addContactButton = new JButton("Add");
        JButton deleteContactButton = new JButton("Delete");
        JButton editContactButton = new JButton("Edit");

        JLabel firstNameL = new JLabel("First Name: ");
        JLabel lastNameL = new JLabel("Last Name: ");
        JLabel stAddressL = new JLabel("Street Address: ");
        JLabel cityL = new JLabel("City: ");
        JLabel zipCodeL = new JLabel("Zip Code: ");
        JLabel phoneNumberL = new JLabel("Phone Nubmer: ");
        JLabel emailL = new JLabel("Email: ");

        JTextField firstName = new JTextField();
        firstName.setPreferredSize(new Dimension(500, 20));
        firstName.setMaximumSize(firstName.getPreferredSize());

        JTextField lastName = new JTextField();
        lastName.setPreferredSize(new Dimension(500, 20));
        lastName.setMaximumSize(lastName.getPreferredSize());

        JTextField stAddress = new JTextField();
        stAddress.setPreferredSize(new Dimension(500, 20));
        stAddress.setMaximumSize(stAddress.getPreferredSize());

        JTextField city = new JTextField();
        city.setPreferredSize(new Dimension(500, 20));
        city.setMaximumSize(city.getPreferredSize());

        JTextField zipCode = new JTextField();
        zipCode.setPreferredSize(new Dimension(500, 20));
        zipCode.setMaximumSize(zipCode.getPreferredSize());

        JTextField phoneNumber = new JTextField();
        phoneNumber.setPreferredSize(new Dimension(500, 20));
        phoneNumber.setMaximumSize(phoneNumber.getPreferredSize());

        JTextField email = new JTextField();
        email.setPreferredSize(new Dimension(500, 20));
        email.setMaximumSize(email.getPreferredSize());

        addContactButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                Contact c = new Contact(firstName.getText(), lastName.getText(), stAddress.getText(), city.getText(), zipCode.getText(), phoneNumber.getText(), email.getText());
                clc.addContact(c);
                model.addElement(c);
                contactJList.revalidate();
            }
        });

        deleteContactButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                DefaultListModel model = (DefaultListModel) contactJList.getModel();
                int selectedIndex = contactJList.getSelectedIndex();
                if (selectedIndex != -1) {
                    model.remove(selectedIndex);
                    clc.deleteContact(selectedIndex);
                    contactJList.revalidate();
                }
            }
        });

        editContactButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                DefaultListModel model = (DefaultListModel) contactJList.getModel();
                int selectedIndex = contactJList.getSelectedIndex();
                if (selectedIndex != -1) {
                    clc.setContact(selectedIndex, firstName.getText(), lastName.getText(), stAddress.getText(), city.getText(), zipCode.getText(), phoneNumber.getText(), email.getText());
                    contactJList.revalidate();
                    contactJList.repaint();
                }
            }
        });

        JFrame frame = new JFrame("Contact List");
        frame.setPreferredSize(new Dimension(600, 500));

        JPanel panel = new JPanel();
        JPanel listPanel = new JPanel();
        JPanel displayPanel = new JPanel();

        contactJList = new JList(model);

        contactJList.setCellRenderer(new ContactRenderer());
        contactJList.setVisibleRowCount(-1);

        ListSelectionModel listSelectionModel;
        listSelectionModel = contactJList.getSelectionModel();

        ListSelectionListener listSelectionListener = new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent listSelectionEvent) {
                JList list = (JList) listSelectionEvent.getSource();
                int selections[] = list.getSelectedIndices();
                for (int i = 0, n = selections.length; i < n; i++) {
                    firstName.setText(contactJList.getModel().getElementAt(selections[i]).firstName);
                    lastName.setText(contactJList.getModel().getElementAt(selections[i]).lastName);
                    stAddress.setText(clc.getContactList().get(selections[i]).stAddress);
                    city.setText(contactJList.getModel().getElementAt(selections[i]).city);
                    zipCode.setText(clc.getContactList().get(selections[i]).zipCode);
                    phoneNumber.setText(contactJList.getModel().getElementAt(selections[i]).phoneNumber);
                    email.setText(contactJList.getModel().getElementAt(selections[i]).email);
                }
            }
        };
        contactJList.addListSelectionListener(listSelectionListener);

        JScrollPane pane = new JScrollPane(contactJList);
        pane.setPreferredSize(new Dimension(250,400));



        JTextField searchBar = new JTextField();
        searchBar.setPreferredSize(new Dimension(180, 20));
        JButton searchButton = new JButton("Search");
        searchButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                List<Contact> searchedList = new ArrayList<Contact>();

                String searchTerm;
                searchTerm = searchBar.getText();
                searchedList = clc.searchContact(searchTerm);

                model.clear();

                for(Contact c:searchedList){
                    model.addElement(c);
                }

                contactJList.revalidate();
            }
        });

        listPanel.add(searchBar);
        listPanel.add(searchButton);
        listPanel.add(pane);
        listPanel.add(addContactButton);
        listPanel.add(deleteContactButton);
        listPanel.add(editContactButton);

        //---------------------------------------------------------------------------------------------------------

        displayPanel.setLayout(new BoxLayout(displayPanel, BoxLayout.Y_AXIS));

        displayPanel.add(firstNameL);
        displayPanel.add(firstName);
        displayPanel.add(lastNameL);
        displayPanel.add(lastName);
        displayPanel.add(stAddressL);
        displayPanel.add(stAddress);
        displayPanel.add(cityL);
        displayPanel.add(city);
        displayPanel.add(zipCodeL);
        displayPanel.add(zipCode);
        displayPanel.add(phoneNumberL);
        displayPanel.add(phoneNumber);
        displayPanel.add(emailL);
        displayPanel.add(email);

        panel.setLayout(new GridLayout(1, 2));
        panel.add(listPanel);
        panel.add(displayPanel);

        frame.setContentPane(panel);
        frame.pack();
        frame.setVisible(true);

    }
}

class ContactRenderer extends JLabel implements ListCellRenderer {
    private static final Color HIGHLIGHT_COLOR = new Color(0, 0, 128);

    public ContactRenderer() {
        setOpaque(true);
    }

    public Component getListCellRendererComponent(JList list, Object value,
                                                  int index, boolean isSelected, boolean cellHasFocus) {
        Contact c = (Contact) value;
        setText(c.getFirstName());

        if (isSelected) {
            setBackground(HIGHLIGHT_COLOR);
            setForeground(Color.white);
        } else {
            setBackground(Color.white);
            setForeground(Color.black);
        }
        return this;
    }
}
