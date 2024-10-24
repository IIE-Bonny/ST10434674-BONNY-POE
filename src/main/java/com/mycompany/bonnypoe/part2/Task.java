/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bonnypoe.part2;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.*;

/**
 *
 * @author B.O.N.N.Y
 */
public class Task {
    //Declaration of task variables
    private String taskName;
    private int taskNumber;
    private String taskDescription;
    private String developerDetails;
    private int taskDuration;
    private String taskID;
    private String taskStatus;
    
    //Counter to auto-generate task numbers
    private static int taskCounter = 0;
    
    //Constructor to initialize all task details and generate the task ID
    public Task(String taskName, int taskNumber, String taskDescription,String developerDetails, int taskDuration, String taskStatus){
        //Assigning of variables
        this.taskName = taskName;
        this.taskNumber = taskNumber;
        this.taskDescription = taskDescription;
        this.developerDetails = developerDetails;
        this.taskDuration = taskDuration;
        this.taskStatus = taskStatus;
        this.taskID = createTaskID();
    }
    //Task method
    //This method ensures that the task description is no more than 50 characters
    private boolean checkTaskDescription(){
        if(taskDescription.length() > 50){
             JOptionPane.showMessageDialog(null, "Description too long.", "Please enter task description of less than 50 characters", JOptionPane.WARNING_MESSAGE);
               taskDescription = taskDescription.substring(0, 50);
        }
       
       return true;   
    }
    //Generates Task ID in the formate of-
    //first 2 letters of task name:task number:last 3 letters of the developer
    private String createTaskID(){
       String taskNamePart;
       String developerPart;
       if(taskName.length() >= 2){
           taskNamePart = taskName.substring(0,2).toUpperCase();
       }else{
           taskNamePart = taskName.toUpperCase();
       }
       if(developerDetails.length() >= 3){
           developerPart = developerDetails.substring(developerDetails.length() - 3).toUpperCase();
       }else{
           developerPart = developerDetails.toUpperCase();
       }
        return taskNamePart + ":" + taskNumber + ":" + developerPart;
    }
    //Returns the task information as a formatted string
    //This method returns the full task details of each task
    public String printTaskDetails(){
        return "Task ID:" + taskID + "\nTask Name:" 
                + taskName + "\nTaskNumber: " 
                + taskNumber +"\nTaskDescription: " 
                + taskDescription + "\nDeveloper: " +developerDetails 
                + "\nDuration: " + taskDuration + "\nhours\nstatus: " + taskStatus;
        
    } 
    //returnTotalHours method
    //This method returns the total combined houurs of all tasks
    private int returnTotalHours(){
        return taskDuration;
    }
}
