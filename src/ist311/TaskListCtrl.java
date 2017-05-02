/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ist311;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author jvl6013
 */
public class TaskListCtrl {
    List<Task> taskList;
    Serialization serialize = new Serialization();
    String username;

    public TaskListCtrl(String username) {
        this.username = username;

        taskList = new ArrayList<Task>();

        taskList = serialize.deserializeTaskList("users/" + this.username + "/TaskList.ser");
    }

    public void addTask(String taskName, String taskDescription, Date dueDate) {

        serialize.serializeTaskList(taskList, "users/" + this.username + "/TaskList.ser");
    }

    public void addTask(Task t) {
        taskList.add(t);
        serialize.serializeTaskList(taskList, "users/" + this.username + "/TaskList.ser");
    }

    public void deleteTask(int index) {
        taskList.remove(index);
        serialize.serializeTaskList(taskList, "users/" + this.username + "/TaskList.ser");
    }

    public void setTask(int index, String taskName, String taskDescription, Date dueDate) {
        taskList.get(index).setTaskDescription(taskDescription);
        taskList.get(index).setTaskName(taskName);
        taskList.get(index).setTaskDueDate(dueDate);
        serialize.serializeTaskList(taskList, "users/" + this.username + "/TaskList.ser");
    }

    public List<Task> searchTask(String term) {
        if(term.isEmpty()) {
            return taskList;
        }

        term = term.toLowerCase();

        List<Task> searchedTaskList = new ArrayList<Task>();

        for(int i = 0; i < taskList.size(); i++) {
            if(taskList.get(i).getTaskName().toLowerCase().contains(term)){
                searchedTaskList.add(taskList.get(i));
            }
            else if(taskList.get(i).getTaskDescription().toLowerCase().contains(term)){
                searchedTaskList.add(taskList.get(i));
            }
        }

        return searchedTaskList;
    }

    
    public List<Task> getTaskList(){
        return taskList;
    }
}
