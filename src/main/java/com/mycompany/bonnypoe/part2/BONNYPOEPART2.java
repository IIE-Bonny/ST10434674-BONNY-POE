/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.bonnypoe.part2;

import java.util.*;
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
        String username;
        String password;
        int taskCount = 0;

        //Promting the user for username and password
        String name = JOptionPane.showInputDialog("Enter your name");
        String Lastname = JOptionPane.showInputDialog("Enter your lastname");
        
        
       

        //use do while
        do {
            //prompt
            //System.out.println("Create a username");
            username = JOptionPane.showInputDialog("Create a username");
        } while (!login_checks.checkUserName(username));

        //user do while for password
        do {
            //prompt
            password = JOptionPane.showInputDialog("Create a password");
        } while (!login_checks.checkPasswordComplexity(password));
        
        String registerMessage = login_checks.registerUser(name, Lastname, username, password);
        JOptionPane.showMessageDialog(null, registerMessage);
        
        if(registerMessage.equalsIgnoreCase("User registered successfully")){
            String loginUsername = JOptionPane.showInputDialog("Enter your username to log in:");
            String loginPassword = JOptionPane.showInputDialog("Enter your password to log in:");
            
            String loginMessage = login_checks.loginUser(username, password);
            
            JOptionPane.showMessageDialog(null, loginMessage);
        }
         //Task instance
        Task task_manager = new Task();

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
        if (convertedBoolean) {
            //Main loop to keep the application running until the user quits
            while (convertedBoolean) {
                String[] option = {"Add Tasks", "Show Report(Coming Soon)", "Quit"};
                int choice = JOptionPane.showOptionDialog(null, "Choose an option", "Menu", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, option, option[0]);

                switch (choice) {
                    case 1:
                        //User selected "Add Task"
                        int numTasks = Integer.parseInt(JOptionPane.showInputDialog("Enter number of tasks:"));
                        Task[] tasks = new Task[numTasks];
                        ArrayList<Task> task = new ArrayList<Task>();

                        //Collect task details and create tasks
                        for (int i = 0; i < numTasks; i++) {
                            String taskName = JOptionPane.showInputDialog("Enter task Name: ");
                            String taskDescription = JOptionPane.showInputDialog("Enter Task Description(max 50 characters): ");

                            //Validate task description length
                            while (taskDescription.length() > 50) {
                                taskDescription = JOptionPane.showInputDialog("Task description is too long. Please enter a description less than 50 characters: ");
                            }
                            String developerDetails = JOptionPane.showInputDialog("Enter Developer's Name: ");
                            int taskDuration = Integer.parseInt(JOptionPane.showInputDialog("Enter Task Duration(in hours):"));
                            String taskStatus = JOptionPane.showInputDialog("Enter Task Status(TO DO, DONE, DOING): ");

                            Task task_details = new Task(taskName, taskDescription, developerDetails, taskDuration, taskStatus);
                            //add to array list
                            task.add(task_details);

                            //Display the task details
                            JOptionPane.showMessageDialog(null, task_manager.printTaskDetails(taskName, taskDescription, developerDetails, taskDuration, taskStatus));
                }
                        ;

                        break;
                    case 2:
                        //User selected "Show Report",which is not yet available
                        JOptionPane.showMessageDialog(null, "Coming Soon", "Report", JOptionPane.INFORMATION_MESSAGE);
                        break;
                    case 3:
                        //User selected "Quit", exit the loop
                       convertedBoolean = false;
                        JOptionPane.showMessageDialog(null, "Exiting EasyKanban\n Goodbye", "Exit", JOptionPane.INFORMATION_MESSAGE);
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "Invalid Option\n try again\n");

                }
            }
        }

        //call constructor
        
        //task id
        task_manager.createTaskID();
        //hours
        task_manager.returnTotalHours();
        //Calculate the total duration of all tasks
        int totalDuration = 0;
        //for(Task task : tasks){
        //totalDuration += task_manager.returnTotalHours();
        //}
        JOptionPane.showMessageDialog(null, "Total task Duration: " + totalDuration + "hours");
    }
}
