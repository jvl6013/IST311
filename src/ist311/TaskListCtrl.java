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

    public TaskListCtrl() {
        taskList = new ArrayList<Task>();
    }

    public void addTask(String taskName, String taskDescription, Date dueDate) {
        taskList.add(new Task(taskName, taskDescription, dueDate));
    }

    public void addTask(Task t) {
        taskList.add(t);
    }

    public void deleteTask(int index) {
        taskList.remove(index);
    }

    public void setTask(int index, String taskName, String taskDescription, Date dueDate) {
        taskList.get(index).setTaskDescription(taskDescription);
        taskList.get(index).setTaskName(taskName);
        taskList.get(index).setTaskDueDate(dueDate);
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
