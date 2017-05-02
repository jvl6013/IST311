package ist311;

import java.io.*;
import java.util.List;

/**
 * Created by fivewen on 5/1/17.
 */
public class Serialization {
    public void serializeTaskList(List<Task> tList, String fileName) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fileName))) {
            out.writeObject(tList);
        } catch (IOException e) {
            System.out.println("A problem has occured during task list serialization");
            System.out.println(e.getMessage());
        }
    }

    public void serializeContactList(List<Contact> cList, String fileName) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fileName))) {
            out.writeObject(cList);
        } catch (IOException e) {
            System.out.println("A problem has occured during contact list serialization");
            System.out.println(e.getMessage());
        }
    }

    public void serializeUserList(List<String> uList, String fileName) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fileName))) {
            out.writeObject(uList);
        } catch (IOException e) {
            System.out.println("A problem has occured during user list serialization");
            System.out.println(e.getMessage());
        }
    }

    public List<Contact> deserializeContactList(String fileName) {
        List<Contact> cList = null;
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(fileName))){
            cList = (List<Contact>) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.printf("A problem ocurred deserializing %s%n", fileName);
            System.out.println(e.getMessage());
        }

        return cList;

    }

    public List<Task> deserializeTaskList(String fileName) {
        List<Task> tList = null;
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(fileName))){
            tList = (List<Task>) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.printf("A problem occurred deserialization %s%n", fileName);
            System.out.println(e.getMessage());
        }

        return tList;

    }

    public List<String> deserializeUserList(String fileName) {
        List<String> uList = null;
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(fileName))){
            uList = (List<String>) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.printf("A problem occurred deserialization %s%n", fileName);
            System.out.println(e.getMessage());
        }

        return uList;

    }
}
