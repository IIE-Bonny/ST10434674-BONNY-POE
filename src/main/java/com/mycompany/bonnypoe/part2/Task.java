/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bonnypoe.part2;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import javax.swing.*;

/**
 *
 * @author B.O.N.N.Y
 */
public class Task {
    //Declaration of task variables
    public String taskName="";
    public int taskNumber;
    public String taskDescription = "";
    public String developerDetails = "";
    public int Duration;
    public int numTasks;
    public String taskID;
    public String taskStatus = "";
    
    public Task(){
        this.Duration = Duration;
        this.taskID = taskID;
    }
    
    
        //Task method
    //This method ensures that the task description is no more than 50 characters
    public boolean checkTaskDescription(){
      return taskDescription.length() > 50;   
    }
    //Generates Task ID in the formate of-
    //first 2 letters of task name:task number:last 3 letters of the developer
    public String createTaskID(){
       taskID = taskName.substring(0,2).toUpperCase() + ":" +  taskNumber + ":" + developerDetails.substring(developerDetails.length() - 3).toUpperCase();
//       if(taskName.length() >= 2 && developerDetails.length() >= 50 ){
//            taskNamePart = taskName.substring(0,2).toUpperCase();
//            //taskNamePart = taskName.toUpperCase();
//            developerPart = developerDetails.substring(developerDetails.length() - 3).toUpperCase();
//          // developerPart = developerDetails.toUpperCase();
//       }else{
//          JOptionPane.showMessageDialog(null, "Error encountered while formatting task ID");
//       }if(taskName.length() >= 2 && developerDetails.length() >= 50 ){
//
        return taskID;
    }
    //Returns the task information as a formatted string
    //This method returns the full task details of each task
    public String printTaskDetails(String taskName, String taskDescription,String taskID, String developerDetails,int  Duration, String taskStatus){
        return "Task ID:" + taskID + "\nTask Name:" 
                + taskName + "\nTaskNumber: " 
                + taskNumber +"\nTaskDescription: " 
                + taskDescription + "\nDeveloper: " +developerDetails 
                + "\nDuration: " + Duration + "\nhours\nstatus: " + taskStatus;
        
    } 
    
   
        //private static List<Integer> totalTaskDuration = new ArrayList<>();
    //returnTotalHours method
    //This method returns the total combined houurs of all tasks
    public int returnTotalHours(){
        
            return  Duration;
        }
        
    }

