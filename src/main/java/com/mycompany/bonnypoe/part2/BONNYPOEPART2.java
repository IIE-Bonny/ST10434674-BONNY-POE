/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.bonnypoe.part2;

import java.util.Scanner;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;

/**
 *
 * @author B.O.N.N.Y
 */
public class BONNYPOEPART2 {

    public static void main(String[] args) {
     
         //Login instance
        Login login_checks = new Login();
              
           // object for a scanner
        Scanner sc = new Scanner(System.in);
       
        
         //declare variables
        String name = "";
        String Lastname = "";
        String username = "";
        String password = "";
        int taskCount = 0;
        
        
        
          //Promting the user for username and password
          System.out.println("Enter your name");
          name = sc.nextLine();
          System.out.println("Enter your lastname");
          Lastname = sc.nextLine();
          
          //use do while
        do{
            //prompt
            System.out.println("Create a username");
            username = sc.nextLine();
        }while( !login_checks.checkUserName(username));
        
        //user do while for password
        do{
            //prompt
            System.out.println("Enter password: ");
            password = sc.nextLine();
        }while(!login_checks.checkPasswordComplexity(password));
        
       //Display Welcome message
       JOptionPane.showMessageDialog(null, "Welcome to EasyKanban!", "EasyKanban", JOptionPane.INFORMATION_MESSAGE);
       
        String booleanString = login_checks.returnLoginStatus(true);
       //Use of Boolean.parseBoolean() to convert thestring to a boolean
       //The parseBoolean() method checks the string and converts it to a boolean.
       //If the string is exactly "true" (ignoring case), it return true.
        boolean convertedBoolean = Boolean.parseBoolean(booleanString);
       
       //Use the converted boolean in an if statement
       //This checks the value of the converted boolean and executes
       //Display menu after user has logged in
       if(convertedBoolean){
           //Main loop to keep the application running until the user quits
           while(convertedBoolean){
        String[] option = {"Add Tasks","Show Report(Coming Soon)","Quit"};
        int choice = JOptionPane.showOptionDialog(null, "Choose an option", "Menu", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, option, option[0]);
        
        switch(choice){
            case 1:
                //User selected "Add Task"
                createTaskID();
                break;
            case 2:
                //User selected "Show Report",which is not yet available
                JOptionPane.showMessageDialog(null, "Coming Soon", "Report", JOptionPane.INFORMATION_MESSAGE);
                break;
            case 3:
                //User selected "Quit", exit the loop
                convertedBoolean = false;
                JOptionPane.showMessageDialog(null, "Exiting EasyKanban\n Goodbye", "Exit", JOptionPane.INFORMATION_MESSAGE);
                
        }
    }
       }
       //Loop to gather details for each task
       for(int i = 0; i <taskCount; i++){
           //Get task name
           String taskName = JOptionPane.showInputDialog("Enter Task Name " +(i+1)+ ":");
           
           //Get taskDescription and ensure its not longer than 50 characters
           String taskDescription = JOptionPane.showInputDialog("Enter Task Description(max 50 characters):");
           
           //Get developer details
           String developerDetails = JOptionPane.showInputDialog("Enter Developer's Frst and Last Name: ");
           
           //Get task Duration and ensure its a valid number
           String taskDurationStr = JOptionPane.showInputDialog("Enter Task Duration(in hours): ");
           //Convert to integer
           int taskDuration = Integer.parseInt(taskDurationStr);
           
           //Ask user to choose task status from a list
           String[] statusOptions = {"TO DO","DOING","DONE"};
           int StatusChoice = JOptionPane.showOptionDialog(null, "Select Task Status", "Task Status", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE,null, statusOptions, statusOptions[0]);
           
           
           
       }

        int numTasks = Integer.parseInt(JOptionPane.showInputDialog("Enter number of tasks:"));
        Task[] tasks = new Task[numTasks];
        
        //Collect task details and create tasks
        for(int i = 0; i < numTasks; i++){
            String taskName = JOptionPane.showInputDialog("Enter task Name: ");
            String taskDescription = JOptionPane.showInputDialog("Enter Task Description(max 50 characters): ");
            
            //Validate task description length
            while(taskDescription.length() > 50){
                taskDescription = JOptionPane.showInputDialog("Task description is too long. Please enter a description less than 50 characters: ");
            }
            String developerDetails = JOptionPane.showInputDialog("Enter Developer's Name: ");
            int taskDuration = Integer.parseInt(JOptionPane.showInputDialog("Enter Task Duration(in hours):"));
            String taskStatus = JOptionPane.showInputDialog("Enter Task Status(TO DO, DONE, DOING): ");
            
            //Create a new task object and store it in the array
            tasks[i] = new Task(String taskName, String taskDescription, String developerDetails, int taskDuration, String taskStatus);
            
            //Display the task details
            JOptionPane.showMessageDialog(null, tasks[i].printTaskDetails());
        }
        //Calculate the total duration of all tasks
        int totalDuration = 0;
        for(Task task : tasks){
            totalDuration += taskDuration;
        }
        JOptionPane.showMessageDialog(null, "Total task Duration: " + totalDuration + "hours");
    }
}
