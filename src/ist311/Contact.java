package ist311;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by fivewen on 4/21/17.
 */
public class Contact implements Serializable{
    String firstName, lastName, stAddress, city, zipCode, phoneNumber, email;

    public Contact(String firstName, String lastName, String stAddress, String city, String zipCode, String phoneNumber, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.stAddress = stAddress;
        this.city = city;
        this.zipCode = zipCode;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setName(String fName, String lName) {
        firstName = fName;
        lastName = lName;
    }

    public void setAddress(String stAddress, String city, String zipCode) {
        this.stAddress = stAddress;
        this.city = city;
        this.zipCode = zipCode;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
