/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ist311;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jvl6013
 */
public class ContactListCtrl {
    List<Contact> contactList;
    Serialization serialize = new Serialization();
    String username;

    public ContactListCtrl(String username) {
        this.username = username;

        contactList = new ArrayList<Contact>();
        contactList = serialize.deserializeContactList("users/" + this.username + "/ContactList.ser");
    }

    public void addContact(String firstName, String lastName, String stAddress, String city, String zipCode, String phoneNumber, String email) {
        contactList.add(new Contact(firstName, lastName, stAddress, city, zipCode, phoneNumber, email));
        serialize.serializeContactList(contactList, "users/" + username + "/ContactList.ser");
    }

    public void addContact(Contact c) {
        contactList.add(c);
        serialize.serializeContactList(contactList, "users/" + username + "/ContactList.ser");
    }

    public void deleteContact(int index) {
        contactList.remove(index);
        serialize.serializeContactList(contactList, "users/" + username + "/ContactList.ser");
    }

    public void setContact(int index, String firstName, String lastName, String stAddress, String city, String zipCode, String phoneNumber, String email) {
        contactList.get(index).setName(firstName, lastName);
        contactList.get(index).setAddress(stAddress, city, zipCode);
        contactList.get(index).setPhoneNumber(phoneNumber);
        contactList.get(index).setEmail(email);
        serialize.serializeContactList(contactList, "users/" + username + "/ContactList.ser");
    }

    public List<Contact> searchContact(String term) {
        if(term.isEmpty()) {
            return contactList;
        }

        term = term.toLowerCase();

        List<Contact> searchedContactList = new ArrayList<Contact>();

        for(int i = 0; i < contactList.size(); i++) {
            if(contactList.get(i).getFirstName().toLowerCase().contains(term)){
                searchedContactList.add(contactList.get(i));
            }
            else if(contactList.get(i).getLastName().toLowerCase().contains(term)){
                searchedContactList.add(contactList.get(i));
            }
        }

        return searchedContactList;
    }


    public List<Contact> getContactList(){
        return contactList;
    }
}
