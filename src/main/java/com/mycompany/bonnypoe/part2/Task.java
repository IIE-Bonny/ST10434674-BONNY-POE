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
    public int taskNumber= 0;
    public String taskDescription = "";
    public String developerDetails = "";
    public double Duration = 0;
    public int totalDuration = 0;
    public int numTasks = 0;
    public String taskID = "";
    public String taskStatus = "";
    
    //Counter to auto-generate task numbers
    private static int taskCounter = 0;
    

    //Task method
    //This method ensures that the task description is no more than 50 characters
    public boolean checkTaskDescription(){
        if(taskDescription.length() > 50){
             JOptionPane.showMessageDialog(null, "Description too long.", "Please enter task description of less than 50 characters", JOptionPane.WARNING_MESSAGE);
               taskDescription = taskDescription.substring(0, 50);
        }
       
       return true;   
    }
    //Generates Task ID in the formate of-
    //first 2 letters of task name:task number:last 3 letters of the developer
    public String createTaskID(){
       String taskNamePart;
       String developerPart;
       
       taskNamePart = taskName.substring(0,2).toUpperCase();
        developerPart = developerDetails.substring(developerDetails.length() - 3).toUpperCase();
//       if(taskName.length() >= 2 && developerDetails.length() >= 50 ){
//            taskNamePart = taskName.substring(0,2).toUpperCase();
//            //taskNamePart = taskName.toUpperCase();
//            developerPart = developerDetails.substring(developerDetails.length() - 3).toUpperCase();
//          // developerPart = developerDetails.toUpperCase();
//       }else{
//          JOptionPane.showMessageDialog(null, "Error encountered while formatting task ID");
//       }if(taskName.length() >= 2 && developerDetails.length() >= 50 ){
//       

       
        return taskNamePart + ":" + taskNumber + ":" + developerPart;
    }
    //Returns the task information as a formatted string
    //This method returns the full task details of each task
    public String printTaskDetails(String taskName, String taskDescription, String developerDetails,double  Duration, String taskStatus){
        return "Task ID:" + taskID + "\nTask Name:" 
                + taskName + "\nTaskNumber: " 
                + taskNumber +"\nTaskDescription: " 
                + taskDescription + "\nDeveloper: " +developerDetails 
                + "\nDuration: " + Duration + "\nhours\nstatus: " + taskStatus;
        
    } 
    
   
        private static List<Integer> totalTaskDuration = new ArrayList<>();
    //returnTotalHours method
    //This method returns the total combined houurs of all tasks
    public double returnTotalHours(){
        
        
            return  Duration;
        }
        
    }

