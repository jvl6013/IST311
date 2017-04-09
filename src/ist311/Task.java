/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ist311;

import java.util.Date;

/**
 *
 * @author jvl6013
 */
public class Task {
    String taskName, taskDescription;
    Date taskDueDate, taskCreatedDate;
    
    public Task(String taskName, String taskDescription, Date taskDueDate){
        this.taskName = taskName;
        this.taskDescription = taskDescription;
        this.taskDueDate = taskDueDate;
        taskCreatedDate = new Date();
    }
    
    public String getTaskName(){
        return taskName;
    }
    
    public void setTaskName(String taskName){
        this.taskName = taskName;
    }
    
    public String getTaskDescription(){
        return taskDescription;
    }
    
    public void setTaskDescription(String taskDescription){
        this.taskDescription = taskDescription;
    }
    
    public Date getTaskDueDate(){
        return taskDueDate;
    }
    
    public void setTaskDueDate(Date taskDueDate){
        this.taskDueDate = taskDueDate;
    }
}
