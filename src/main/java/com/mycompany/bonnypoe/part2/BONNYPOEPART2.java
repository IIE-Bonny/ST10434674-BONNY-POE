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

       

    

        //declare variables
        String username;
        String password;
        
        
       

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
        
        if(registerMessage.equals("Both Username and password successfully captured")){
            String loginUsername = JOptionPane.showInputDialog("Enter your username to log in:");
            String loginPassword = JOptionPane.showInputDialog("Enter your password to log in:");
            
            String loginMessage = login_checks.loginUser(username, password);
            
            JOptionPane.showMessageDialog(null, loginMessage);
            
            
              //Task instance
        Task task_manager = new Task();
        
        boolean convertedBoolean=true;int choice =0;
              //Main loop to keep the application running until the user quits
       
//                String[] option = {"1.Add Tasks", "2.Show Report(Coming Soon)", "3.Quit"};
//                choice = JOptionPane.showOptionDialog(null, "Choose an option from 1-3", "Menu", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE,null,
//                 new String[] {"1.Add tasks", "2.Show Report", ".3.Quit"}, "Add task");
           String input = JOptionPane.showInputDialog("Choose an option\n" +
                   "1. Add task\n" +
                   "2. Show Report\n" +
                   "3. Quit\n\n" +
                   "Enter the number of your choice");
           if(input == null || input.trim().isEmpty()){
               JOptionPane.showMessageDialog(null, "No option selected, try again");
           }
           //This parses the string input into an integer
            choice = Integer.parseInt(input.trim());
                switch (choice) {
                    case 1:
                        //User selected "Add Task"
                        addTasks();
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
    private static void addTasks(){
        int numTasks = Integer.parseInt(JOptionPane.showInputDialog("Enter number of tasks:"));
        ArrayList<Task> task = new ArrayList<>();
        int totalHours = 0;
        
                        //numTasks = task_manager.taskDuration;
                       

                        //Collect task details and create tasks
                        for (int i = 0; i < numTasks; i++) {
                           Task task_manager = new Task();
                           task_manager.taskName= JOptionPane.showInputDialog("Enter task Name: ");
                           do{
                           task_manager.taskDescription = JOptionPane.showInputDialog("Enter Task Description(max 50 characters): ");
                           if(task_manager.taskDescription.length() >50){
                               task_manager.taskDescription = JOptionPane.showInputDialog("Description too long.", "Please enter task description of less than 50 characters");
                           }else{
                               JOptionPane.showMessageDialog(null, "Task successfully captured.");
                               break;
                           }
                           }while (task_manager.taskDescription.length() > 50);
                           

                            //Validate task description length
                            task_manager. developerDetails = JOptionPane.showInputDialog("Enter Developer's Name: ");
                            int Duration = Integer.parseInt(JOptionPane.showInputDialog("Enter Task Duration\n(in hours):"));
                           
                            task_manager. taskStatus = JOptionPane.showInputDialog("Enter Task Status(TO DO, DONE, DOING): ");

                            //Task task_details = new Task();
                            
                            task.add(task_manager);
                            totalHours +=  Duration;
                            
                            //add to array list
                          //  task_details.Tasks(taskName, taskDescription, developerDetails, taskDuration, taskStatus);
                          
//                            //call constructor
//                            Task obj = new Task();
                            //Display the task details
                            JOptionPane.showMessageDialog(null, task_manager.printTaskDetails(task_manager.taskName,task_manager. taskDescription, task_manager.taskID, task_manager.developerDetails,task_manager.Duration, task_manager.taskStatus));
                            
                            JOptionPane.showMessageDialog(null, "The total duration is:" + totalHours);
     
                        }
    }
}
                                      
  
